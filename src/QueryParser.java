import gen.ViewBaseListener;
import gen.ViewParser;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;



public class QueryParser extends ViewBaseListener {



    protected Set<String> viewsInSystem = new HashSet<>();



/**
 * First Section: All objects used for the DEPENDENCY TABLE
 * ********/
    //First: the dependency table.
    //Second: a list of labels that are affected: this will be added to during parsing and used at the end to
    //          attach all EntryData objects to the TableEntry object which are pointed to by the keys in this list.
    protected DependencyTable dependencyTable = new DependencyTable();
    protected List<String> labelsAffected = new LinkedList<>();
    final String NODESTARLABEL = "_ENTRY_SPECIAL_NODE_STAR_";
    final String RELSTARLABEL = "_ENTRY_SPECIAL_REL_STAR_";
    final String RELNONAME = "_ENTRY_SPECIAL_NO_REL_NAME_";

    //required during parsing to create associations between variable names and their label key for the depend.table
    private Map<String, String> varLabels = new HashMap<>();
    private Map<String, Set<Condition>> varConditions = new HashMap<>(); //Stores variables and the set of conditions that are used.

    //set of dependents for a view creation: this will always contain the view created and possibly more if the view refers to other views
    protected List<String> dependents;

/**
 * Second Section: All objects used for keeping track of the VIEW QUERY ITSELF
 * **/




    //changeMeta stores a list of metadata objects that must be true in order for the change to apply.
    //it can be compared with all metadata entries in metadataTable to locate the views that must be updated as a result.
    protected List<MetaData> changeMeta = new LinkedList<>();
    private String setRemoveCGToken = ""; //local to exitChangeGraph, can be declared locally
    public List<String> outdatedViews = new LinkedList<>();
    private String setRemoveCGType = ""; //necessary for communication between View

    //View table - stores all views that return sets of nodes and the nodes that it should contain
    //key : view name. value : set of node identifiers

    public Set<String> viewInstants = new HashSet<>();


    private String viewName;
    private boolean isViewInstant = false;
    private boolean isViewUse = false;

    private String returnValExpr = "";
    private String pathName = "";
    private LinkedList<ViewParser.BoolexprContext> conditions = new LinkedList<ViewParser.BoolexprContext>();

    private boolean viewScope = true; //true -> scope is purely the view for viewusage. default. false -> global db scope

    /*
     *  The following two tables are symbol tables used for view usage. Proper query syntax assumes that
     *  symbols are not repeated so this is not enforced in the middle-ware.
     *
     *  Upon a view usage, we must check whether the user wants to restrict the usage to the view or
     *  use entities of the view in a general query on the graph data-base.
     *
     * An example of a query restricted to a view:
     *       USE VIEW myPathView MATCH  p = (n:Person)-[:Follows]-(m:Person) WHERE n.age > 18 RETURN ...
     *   - Not specifying that p IN myPathView indicates that the user wants all paths that satisfy the age condition
     *       to be in the view myPathView. The Follows relationship must also be contained within the view. Essentially
     *       this query first retrieves all paths then filters by the age.
     *
     * An example of a query non-restricted to a view: (this is global)
     *       USE VIEW myPathView WITH VIEWS secondPathView MATCH (n:Person)-[:Follows]-(m:Person) WHERE n IN myPathView
     *           AND m IN secondPathView RETURN ...
     *   - This query means that while n must be a node contained within paths inside myPathView, we are interested in a
     *       general query over the whole graph database, but we want to begin with only nodes n,m inside myPathView and
     *       secondPathView. The two views used do not necessarily need to be path views; they can be node views as well.
     *       However this is supported with path views as well for added flexibility, since sometimes a user may want
     *       a generalized view that can be used for multiple purposes.
     *
     */
    private List<String> relSymbols = new LinkedList<>();
    private List<String> nodeSymbols = new LinkedList<>();


    /*
     * Following is used only to make sure the View.java class handled re-writing of view usage query
     */
    private boolean containsWhere = false;

