import gen.ViewBaseListener;
import gen.ViewParser;
import javafx.beans.binding.BooleanExpression;
import javafx.util.Pair;
import javassist.compiler.ast.Variable;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.neo4j.index.internal.gbptree.Meta;

import javax.management.Attribute;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


//TODO now that I have conditions, I have to re-look at my definitions of viewatoms.
//a view atom could be the following: MATCH (n)-[]-(m) WHERE m.name = "Bob" RETURN n

public class ViewQueryListener extends ViewBaseListener {

    protected Map<String, Set<String>> viewTable = new ConcurrentHashMap<String,Set<String>>();
    //Need a table for metadata:
    //For each view id, also store relevant information about each view:
    //information to keep track of:
    //      conditions, return value, path.
    // Maybe keep track of the context itself
    protected Map<String, MetaData> metaDataTable = new ConcurrentHashMap<String, MetaData>();

    //View table - stores all views that return sets of nodes and the nodes that it should contain
    //key : view name. value : set of node identifiers

    public Set<String> viewInstants = new HashSet<>();

    private volatile int uniqueViewIdentifier = 0;
    private int counter = 0;

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
    *       USE VIEW myPathView MATCH  p = (n:Person)-[:Follows]-(m:Person) WHERE p IN myPathView
    *           AND n.age > 18 RETURN ...
    *   - Specifying that p IN myPathView indicates that the user wants all paths that satisfy the age condition
    *       to be in the view myPathView. The Follows relationship must also be contained within the view. Essentially
    *       this query first retrieves all paths then filters by the age.
    *
    * An example of a query non-restricted to a view:
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
    public Map<String, Set<String>> addWhereClause = new HashMap<String, Set<String>>();


    private LinkedList<String> usedViews = new LinkedList<String>();

    public String changeGraphQuery = "";
    private boolean cg = false;


    @Override
    public void enterRoot(ViewParser.RootContext ctx){

        if(ctx.getChild(0).getText().equals("CG")){
            cg = true;

            changeGraphQuery = ctx.getChild(1).getText();
            return;
        }

        TerminalNode node = ctx.COMMAND();
        String name = node.getText();


        if(name.equals("CREATE VIEW AS")) {
            isViewInstant = true;

            int a = ctx.start.getStartIndex();
            int b = ctx.stop.getStopIndex();
            Interval interval = new Interval(a,b);
            String viewSql = ctx.start.getInputStream().getText(interval);

            viewInstants.add(viewSql);
        }
        else if (name.equals("USE VIEW")) isViewUse = true;

        if (ctx.getText().contains("IN") && isViewUse) {
            //global view usage
            viewScope = false; //set to global
        }

        viewName = ctx.NAME().getText();
        usedViews.add(viewName);

        //System.out.println(name);

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
        metaDataTable.get(viewName).setQuery(ctx);
    }

    @Override
    public void enterPath(ViewParser.PathContext ctx){
        if(isViewUse || cg) return;
        pathName = ctx.expr().getText();
    }


    @Override
    public void enterVariable(ViewParser.VariableContext ctx){
        if(isViewUse || cg){
            nodeSymbols.add(ctx.nodeName().getText());
        }
    }

    @Override
    public void enterViewatom(ViewParser.ViewatomContext ctx){

        if(isViewUse || cg) return;



        if(counter==0){
            // Create two entries in the view table: one that is the complete path (hidden) and one that is just the
            // user-defined view.

            //viewTable updates
            int id = uniqueViewIdentifier++;
            String name = viewName;
            ctx.id = name;
            viewTable.put(name, new HashSet<String>());

            int firstHidden = uniqueViewIdentifier++;
            String hiddenName = "hiddenview"+firstHidden;
            viewTable.get(name).add(hiddenName);
            viewTable.put(hiddenName, new HashSet<String>());


            thisQueryViews.add(name);
            thisQueryViews.add(hiddenName);

            ctx.id = hiddenName;

            //metadataTable updates. The first update is done specially for the user defined view due to return type.
            //

            MetaData metaData = new MetaData(returnValExpr, returnType);
            metaDataTable.put(name, metaData);


            if(usedViews.size()!=0){
                for(String refView : usedViews){
                    viewTable.get(name).add(refView);
                }
            }
        }
        else{

            int thisViewID = uniqueViewIdentifier;
            String thisViewName = "hiddenview" + thisViewID;

            ctx.id = thisViewName;

            thisQueryViews.add(thisViewName);

            //System.out.println(ctx.getParent().getText());
            //add an attribute to ViewatomContext which keeps track of it's ID

            if(ctx.getParent() instanceof ViewParser.ViewatomContext){
                ViewParser.ViewatomContext parent = (ViewParser.ViewatomContext)ctx.getParent();
                viewTable.get(parent.id).add(thisViewName);

            }
            //Add self to viewtable
            viewTable.put(thisViewName, new HashSet<String>());


            uniqueViewIdentifier++;

        }


        counter++;
    }

