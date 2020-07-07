import gen.ViewBaseListener;
import gen.ViewLexer;
import gen.ViewParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.index.internal.gbptree.Meta;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class View {


    //Table structure: a view table contains the viewName (String) as key, and a list of viewNames
    //which refers to all of the views that it is dependent on.
    //A node or edge is altered: the following should happen:
    // 1) For all views that are tagged on the altered node or edge, check recursively in the tables to sub or unsub
    // 2) Should mark views as updated
    //Two tables:
    // 1) Visible views. These are defined by the user
    // 2) Hidden views. These are used by (1) but not directly available to the user.


    protected static Set<String> viewCreationTable = new HashSet<String>();

    protected static Map<String, Set<String>> nodeTable = new HashMap<String, Set<String>>();
    protected static Map<String, Set<Relationship>> pathTable = new HashMap<>();
    protected static Map<String, Set<String>> edgeTable = new HashMap<>();

//    protected Map<String,Set<SubPredTuple<String,GraphPredicate>>> viewTable;



//    protected Map<String, Set<String>> inDegreeTable; // <value+Label,[subIds]>
//    protected Map<String,Set<String>> outDegreeTable;
//    protected Map<String,Set<SubPredTuple<String,GraphPredicate>>>commonFriendTable;
//    protected Set<String> nodeProperty; // extra info?
//    protected static SimpleBooleanTest  parserNeo4j = new SimpleBooleanTest("");

    public static ParseTreeWalker walker = new ParseTreeWalker();
    public static ViewQueryListener vql = new ViewQueryListener();

    public static Neo4jGraphConnector connector;

    public static void main(String[] args){

        try {
            connector = new Neo4jGraphConnector();




            terminal();
        }
        finally{
            connector.shutdown();
        }


       // String tester = "CREATE VIEW AS v1 MATCH (n)-[:FRIENDS]-(p) RETURN p";
//        ViewLexer VL = new ViewLexer(CharStreams.fromString(tester));

//        CommonTokenStream tokens = new CommonTokenStream(VL);
//        ViewParser parser = new ViewParser(tokens);

//        ParseTree tree = parser.root();
//        walker.walk(vql, tree);



        //System.out.println(vql.getViewName());

    }



    public static void matchAndSet(boolean materialized){

        if(materialized) return;

        Set<String> views = vql.viewTable.keySet();

        for (String viewName : views){
            if ( viewCreationTable.contains(viewName)) continue;

            else viewCreationTable.add(viewName);
            //create the view in Neo4j

            String query = "";

            MetaData metaData = vql.metaDataTable.get(viewName);


            switch(metaData.metaType){

                case RETURNSYMBOL: {
                    //For view creation within neo4j, the user defined view does not need to be set

                    break;
                }
                case RELATIONSHIP1: {//AtomAtom

                    String LHSAtom = metaData.Leftctx.getText();
                    String RHSAtom = metaData.Rightctx.getText();
                    String colon = ":";
                    if (metaData.relationshipType.equals("") && metaData.relationshipName.equals("")) colon = "";

                    query = "MATCH path = " + LHSAtom + "-[" + metaData.relationshipName + colon + metaData.relationshipType
                            + "]-" + RHSAtom + "\nFOREACH(pathnode in nodes(path) | SET(CASE WHEN NOT EXISTS(pathnode.views) THEN pathnode END).views = []" +
                            " SET pathnode.views = (CASE WHEN \"" +viewName+ "\" IN pathnode.views THEN [] ELSE [\"" + viewName + "\"] END) + pathnode.views)"
                            + "\nFOREACH(pathnode in relationships(path) | SET(CASE WHEN NOT EXISTS(pathnode.views) THEN pathnode END).views = []" +
                            " SET pathnode.views = (CASE WHEN \"" +viewName+ "\" IN pathnode.views THEN [] ELSE [\"" + viewName + "\"] END) + pathnode.views)";



                    break;
                }
                case RELATIONSHIP2: { //AtomVar

                    String LHSAtom = metaData.Leftctx.getText();
                    String colon = ":";
                    if (metaData.relationshipType.equals("") && metaData.relationshipName.equals("")) colon = "";

                    query = "MATCH path = " + LHSAtom + "-[" + metaData.relationshipName + colon + metaData.relationshipType
                            + "]-(" + metaData.RHSName + ")\nFOREACH(pathnode in nodes(path) | SET(CASE WHEN NOT EXISTS(pathnode.views) THEN pathnode END).views = []" +
                            " SET pathnode.views = (CASE WHEN \"" +viewName+ "\" IN pathnode.views THEN [] ELSE [\"" + viewName + "\"] END) + pathnode.views)"
                            + "\nFOREACH(pathnode in relationships(path) | SET(CASE WHEN NOT EXISTS(pathnode.views) THEN pathnode END).views = []" +
                            " SET pathnode.views = (CASE WHEN \"" +viewName+ "\" IN pathnode.views THEN [] ELSE [\"" + viewName + "\"] END) + pathnode.views)";



                    break;
                }
                case RELATIONSHIP3: { //VarAtom

                    String RHSAtom = metaData.Rightctx.getText();
                    String colon = ":";
                    if (metaData.relationshipType.equals("") && metaData.relationshipName.equals("")) colon = "";

                    query = "MATCH path = (" + metaData.LHSName + ")-[" + metaData.relationshipName + colon + metaData.relationshipType
                            + "]-" + RHSAtom + "\nFOREACH(pathnode in nodes(path) | SET(CASE WHEN NOT EXISTS(pathnode.views) THEN pathnode END).views = []" +
                            " SET pathnode.views = (CASE WHEN \"" +viewName+ "\" IN pathnode.views THEN [] ELSE [\"" + viewName + "\"] END) + pathnode.views)"
                            + "\nFOREACH(pathnode in relationships(path) | SET(CASE WHEN NOT EXISTS(pathnode.views) THEN pathnode END).views = []" +
                            " SET pathnode.views = (CASE WHEN \"" +viewName+ "\" IN pathnode.views THEN [] ELSE [\"" + viewName + "\"] END) + pathnode.views)";



                    break;
                }
                case RELATIONSHIP4: {//VarVar

                    String colon = ":";
                    if (metaData.relationshipType.equals("") && metaData.relationshipName.equals("")) colon = "";
                    query = "MATCH path = (" + metaData.LHSName + ")-[" + metaData.relationshipName + colon + metaData.relationshipType
                            + "]-(" + metaData.RHSName + ")\nFOREACH(pathnode in nodes(path) | SET(CASE WHEN NOT EXISTS(pathnode.views) THEN pathnode END).views = []" +
                            " SET pathnode.views = (CASE WHEN \"" +viewName+ "\" IN pathnode.views THEN [] ELSE [\"" + viewName + "\"] END) + pathnode.views)"
                            + "\nFOREACH(pathnode in relationships(path) | SET(CASE WHEN NOT EXISTS(pathnode.views) THEN pathnode END).views = []" +
                            " SET pathnode.views = (CASE WHEN \"" +viewName+ "\" IN pathnode.views THEN [] ELSE [\"" + viewName + "\"] END) + pathnode.views)";


                    break;
                }
                case NODETYPE : {

                    query = "MATCH (n:" + metaData.nodeType + ") SET(CASE WHEN NOT EXISTS(n.views) THEN n END).views = []"
                            + " SET n.views = [\"" + viewName + "\"] + n.views";

                    break;

                }

            }

             connector.executeQuery(query);


        }


        /*
        * Our views will not be duplicated onto the graph. Instead, it will mark all nodes in the sub-graph
        * for various reasons:
        *   1) A duplicated view on the graph must retain original attributes. Thus a standard query not intended
        *       for the view will also match on the view
        *   2) Duplicating a sub-graph takes time
        *
        * Counter points:
        *   1) The duplicate should be in a separate database, not visible to user
        *
        * */

        String cmd = "";
        String pathName = "";



    }



    //TODO
    public void removeViewID(){

    }

    public static void processMainView(String cmd, boolean materialized){

        String viewname = vql.getViewName();
        String fullQuery = cmd.split(viewname)[1];
//        System.out.println(fullQuery);

        String returnSymbol = vql.metaDataTable.get(viewname).returnSymbol;
        String mainQuery = fullQuery.split("RETURN")[0];

        String makeMiddlewareView = "";
        switch(vql.metaDataTable.get(viewname).returnType){

            case NODE:{
                fullQuery = mainQuery + "SET(CASE WHEN NOT EXISTS(" + returnSymbol + ".views) THEN " + returnSymbol +" END).views = []" +
                " SET " + returnSymbol + ".views = (CASE WHEN \"" +viewname+ "\" IN " + returnSymbol +".views THEN [] ELSE [\"" + viewname + "\"] END) + " + returnSymbol + ".views";

                makeMiddlewareView = mainQuery + "RETURN DISTINCT ID(" + returnSymbol + ")";

                break;
            }
            case PATHNODES:{
                //TODO
                break;
            }
            case PATH: {
                fullQuery = mainQuery + "FOREACH(pathnode in nodes(" + returnSymbol + ") | SET(CASE WHEN NOT EXISTS(pathnode.views) THEN pathnode END).views = []" +
                " SET pathnode.views = (CASE WHEN \"" +viewname+ "\" IN pathnode.views THEN [] ELSE [\"" + viewname + "\"] END) + pathnode.views)"
                        + "\nFOREACH(pathnode in relationships(" + returnSymbol + ") | SET(CASE WHEN NOT EXISTS(pathnode.views) THEN pathnode END).views = []" +
                        " SET pathnode.views = (CASE WHEN \"" +viewname+ "\" IN pathnode.views THEN [] ELSE [\"" + viewname + "\"] END) + pathnode.views)";

                //TODO
                makeMiddlewareView = mainQuery + "RETURN " + returnSymbol;

            }
            case DEFAULT: {
                break;
            }
        }

        //System.out.println(fullQuery);
        if(materialized) {
            connector.executeQuery(fullQuery);
            return;
        }

        if(vql.metaDataTable.get(viewname).returnType == ViewQueryListener.retType.NODE) {

            Set<String> nodes = connector.executeQuery(makeMiddlewareView);
            nodeTable.put(viewname, nodes);


        }
        if(vql.metaDataTable.get(viewname).returnType == ViewQueryListener.retType.PATH){

            Set<Relationship> relationshipSet = connector.pathQuery(makeMiddlewareView);


            pathTable.put(viewname, relationshipSet);


            Set<String> edgeids = new HashSet<String>();
            for(Relationship r : relationshipSet){
                edgeids.add(""+r.getId());
            }


            edgeTable.put(viewname, edgeids);

            System.out.println("#entry in edge tables? for " + viewname + " " + edgeTable.get(viewname).size());


            Set<String> nodeids = connector.getNodeSet();

//            Set<String> nodeids = new HashSet<String>();
//            for(Relationship r : relationshipSet){
//                Node[] nodeSet = r.getNodes();
//                for (Node n : nodeSet){
//                    String nodeid = ""+n.getId();
//                    if(!nodeids.contains(nodeid)) nodeids.add(nodeid);
//                }
//            }

            nodeTable.put(viewname, nodeids);

            System.out.println("#entry in node tables? for " + viewname + " " + nodeTable.get(viewname).size());


        }

    }

    public static void processUseView(String cmd){

        String fullQuery = "MATCH " + cmd.split("MATCH")[1];


//        System.out.println("FullQuery:: " + fullQuery + "\nViewName:: " + viewname);
        List<String> edgeidentifiers = vql.relationSymbols();
        List<String> nodeidentifiers = vql.nodeSymbols();

        if(vql.getViewScope()){

            String appendedToQuery = "";
            String viewName = vql.getViewName();

            //nodes
            for(String id : nodeidentifiers){ //we look at all node identifiers that reside in the query
                appendedToQuery = appendedToQuery + " AND ID(" + id + ") IN " + nodeTable.get(viewName);
            }

            //edges
            for(String id : edgeidentifiers){
                if(edgeTable.containsKey(id)){
                    appendedToQuery = appendedToQuery + " AND ID(" + id + ") IN " + edgeTable.get(viewName);
                }
            }


            String beforeReturn = fullQuery.split("RETURN")[0];
            String afterReturn =  " RETURN " + fullQuery.split("RETURN")[1];


            if(vql.containsWhere()){
                fullQuery = beforeReturn + appendedToQuery + afterReturn;
            }
            else{
                appendedToQuery = appendedToQuery.replaceFirst("AND", "");
                fullQuery = beforeReturn + "WHERE " + appendedToQuery + afterReturn;
            }
        }

        else {
            Iterator<String> it = vql.addWhereClause.keySet().iterator();
            while (it.hasNext()) {

                String nodeName = it.next();

                Iterator<String> it2 = vql.addWhereClause.get(nodeName).iterator();

                while (it2.hasNext()) {
                    String viewName = it2.next();

                    String target = nodeName + " IN " + viewName;
                    String replacement = "ID(" + nodeName + ") IN " + nodeTable.get(viewName);

                    fullQuery = fullQuery.replace(target, replacement);

                }
            }
        }

        connector.executeQuery(fullQuery);
        System.out.println(fullQuery);

    }

    public static void changeGraph(String query, boolean materialized){
        connector.executeQuery(query.split("CG")[1]);

        //need to update views ; so now for each view we have re-evaluate it..
        if(materialized) connector.executeQuery("MATCH (n) REMOVE n.views"); //remove view
        vql.changeGraph();

        for(String cmd : vql.getViewInstants()){ //re-evaluate all view instants...

            vql.viewInstants.remove(cmd);

            ViewLexer VL = new ViewLexer(CharStreams.fromString(cmd));
            CommonTokenStream tokens = new CommonTokenStream(VL);
            ViewParser parser = new ViewParser(tokens);

            System.out.println(cmd);


            ParseTree tree = parser.root();
            walker.walk(vql, tree);

            matchAndSet(materialized);
            processMainView(cmd, materialized);

        }
        vql.removeInstants();

    }




    public static void terminal(){

        boolean materialized = false;

        boolean debug = false;

        try {
            InputStreamReader isReader = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isReader);
            System.out.print(">> ");
            String command = br.readLine();
            while (true) {
                if (command.startsWith("quit")) {
                    break;
                }
                else if (command.startsWith("printView")){
                    vql.printViewTable();
                }
                else if (command.startsWith("printMeta")){
                    vql.printMetadataTable();
                }
                else if (command.startsWith("printNode")){
                    System.out.println(nodeTable.toString());
                }
                else if (command.startsWith("clear")){
                    vql.clearAll();
                }
                else if (command.startsWith("wipe")){
                    connector.executeQuery("MATCH (n) REMOVE n.views");
                }
                else if (command.startsWith("debug switch")){
                    debug = !debug;
                }
                else {


                    ViewLexer VL = new ViewLexer(CharStreams.fromString(command));
                    CommonTokenStream tokens = new CommonTokenStream(VL);
                    ViewParser parser = new ViewParser(tokens);


                    ParseTree tree = parser.root();
                    walker.walk(vql, tree);

                    if(vql.isViewInstant()) {
                        long now = System.currentTimeMillis();
                        matchAndSet(materialized);
                        processMainView(command, materialized);
                        long total = System.currentTimeMillis() - now;
                        System.out.println("Took " + total + "ms to create views");
                    }
                    else if (vql.isViewUse()){
                        long now = System.currentTimeMillis();

                        processUseView(command);

                        long total = System.currentTimeMillis() - now;
                        System.out.println("Took " + total + "ms to use view");
                    }
                    else if (vql.isCg()){
                        long now = System.currentTimeMillis();
                        changeGraph(command, materialized);
                        long total = System.currentTimeMillis() - now;
                        System.out.println("Took " + total + "ms to change graph and update view(s)");
                    }

                    if(!debug) vql.clearAll();


                    System.out.print(">> ");
                    command = br.readLine();
                    continue;
                }
                System.out.print(">> ");
                command = br.readLine();
            }
            isReader.close();
            br.close();
        } catch (NullPointerException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void noGuiTest(String command, boolean materialized) {


        if (command.startsWith("printView")) {
            vql.printViewTable();
        } else if (command.startsWith("printMeta")) {
            vql.printMetadataTable();
        } else if (command.startsWith("printNode")) {
            System.out.println(nodeTable.toString());
        } else if (command.startsWith("clear")) {
            vql.clearAll();
        } else if (command.startsWith("wipe")) {
            connector.executeQuery("MATCH (n) REMOVE n.views");
        } else {


            ViewLexer VL = new ViewLexer(CharStreams.fromString(command));
            CommonTokenStream tokens = new CommonTokenStream(VL);
            ViewParser parser = new ViewParser(tokens);


            ParseTree tree = parser.root();
            walker.walk(vql, tree);

            if (vql.isViewInstant()) {
                long now = System.currentTimeMillis();
                matchAndSet(materialized);
                processMainView(command, materialized);
                long total = System.currentTimeMillis() - now;
                System.out.println("Took " + total + "ms to create views");
            } else if (vql.isViewUse()) {
                long now = System.currentTimeMillis();
                processUseView(command);
                long total = System.currentTimeMillis() - now;
                System.out.println("Took " + total + "ms to use view");
            } else if (vql.isCg()) {
                long now = System.currentTimeMillis();
                changeGraph(command, materialized);
                long total = System.currentTimeMillis() - now;
                System.out.println("Took " + total + "ms to change graph and update view(s)");
            }

        }

        vql.clearAll();
    }

    public static void test(boolean mat){

        ArrayList<String> cmdQ = new ArrayList<>();

        cmdQ.add("CREATE VIEW AS view1 MATCH (n:Post) WHERE n.score > 350 RETURN n");
        cmdQ.add("CREATE VIEW AS view2 MATCH (n:Post) WHERE n.score < 1000 RETURN n");
        cmdQ.add("CREATE VIEW AS view3 MATCH p = (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) WHERE n.reputation > 5000 RETURN p");
        cmdQ.add("CREATE VIEW AS view4 MATCH (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) WHERE n.reputation > 5000 RETURN po2");
        cmdQ.add("CREATE VIEW AS view5 MATCH p = (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) WHERE n.reputation < 6000 RETURN p");


        cmdQ.add("CG MATCH (n:User) RETURN n LIMIT 5");
        cmdQ.add("CG MATCH (n:User) RETURN n LIMIT 5");
        cmdQ.add("CG MATCH (n:User) RETURN n LIMIT 5");

        cmdQ.add("USE VIEW view1 MATCH (n) WHERE n IN view1 RETURN n");
        cmdQ.add("USE VIEW view1 WITH VIEWS view2 MATCH (n:Post) WHERE n IN view1 AND n IN view2 RETURN n");
        cmdQ.add("USE VIEW view1 WITH VIEWS view3 MATCH (n:User)-[]-(p:Post) WHERE n IN view1 AND p IN view3 RETURN n"); //in one view but not the other



        long avg1 = 0;
        for(int i=0; i<5; i++){
            long now = System.currentTimeMillis();
            noGuiTest(cmdQ.get(i), mat);
            avg1 += (System.currentTimeMillis() - now);
        }

        avg1 /= 5;

        long avg2 = 0;
        for(int i=5; i<8; i++){
            long now = System.currentTimeMillis();
            noGuiTest(cmdQ.get(i), mat);
            avg2 += (System.currentTimeMillis() - now);
        }

        avg2 /= 3;

        long avg3 = 0;
        for(int i=8; i<11; i++){
            long now = System.currentTimeMillis();
            noGuiTest(cmdQ.get(i), mat);
            avg3 += (System.currentTimeMillis() - now);
        }

        avg3 /= 3;

        System.out.println("avg1:\t" + avg1
        + "\navg2:\t" + avg2
        + "\navg3:\t" + avg3);


    }

}