    private Map<String, Set<ViewParser.BoolexprContext>> symbolTable = new ConcurrentHashMap<String, Set<ViewParser.BoolexprContext>>();
    //^Temporary. Upon exiting, it will attach these to meta-data table entries

    enum retType{
        DEFAULT,
        PATH,
        PATHNODES,
        NODE
    }

    private retType returnType = retType.DEFAULT;

    private LinkedList<String> thisQueryViews = new LinkedList<String>();

    //Below: Used for view use. Mainly to re-write the node queries
    //Maps node identifiers to a set of views (todo more efficient would be mapping view to nodes since node-view is 1:1 but view-node is 1:many)
    //
    // "MATCH (n)-[r]-(m) WHERE n IN view1" -> MATCH (n)-[r]-(m) WHERE id(n) IN [1, 2, ...]"
    // map would contain: key - n, value -view1
    public Map<String, Set<String>> addWhereClause = new ConcurrentHashMap<String, Set<String>>();


    private LinkedList<String> usedViews = new LinkedList<String>();

    public String changeGraphQuery = "";
    private boolean cg = false;


    @Override
    public void enterRoot(ViewParser.RootContext ctx){

        if(ctx.getChild(0).getText().contains("WITH VIEWS")){
            //viewUse
            isViewUse = true;


            if (ctx.getText().contains("IN")) {
                //global view usage todo use explicit global and local words in the lexer
                viewScope = false; //set to global
            }


        }
        else if(ctx.getChild(0).getText().equals("CG") || ctx.getText().contains("SET") ||
                ctx.getText().contains("DELETE") || ctx.getChild(3).getText().contains("CREATE")){

            //Change Graph
            cg = true;

            changeGraphQuery = ctx.getChild(1).getText();
            return;
        }
        else {
            //view init

            TerminalNode node = ctx.COMMAND();
            String name = node.getText();


            if (name.equals("CREATE VIEW AS")) {
                isViewInstant = true;

                int a = ctx.start.getStartIndex();
                int b = ctx.stop.getStopIndex();
                Interval interval = new Interval(a, b);
                String viewSql = ctx.start.getInputStream().getText(interval);


                //Storing it in case we need to re-execute this view
                viewInstants.add(viewSql);
            }




            viewName = ctx.NAME().getText();
            usedViews.add(viewName);
            viewsInSystem.add(viewName);


            //Adding this View as an entry to the dependency table (this entry contains no conditions by itself.)
            dependencyTable.put(viewName, new TableEntry(viewName));
            dependents = new LinkedList<>();
            dependents.add(viewName);
        }



        System.out.println(cg);

        //System.out.println(name);

    }


    @Override
    public void exitRoot(ViewParser.RootContext ctx){



    }

    @Override
    public void exitChangegraph(ViewParser.ChangegraphContext ctx){

        //At this point, all information should be ready for comparison.


    }



    @Override
    public void enterQuery(ViewParser.QueryContext ctx){


        //Comparing returnexpr and the path (if it exists).

        if(isViewUse || cg) return;

        ViewParser.ReturnstmtContext returnContext = ctx.returnstmt();
        if(returnContext.retval().getText().contains("NODES(")){
            returnType = retType.PATHNODES;

        }
        else if (!returnContext.retval().attribute().isEmpty()){
            returnValExpr = returnContext.retval().attribute().getText();
            returnType = retType.NODE;
        }
        else{
            returnValExpr = returnContext.retval().NAME().getText();
            returnType = retType.NODE;
        }

        if (ctx.getChild(1) instanceof ViewParser.PathContext) {
            pathName = ctx.path().NAME().getText();
            if(pathName.equals(returnValExpr)) returnType = retType.PATH;
        }
        else{
            //no pathname
        }

        System.out.println(returnType);

//        System.out.println(returnValExpr + pathName);





    }

    @Override
    public void exitQuery(ViewParser.QueryContext ctx){
        if(isViewUse || cg) return;
//        metaDataTable.get(viewName).setQuery(ctx);
    }

