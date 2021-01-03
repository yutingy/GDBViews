import gen.ViewLexer;
import gen.ViewParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.neo4j.graphdb.Relationship;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    //main class used for QueryParser.java as the parser.


    protected static Set<String> viewCreationTable = new HashSet<String>();

    protected static Map<String, Set<String>> nodeTable = new ConcurrentHashMap<String, Set<String>>();
    protected static Map<String, Set<Relationship>> pathTable = new ConcurrentHashMap<>();
    protected static Map<String, Set<String>> edgeTable = new ConcurrentHashMap<>();

//    protected Map<String,Set<SubPredTuple<String,GraphPredicate>>> viewTable;



//    protected Map<String, Set<String>> inDegreeTable; // <value+Label,[subIds]>
//    protected Map<String,Set<String>> outDegreeTable;
//    protected Map<String,Set<SubPredTuple<String,GraphPredicate>>>commonFriendTable;
//    protected Set<String> nodeProperty; // extra info?
//    protected static SimpleBooleanTest  parserNeo4j = new SimpleBooleanTest("");

    public static ParseTreeWalker walker = new ParseTreeWalker();
    public static QueryParser vql = new QueryParser();

    public static Neo4jGraphConnector connector;

    public static void main(String[] args){

        try {
            connector = new Neo4jGraphConnector();
            terminal();
        }
        finally{
            connector.shutdown();
        }



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
                else if (command.startsWith("printDependencies")){
                    vql.printDependencies();
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
//                        changeGraph(command, materialized); //todo uncomment for test
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


    public static void processMainView(String cmd, boolean materialized){

        String viewname = vql.getViewName();
        String fullQuery = cmd.split(viewname)[1];
//        System.out.println(fullQuery);

        String returnSymbol = vql.getReturnValExpr();
        String mainQuery = fullQuery.split("RETURN")[0];

        String makeMiddlewareView = "";
        switch(vql.getReturnType()){

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

        if(vql.getReturnType() == QueryParser.retType.NODE) {

            Set<String> nodes = connector.executeQuery(makeMiddlewareView);
            nodeTable.put(viewname, nodes);


        }
        if(vql.getReturnType() == QueryParser.retType.PATH){

            Set<Relationship> relationshipSet = connector.pathQuery(makeMiddlewareView);


            pathTable.put(viewname, relationshipSet);


            Set<String> edgeids = new HashSet<String>();
            for(Relationship r : relationshipSet){
                edgeids.add(""+r.getId());
            }


            edgeTable.put(viewname, edgeids);

            // System.out.println("#entry in edge tables? for " + viewname + " " + edgeTable.get(viewname).size());


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

            // System.out.println("#entry in node tables? for " + viewname + " " + nodeTable.get(viewname).size());


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
        // System.out.println(fullQuery); //todo uncomment

    }

}