    @Override
    public void enterRelation(ViewParser.RelationContext ctx){

        if(cg) return;

        if (ctx.getChildCount()==0) return;

        if((ctx.getText().contains(":") && ctx.getChildCount()==3) ||
                (!ctx.getText().contains(":") && ctx.getChildCount()==1))
            relSymbols.add(ctx.relationValue().getText());

        if (ctx.getChildCount()==1){
            //not used now but may be useful

        }
        else if (ctx.getChildCount()==3){
            //not used now but may be useful


        }

    }

    @Override
    public void exitViewatom(ViewParser.ViewatomContext ctx){


        if(cg) return;

        //Meta-data handling
        String thisViewName = ctx.id;

        //view usage : storing node symbol
        if(isViewUse) {
            if (ctx.NAME().size()==2) {
                String nodeName = ctx.NAME(0).getText();
                nodeSymbols.add(nodeName);
            }
            return;
        }

        //Could change if grammar changes
        if (ctx.NAME().size()==2){

            String nodeName = ctx.NAME(0).getText();
            String nodeType = ctx.NAME(1).getText();

            MetaData metaData = new MetaData(nodeName, nodeType);
            metaDataTable.put(thisViewName, metaData);

            //System.out.println("woop" + ctx.getChild(1).getText() + ctx.getChild(3).getText());

        }

        //Other rules..
        else{
            ParseTree child1 = ctx.getChild(0);
            ParseTree child2 = ctx.getChild(2);
            ParseTree child3 = ctx.getChild(4);

            Object payload1 = child1.getPayload();
            Object payload2 = child2.getPayload(); //should always be relationship
            Object payload3 = child3.getPayload();


            if(payload1 instanceof ViewParser.ViewatomContext){


                if(payload3 instanceof ViewParser.ViewatomContext){

                    //AtomAtom

                    String child1Name = ((ViewParser.ViewatomContext)payload1).id;
                    String child3Name = ((ViewParser.ViewatomContext)payload3).id;

                    String relationshipString = ((ViewParser.RelationContext)payload2).getText();

                    System.out.println(child1Name + "-["+relationshipString+"]-"+child3Name);

                    MetaData entry = new MetaData(child1Name, child3Name, relationshipString, MetaData.MetaType.RELATIONSHIP1);
                    entry.setLeftAtom((ViewParser.ViewatomContext)payload1);
                    entry.setRightAtom((ViewParser.ViewatomContext)payload3);

                    metaDataTable.put(thisViewName, entry);


                }
                else if (payload3 instanceof ViewParser.VariableContext){

                    //AtomVar

                    String child1Name = ((ViewParser.ViewatomContext)payload1).id;
                    String varName = ((ViewParser.VariableContext)payload3).nodeName().getText();

                    String relationshipString = ((ViewParser.RelationContext)payload2).getText();

                    System.out.println(child1Name + "-["+relationshipString+"]-"+varName);

                    MetaData entry = new MetaData(child1Name, varName, relationshipString, MetaData.MetaType.RELATIONSHIP2);
                    entry.setLeftAtom((ViewParser.ViewatomContext)payload1);

                    metaDataTable.put(thisViewName, entry);




                }

            }

            else if (payload1 instanceof ViewParser.VariableContext){

                if(payload3 instanceof ViewParser.ViewatomContext){

                    //VarAtom

                    String childName = ((ViewParser.ViewatomContext)payload3).id;
                    String varName = ((ViewParser.VariableContext)payload1).nodeName().getText();

                    String relationshipString = ((ViewParser.RelationContext)payload2).getText();

                    System.out.println(varName + "-["+relationshipString+"]-"+childName);

                    MetaData entry = new MetaData(varName, childName, relationshipString, MetaData.MetaType.RELATIONSHIP3);
                    entry.setRightAtom((ViewParser.ViewatomContext)payload3);

                    metaDataTable.put(thisViewName, entry);

                }
                else if (payload3 instanceof ViewParser.VariableContext){

                    //VarVar

                    String varName1 = ((ViewParser.VariableContext)payload1).nodeName().getText();
                    String varName2 = ((ViewParser.VariableContext)payload3).nodeName().getText();

                    String relationshipString = ((ViewParser.RelationContext)payload2).getText();

                    System.out.println(varName1 + "-["+relationshipString+"]-"+varName2);

                    MetaData entry = new MetaData(varName1, varName2, relationshipString, MetaData.MetaType.RELATIONSHIP4);

                    metaDataTable.put(thisViewName, entry);

                }

            }
        }
    }