    @Override
    public void enterPath(ViewParser.PathContext ctx){
        if(isViewUse || cg) return;
        pathName = ctx.expr().getText();
    }


    @Override
    public void enterVariable(ViewParser.VariableContext ctx){

        //In the case of a view init:
        //Here we tag all variables with their labels (if any!). At the end of parsing, we can associate
        //each variable with their conditions as well.

        System.out.println("txt:" + ctx.getText() + ", " + ctx.getChildCount());

        if(isViewInstant) {

            int numChildren = ctx.getChildCount();
            String nodeName = "";
            String nodeLabel = "";

            if(numChildren == 3){
                //then we only have nodeName
                // view itself contains nodes not specified with label conditions (in which case, the view is expected to contain a large set of nodes).
                //this falls under the special node* entry.
                nodeName = ctx.getChild(1).getText();
                nodeLabel = NODESTARLABEL;


            }
            if(numChildren == 5){
                //we have a label associated with nodeName
                nodeName = ctx.getChild(1).getText();
                nodeLabel = ctx.getChild(3).getText();
            }

            if(!labelsAffected.contains(nodeLabel)) labelsAffected.add(nodeLabel);

            varLabels.put(nodeName, nodeLabel); //at the end, we will have a bunch and then re-organize by labels.

            System.out.println("Put into varLabels: " + nodeName + "," + nodeLabel);


        }


        if(isViewUse || cg){
            nodeSymbols.add(ctx.nodeName().getText());
        }
    }

    @Override
    public void enterViewatom(ViewParser.ViewatomContext ctx){

        //not used in this version of implementation

    }

    @Override
    public void enterRelation(ViewParser.RelationContext ctx){

        if(cg) return;

        if (ctx.getChildCount()==0) return;

        if((ctx.getText().contains(":") && ctx.getChildCount()==3) ||
                (!ctx.getText().contains(":") && ctx.getChildCount()==1))
            relSymbols.add(ctx.relationValue().getText());


        String relVar = "";
        String relLabel = "";

        if (ctx.getChildCount()==1){
            //not used now but may be useful
            if(ctx.getText().contains(":")){
                relVar = RELNONAME;
                relLabel = ctx.type().getText();
            }
            else{
                relVar = ctx.relationValue().getText();
                relLabel = RELSTARLABEL;
            }

        }
        else if (ctx.getChildCount()==3){
            //not used now but may be useful
            relVar = ctx.relationValue().getText();
            relLabel = ctx.type().getText();
        }

        varLabels.put(relVar, relLabel);



    }

    @Override
    public void exitViewatom(ViewParser.ViewatomContext ctx){




    }

    @Override
    public void enterUsedviews(ViewParser.UsedviewsContext ctx){

        if(cg) return;


        List<TerminalNode> used = ctx.NAME();
        for ( TerminalNode node : used){
            usedViews.add(node.getText());
        }
    }

    public void createDependencies(ViewParser.ViewatomContext ctx){

    }

    @Override
    public void exitConditions(ViewParser.ConditionsContext ctx){

        if(isViewUse|cg) return;

        //at this point all conditions should be set up in the table varConditions. (if it is a creation)

        Set<String> keys = varConditions.keySet();
        for(String key : keys){

            Set<Condition> conditionList = varConditions.get(key);
            List<Condition> list = new LinkedList<>();
            list.addAll(conditionList);

            //just converting to a list from a set^


            //Check if there already exists an EntryData with the EXACT SAME CONDITIONS
            String label = varLabels.get(key); //this is the label used to search dependency table, for example :Person

            System.out.println(key);

            if(dependencyTable.get(label)==null || dependencyTable.containsNoEntryData(label)){
                //if we are here, then there is no previous entry for this label at all: we can safely populate table without makign it messy.
                EntryData newEntryData = new EntryData();
                newEntryData.setConditions(list);
                newEntryData.setDependents(dependents);

                if(!dependencyTable.contains(label)){
                    dependencyTable.put(label, new TableEntry(label));
                }
                dependencyTable.get(label).addEntry(newEntryData);

                System.out.println("Here");

            }
            else{
                //this entry already has a TableEntry

                //so we compare ALL EntryData from this tableentry and see if one has EXACT same conditions..

                if(dependencyTable.get(label).addSameDependents(conditionList, dependents)){
                    //nothing to do here, it has been done in the method. probably should just write "if !..." for clarity
                }
                else{
                    //as with above, then there is no existing entry so we add a new entry to the existing TableEntry

                    EntryData entryData = new EntryData();
                    entryData.setConditions(list);
                    entryData.setDependents(dependents);


                    dependencyTable.get(label).addEntry(entryData);


                }

//                List<EntryData> existingEntries = dependencyTable.get(label).getEntries();
//
//                for(EntryData e : existingEntries){
//
//                    Set<Condition> existingConds = new HashSet<>(e.getConditions());
//
//                    if(existingConds.equals(conditionList)){
//                        //Then instead of creating a new EntryData we add onto this one.
//
//
////                        e.addDependent(dependents);
//
//                    }
//
//                }

                System.out.println("Here2");


            }








        }





//        //Using all symbols from symboltable (set-up from enterBoolexpr), attach these to meta-data table entries
//
//
//        for (String view : thisQueryViews){
//
//            Iterator<String> it = symbolTable.keySet().iterator();
//
//            while(it.hasNext()){
//
//                String symbol = it.next();
//                Set<ViewParser.BoolexprContext> conditionSet = symbolTable.get(symbol);
//
//                metaDataTable.get(view).conditions.addAll(conditionSet);
//
//
//            }
//
//
//        }
    }

    @Override
    public void enterConditions(ViewParser.ConditionsContext ctx){

        if(isViewUse) {

            if(ctx.getChildCount()>0){
                containsWhere = true;
            }

        }

    }

    @Override
    public void enterBoolexpr(ViewParser.BoolexprContext ctx){


        //todo have not yet decided how to handle VIEWS that contain OR clauses:
        //intuitively they should be treated just like an AND ... but special attention can be given if we deem it necessary, later.


        if(isViewUse) {

            //Using a view: this catches the case when we see "n IN v1"

            if(ctx.getText().contains("IN") && !ctx.getText().contains("AND") && !ctx.getText().contains("OR")) {
                String viewNodeName = ctx.NAME(0).getText(); //not necessarily node. can be path symbol too
                String viewUsedName = ctx.NAME(1).getText();

                assert viewsInSystem.contains(viewUsedName);
                assert usedViews.contains(viewUsedName);

                if (addWhereClause.containsKey(viewNodeName)) {
                    addWhereClause.get(viewNodeName).add(viewUsedName);
                } else {
                    addWhereClause.put(viewNodeName, new HashSet<String>());
                    addWhereClause.get(viewNodeName).add(viewUsedName);
                }
            }

        }

        else if(cg){


        }



        //Keep LHS of each condition inside the symbolTable
        else {

            ParseTree child1 = ctx.getChild(0);
            ParseTree child2 = ctx.getChild(2);

            Object payload1 = child1.getPayload();
            Object payload2 = child2.getPayload();
            //A note about these payloads... it is actually valid for us to have something like,
            //"WHERE a.name = b.name"
            //In this case (not yet covered in writing), we should have some default condition on name such that it is triggered whenever a change on name
            //appears. todo.

            if (payload1 instanceof ViewParser.AttributeContext) {
                System.out.println(((ViewParser.AttributeContext) payload1).getText());

                String keyname = ((ViewParser.AttributeContext) payload1).getText().split("\\.")[0];
                String attributename = ((ViewParser.AttributeContext) payload1).getText().split("\\.")[1];


                if (payload2 instanceof ViewParser.ValContext){
                    String rhsVal = ((ViewParser.ValContext)payload2).getText();

                    Condition condition = new Condition();
                    condition.setAttribute(attributename);
                    condition.setConditionString(attributename + ctx.getChild(1).getText()+rhsVal);


                    System.out.println(condition.getConditionString());

                    if(!varConditions.containsKey(keyname)) varConditions.put(keyname, new HashSet<Condition>());
                    varConditions.get(keyname).add(condition);


                }


            }
        }
    }