    @Override
    public void enterUsedviews(ViewParser.UsedviewsContext ctx){

        if(isViewUse || cg) return;


        List<TerminalNode> used = ctx.NAME();
        for ( TerminalNode node : used){
            usedViews.add(node.getText());
        }
    }

    public void createDependencies(ViewParser.ViewatomContext ctx){

    }

    @Override
    public void exitConditions(ViewParser.ConditionsContext ctx){

        if(isViewUse || cg) return;

        //Using all symbols from symboltable (set-up from enterBoolexpr), attach these to meta-data table entries

        for (String view : thisQueryViews){

            Iterator<String> it = symbolTable.keySet().iterator();

            while(it.hasNext()){

                String symbol = it.next();
                Set<ViewParser.BoolexprContext> conditionSet = symbolTable.get(symbol);

                metaDataTable.get(view).conditions.addAll(conditionSet);


            }


        }
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
        if(isViewUse || cg) {

            if(ctx.getText().contains("IN") && !ctx.getText().contains("AND") && !ctx.getText().contains("OR")){
                String viewNodeName = ctx.NAME(0).getText(); //not necessarily node. can be path symbol too
                String viewUsedName = ctx.NAME(1).getText();

                assert viewTable.containsKey(viewUsedName);
                assert usedViews.contains(viewUsedName);

                if(addWhereClause.containsKey(viewNodeName)){
                    addWhereClause.get(viewNodeName).add(viewUsedName);
                }
                else{
                    addWhereClause.put(viewNodeName, new HashSet<String>());
                    addWhereClause.get(viewNodeName).add(viewUsedName);
                }

                if(relSymbols.contains(viewNodeName)){
                    //this condition maybe lumped with next condition

                }
                else if (nodeSymbols.contains(viewNodeName)){

                }
                else{
                    //must be a path
                }

            }

        }




//        conditions.add(ctx); //conditions not useful rn

        //Keep LHS of each condition inside the symbolTable
        else {
            ParseTree child1 = ctx.getChild(0);
            ParseTree child2 = ctx.getChild(1);

            Object payload1 = child1.getPayload();

            if (payload1 instanceof ViewParser.AttributeContext) {
                System.out.println(((ViewParser.AttributeContext) payload1).getText());

                String keyname = ((ViewParser.AttributeContext) payload1).getText().split("\\.")[0];

                if (symbolTable.containsKey(keyname)) {
                    symbolTable.get(keyname).add(ctx);
                } else {
                    HashSet<ViewParser.BoolexprContext> set = new HashSet<>();
                    set.add(ctx);
                    symbolTable.put(keyname, set);
                }

            }
        }
    }

    public boolean getViewScope(){
        return viewScope;
    }

    public void clearAll(){
        //does not clear viewInstants; this should be called separately

        usedViews = new LinkedList<String>();
        thisQueryViews = new LinkedList<String>();

        relSymbols = new LinkedList<>();
        nodeSymbols = new LinkedList<>();

        viewName = "";
        isViewInstant = false;
        isViewUse = false;
        viewScope = true;
        counter = 0;
        returnValExpr = "";
        pathName = "";
        returnType = retType.DEFAULT;
        symbolTable = new ConcurrentHashMap<String, Set<ViewParser.BoolexprContext>>();
        addWhereClause = new HashMap<>();

        cg = false;
        changeGraphQuery = "";
    }

    public void changeGraph(){
        clearAll();

        viewTable = new ConcurrentHashMap<>();
        metaDataTable = new ConcurrentHashMap<>();

    }

    public void removeInstants(){
        viewInstants = new HashSet<>();
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



    public void printViewTable(){

        Iterator<String> it = viewTable.keySet().iterator();

        while(it.hasNext()){
            String key = it.next();
            System.out.println("Key: " + key + "\t"+viewTable.get(key).toString());
        }
    }

    public void printMetadataTable(){

        Iterator<String> it = metaDataTable.keySet().iterator();

        while(it.hasNext()){
            String key = it.next();
            System.out.println("Key: " + key + "\t" +metaDataTable.get(key).toString());
            metaDataTable.get(key).printConditions();
        }

    }


}