    public boolean getViewScope(){
        return viewScope;
    }

    public void clearAll(){


        /* first these three*/
        labelsAffected = new LinkedList<>();
        varConditions = new HashMap<>();
        varLabels = new HashMap<>();


        //does not clear viewInstants; this should be called separately

        usedViews = new LinkedList<String>();
        thisQueryViews = new LinkedList<String>();

        relSymbols = new LinkedList<>();
        nodeSymbols = new LinkedList<>();

        viewName = "";
        isViewInstant = false;
        isViewUse = false;
        viewScope = true;


        returnValExpr = "";
        pathName = "";
        returnType = retType.DEFAULT;
        symbolTable = new ConcurrentHashMap<String, Set<ViewParser.BoolexprContext>>();
        addWhereClause = new ConcurrentHashMap<>();

        changeMeta = new LinkedList<>();
        setRemoveCGToken = "";
        setRemoveCGType = "";

        cg = false;
        changeGraphQuery = "";
    }

    public void changeGraph(){
        clearAll();

//        viewTable = new ConcurrentHashMap<>();
//        metaDataTable = new ConcurrentHashMap<>();

    }

    public void removeOutdated(){
        outdatedViews = new LinkedList<>();
    }

    public Set<String> getViewInstants(){
        return viewInstants;
    }

    public String getViewName(){
        return viewName;
    }

    public boolean containsWhere(){
        return containsWhere;
    }

    public boolean isViewInstant(){
        return isViewInstant;
    }

    public boolean isViewUse() {
        return isViewUse;
    }

    public List<String> relationSymbols(){
        return relSymbols;
    }

    public List<String> nodeSymbols(){
        return nodeSymbols;
    }

    public LinkedList<String> usedViews(){
        return usedViews;
    }

    public String getChangeGraphQuery(){
        return changeGraphQuery;
    }

    public boolean isCg(){
        return cg;
    }

    public String getReturnValExpr() {
        return returnValExpr;
    }

    public retType getReturnType() {
        return returnType;
    }


    //Returns a set of strings corresponding to all non-hidden views which must be updated by re-evaluation
    //example: this may decide that views v1 and v3 must be reevaluated but not v2, etc.
    //input : a list of view names
//    public LinkedList<String> recursiveUpdate(LinkedList<String> list){

    //todo outdated; redo this code but with the dependency table
//
//        LinkedList<String> updatesRequired = new LinkedList<>();
//
//        boolean hasBeenUpdated = true;
//
//        while (hasBeenUpdated) {
//            hasBeenUpdated = false;
//            Iterator<String> it = viewTable.keySet().iterator();
//
//
//            LinkedList<String> toAdd = new LinkedList<>();
//
//            while(it.hasNext()){
//                String key = it.next();
//                Set<String> dependents = viewTable.get(key);
//
//                for(String viewname : list){
//                    if(dependents.contains(viewname) && !list.contains(key)){
//                        hasBeenUpdated = true;
//                        toAdd.add(key);
//
//                    }
//
//
//
//                }
//
//            }
//
//
//            for(String s : list){
//                if(!s.startsWith("hidden")) toAdd.add(s);
//            }
//
//            list = toAdd;
//
//        }
//
//        for(String s : list){
//            if(!s.startsWith("hidden")) updatesRequired.add(s);
//        }
//
//        return updatesRequired;
//
//
//
//
//    }


    public void printDependencies(){

        Set<String> keys = dependencyTable.keySet();

        for( String key : keys){

            System.out.println(key + ":");

            TableEntry te = dependencyTable.get(key);
            int i = 1;
            for(EntryData ed : te.getEntries()){
                System.out.print(i + ":");
                System.out.print("Dependents: " + ed.dependents + "\nConditions: ");
                for(Condition c : ed.getConditions()){
                    System.out.println(c.getConditionString());
                }
                i++;
            }

        }

    }




}





