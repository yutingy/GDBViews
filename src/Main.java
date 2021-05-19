import gen.ViewLexer;
import gen.ViewParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.neo4j.graphdb.Relationship;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    //main class used for QueryParser.java as the parser.


    protected static Set<String> viewCreationTable = new HashSet<String>();

    protected static Map<String, Set<String>> nodeTable = new ConcurrentHashMap<String, Set<String>>();
    protected static Map<String, Set<Relationship>> pathTable = new ConcurrentHashMap<>();
    protected static Map<String, Set<String>> edgeTable = new ConcurrentHashMap<>();


    public static ParseTreeWalker walker = new ParseTreeWalker();
    public static QueryParser vql = new QueryParser();

    public static Neo4jGraphConnector connector;

    public static void main(String[] args){

        try {

            String size = "Small";

            connector = new Neo4jGraphConnector(size);


//            loadTablesFromFiles(size);
//            createMetaInfoFromQueries("./test/initFileExample.txt");

            terminal();


        }
        catch(Exception e){
            e.printStackTrace();
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
                else if (command.startsWith("printOrView")){
//                    vql.printViewTable();
                    vql.printOrClauseViews();
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
                else if (command.startsWith("count")){
                    Set<String> keys = nodeTable.keySet();
                    for(String key : keys){
                        System.out.println(key+":"+nodeTable.get(key).size());
                    }
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
                        changeGraph(command);
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
        String returns = fullQuery.split("RETURN")[1].trim();

        String[] returnArray = returns.split(",");

        String makeMiddlewareView = "";



        long totalTime = System.currentTimeMillis();
        long queryTime = totalTime;



        switch(vql.getReturnType()){

            case NODE:{
                fullQuery = mainQuery + "SET(CASE WHEN NOT EXISTS(" + returnSymbol + ".views) THEN " + returnSymbol +" END).views = []" +
                        " SET " + returnSymbol + ".views = (CASE WHEN \"" +viewname+ "\" IN " + returnSymbol +".views THEN [] ELSE [\"" + viewname + "\"] END) + " + returnSymbol + ".views";


                String[] returnSymbols = returnSymbol.split(",");

                String returnClause = "";
                for(String retSym : returnSymbols) {

                    for(String actualRet : returnArray){
                        if(!returnClause.equals("")) returnClause += ",";
                        if(retSym.equals(actualRet)) returnClause += "ID(" + retSym + ")";
                        else returnClause += actualRet;
                    }

//                    returns = returns.replace(retSym, "ID(" + retSym + ")");
                }
                makeMiddlewareView = mainQuery + "RETURN DISTINCT " + returnClause ;

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
            queryTime = System.currentTimeMillis() - queryTime;
            nodeTable.put(viewname, nodes);

            System.out.println("There are " + nodes.size() + " nodes");

        }
        if(vql.getReturnType() == QueryParser.retType.PATH){

            Set<Relationship> relationshipSet = connector.pathQuery(makeMiddlewareView);
            queryTime = System.currentTimeMillis() - queryTime;


            pathTable.put(viewname, relationshipSet);


            Set<String> edgeids = new HashSet<String>();
            for(Relationship r : relationshipSet){
                edgeids.add(""+r.getId());
            }


            edgeTable.put(viewname, edgeids);

            // System.out.println("#entry in edge tables? for " + viewname + " " + edgeTable.get(viewname).size());


            Set<String> nodeids = connector.getNodeSet();
            System.out.println("There are " + nodeids.size() + " nodes");

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

        totalTime = System.currentTimeMillis() - totalTime;

        try{

            BufferedWriter fw = new BufferedWriter(new FileWriter("./test2/InitTimeSplitSmall.txt", true));

            fw.write(cmd + "\t"+totalTime +"\t"+queryTime+"\t"+(totalTime-queryTime)+"\n");
            fw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }



    public static long processUseView(String cmd){

        long now = System.currentTimeMillis();

        String fullQuery = "MATCH " + cmd.split("MATCH")[1];


//        System.out.println("FullQuery:: " + fullQuery + "\nViewName:: " + viewname);
        List<String> edgeidentifiers = vql.relationSymbols();
        List<String> nodeidentifiers = vql.nodeSymbols();

        if(vql.getViewScope()){

            //local, so there are omissions for set membership. if there are omissions then it has to be a single view usage

            String appendedToQuery = "";

            LinkedList<String> usedViews = vql.usedViews();
//            String viewName = vql.getViewName();

            if(usedViews.size()==1) {

                //There are definitely omissions

                String singleViewName =  usedViews.getFirst();

                //nodes
                for (String id : nodeidentifiers) { //we look at all node identifiers that reside in the query
                    appendedToQuery = appendedToQuery + " AND ID(" + id + ") IN " + nodeTable.get(singleViewName);
                }

                //edges
                for (String id : edgeidentifiers) {
                    if (edgeTable.containsKey(id)) {
                        appendedToQuery = appendedToQuery + " AND ID(" + id + ") IN " + edgeTable.get(singleViewName);
                    }
                }


                String beforeReturn = fullQuery.split("RETURN")[0];
                String afterReturn = " RETURN " + fullQuery.split("RETURN")[1];


                if (vql.containsWhere()) {
                    fullQuery = beforeReturn + appendedToQuery + afterReturn;
                } else {
                    appendedToQuery = appendedToQuery.replaceFirst("AND", "");
                    fullQuery = beforeReturn + "WHERE " + appendedToQuery + afterReturn;
                }
            }

            else if(usedViews.size()>1){
                //Then there are more than 2 views being used and we treat it as a global, since there are IN clauses
                Iterator<String> it = vql.addWhereClause.keySet().iterator();
                while (it.hasNext()) {

                    String nodeName = it.next();

//                    System.out.println("Outer Loop:" + nodeName);

                    Iterator<String> it2 = vql.addWhereClause.get(nodeName).iterator();

                    while (it2.hasNext()) {
                        String viewName = it2.next();
//                        System.out.println("Inner Loop:" + viewName);


                        String target = nodeName + " IN " + viewName;
                        String replacement = "ID(" + nodeName + ") IN " + nodeTable.get(viewName);

                        fullQuery = fullQuery.replace(target, replacement);

//                        System.out.println("Target and Replace:" + target + ", " + replacement);



                    }
                }
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

//        System.out.println(fullQuery); //todo uncomment

        if(fullQuery.contains("IN null")){
            System.out.println("Nothing in view");
            return 0l;
        }

        System.out.println(fullQuery.length());
//        if(fullQuery.length()>25000000){
//            System.out.println("Length too long, skipped");
//            return -10;
//        }

        File logger = new File("./test/log.txt");
        try{
            FileWriter l = new FileWriter(logger);
            l.write(fullQuery);
        }
        catch(Exception e) {e.printStackTrace();}

//        System.out.println(fullQuery);
        connector.executeQuery(fullQuery);

        return System.currentTimeMillis()-now;

    }

    public static void changeGraph(String command){
        //if this is called, then the change-graph has already walked through the parser
        System.out.println(vql.getFinalAffectedViews());

        //connector.executeQuery(command);


        Set<String> instantiations = new HashSet<>();

        for(String cmd : vql.outdatedViews){ //re-evaluate all necessary instants...

            instantiations.add(cmd);

//            System.out.println("cmd: " + cmd);

//
//            vql.viewInstants.remove(cmd);
//
//            ViewLexer VL = new ViewLexer(CharStreams.fromString(cmd));
//            CommonTokenStream tokens = new CommonTokenStream(VL);
//            ViewParser parser = new ViewParser(tokens);
//
//            System.out.println(cmd);
//
//
//            ParseTree tree = parser.root();
//            walker.walk(vql, tree);
//
//            matchAndSet(materialized);
//            processMainView(cmd, materialized);

        }
        vql.clearAll();
        for(String cmd : instantiations){
            vql.viewInstants.remove(cmd);
            ViewLexer VL = new ViewLexer(CharStreams.fromString(cmd));
            CommonTokenStream tokens = new CommonTokenStream(VL);
            ViewParser parser = new ViewParser(tokens);

//            System.out.println(cmd);


            ParseTree tree = parser.root();
            walker.walk(vql, tree);

//            matchAndSet(materialized);
            long now = System.currentTimeMillis();
          //  processMainView(cmd, false); //todo uncomment. this actually re-evals but for correctness I just want to know what views are being re-evald
          //  System.out.println("TIME TO RE-EVAL VIEW: " + (System.currentTimeMillis()-now));

            totalTime += System.currentTimeMillis()-now;
        }

        System.out.println("TOTAL TIME FOR ALL: " + totalTime);
        totalTime = 0;

        vql.resetAfterGraphUpdate();

    }


    public static long totalTime = 0;






















































    /**
     *
     * EVERYTHING BELOW THIS POINT IS THE TESTER CODE
     *
     *
     * */



        public static long noGuiTest(String command, boolean materialized) {

        long time = 0l;

        if (command.startsWith("printDependencies")) {
            vql.printDependencies();
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
                processMainView(command, materialized);
                long total = System.currentTimeMillis() - now;
               // System.out.println("Took " + total + "ms to create views");
            } else if (vql.isViewUse()) {
                time = processUseView(command);
               // System.out.println("Took " + total + "ms to use view");
            } else if (vql.isCg()) {
                long now = System.currentTimeMillis();
                changeGraph(command);
                long total = System.currentTimeMillis() - now;
              //  System.out.println("Took " + total + "ms to change graph and update view(s)");
            }

        }

        vql.clearAll();
        return time;
    }


    public static void testTextCopy(){


        String test = "MATCH (n:Post) WHERE n.score > 350 WITH COLLECT(ID(n)) as view1 MATCH (n:User) WHERE ID(n) IN view1 RETURN ID(n)";
        String test2 = "MATCH p = (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) WHERE n.reputation > 90000 AND po2.score>100 UNWIND NODES(p) as vn UNWIND RELATIONSHIPS(p) as vr with distinct vn, vr WITH collect(id(vn)) as viewnode, COLLECT(id(vr)) as viewrel MATCH (n) WHERE ID(n) IN viewnode RETURN ID(n)";
        String test3 = "MATCH (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) WHERE n.upvotes > 800 AND po2.score < 0 WITH COLLECT(ID(po2)) as view1 MATCH (n:User) WHERE ID(n) IN view1 RETURN ID(n)";
        String test4 = "MATCH (n:Post) WHERE n.score > 350 WITH COLLECT(ID(n)) as view1 MATCH p = (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) WHERE n.reputation > 90000 AND po2.score>100 WITH view1,p UNWIND NODES(p) as vn UNWIND RELATIONSHIPS(p) as vr with distinct vn, vr,view1, collect(id(vn)) as viewnode, COLLECT(id(vr)) as viewrel MATCH (n) WHERE ID(n) IN viewnode AND ID(n) IN view1 RETURN ID(n)";
        String test5 = "MATCH (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) WHERE n.upvotes > 800 AND po2.score < 0 WITH COLLECT(ID(po2)) as view1 MATCH p = (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) WHERE n.reputation > 90000 AND po2.score>100 WITH view1,p UNWIND NODES(p) as vn UNWIND RELATIONSHIPS(p) as vr with distinct vn, vr,view1, collect(id(vn)) as viewnode, COLLECT(id(vr)) as viewrel MATCH (n) WHERE ID(n) IN viewnode AND ID(n) IN view1 RETURN ID(n)";


        connector.executeQuery(test);

        long ret1time = 0;
        for (int i = 0; i < 5; i++) {
            long now = System.currentTimeMillis();
            connector.executeQuery(test);
            ret1time += System.currentTimeMillis() - now;

        }
        ret1time /= 5;

        System.out.println(ret1time + "LOOK HERE");

        connector.executeQuery(test2);

        long ret2time = 0;
        for (int i = 0; i < 5; i++) {
            long now = System.currentTimeMillis();
            connector.executeQuery(test2);
            ret2time += System.currentTimeMillis() - now;

        }
        ret2time /= 5;
        System.out.println(ret2time + "LOOK HERE");

        connector.executeQuery(test3);
        long ret3time = 0;
        for (int i = 0; i < 5; i++) {
            long now = System.currentTimeMillis();
            connector.executeQuery(test3);

            ret3time += System.currentTimeMillis() - now;

        }
        ret3time /= 5;
        System.out.println(ret3time + "LOOK HERE");

        connector.executeQuery(test4);

        long ret4time = 0;
        for (int i = 0; i < 5; i++) {
            long now = System.currentTimeMillis();
            connector.executeQuery(test4);
            ret4time += System.currentTimeMillis() - now;

        }
        ret4time /= 5;
        System.out.println(ret4time + "LOOK HERE");


        connector.executeQuery(test5);
        long ret5time = 0;
        for (int i = 0; i < 5; i++) {
            long now = System.currentTimeMillis();
            connector.executeQuery(test5);
            ret5time += System.currentTimeMillis() - now;

        }
        ret5time /= 5;


        System.out.println("Times: " + ret1time + ", " + ret2time + ", " + ret3time + ", " + ret4time + ", " + ret5time);



    }




    public static void toFile(String size, String viewName){
        File tableNodes = new File("./test3/" + size + "/" +viewName + "Node.txt");
        File tableRels = new File("./test3/"  + size + "/" +viewName + "Rel.txt");

        try {
            FileWriter nodes = new FileWriter(tableNodes);
            FileWriter rels = new FileWriter(tableRels);


            nodes.write(viewName + ": " + nodeTable.get(viewName) + "\n");
            rels.write(viewName + ": " + edgeTable.get(viewName) + "\n");

            nodes.flush();
            rels.flush();

            nodes.close();
            rels.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }

    public static void loadTablesFromFiles(String size){

        File directory = new File("./test3/"+size);

        try {
            for (File fileEntry : directory.listFiles()) {


                String name = fileEntry.getName();
                System.out.println(name);
                String viewName = "";
                if (name.endsWith("Node.txt")) {
                    viewName = name.split("Node\\.txt")[0];

                    Scanner myReader = new Scanner(fileEntry);
                    if(!myReader.hasNextLine()) continue;
                    String line = myReader.nextLine();
                    if(line.contains("null")) continue;
                    if(line.contains("[]")) {
                        nodeTable.put(viewName,new HashSet<>());
                        continue;
                    }

                    String entries = line.split("\\[")[1].split("\\]")[0];
                    entries = entries.trim();

                    Set<String> allEntries =  new HashSet<>(Arrays.asList(entries.split(",")));


                    nodeTable.put(viewName, allEntries);


                }
                if (name.endsWith("Rel.txt")) {
                    viewName = name.split("Rel\\.txt")[0];

                    Scanner myReader = new Scanner(fileEntry);
                    if(!myReader.hasNextLine()) continue;

                    String line = myReader.nextLine();
                    if(line.contains("null")) continue;

                    if(line.contains("[]")) {
                        edgeTable.put(viewName,new HashSet<>());
                        continue;
                    }

                    String entries = line.split("\\[")[1].split("\\]")[0];

                    Set<String> allEntries =  new HashSet<>(Arrays.asList(entries.split(",")));

                    edgeTable.put(viewName, allEntries);

                }

            }
            //todo
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }


    public static void createMetaInfoFromQueries(String viewPath){

        File file = new File(viewPath);
        try {
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {

                String line = myReader.nextLine();
                if (line.startsWith("*") || line.startsWith(" ") || line.startsWith("\n")) continue;
                String query = "CREATE VIEW AS " + line.split(";")[0] + " " + line.split(";")[1];

                String viewName = line.split(";")[0];

                System.out.println(query);

                if (query.contains("IN null")) continue;

                ViewLexer VL = new ViewLexer(CharStreams.fromString(query));
                CommonTokenStream tokens = new CommonTokenStream(VL);
                ViewParser parser = new ViewParser(tokens);


                ParseTree tree = parser.root();
                walker.walk(vql, tree);
                vql.clearAll();

            }

            myReader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void testUses(String size){

        loadTablesFromFiles(size); //load first
        //second, fill the meta data tables in vql, needed for the changegraph tests
        try {
            createMetaInfoFromQueries("./test/ViewInits.txt");
            createMetaInfoFromQueries("./test/initFileExample.txt");

            System.out.println("Done populating all tables - moving on to each use");

            File uses = new File("./test/ViewUses.txt");
            Scanner useReader = new Scanner(uses);


            Map<String, Long> durations = new HashMap<>();




            while(useReader.hasNextLine()){
                String line = useReader.nextLine();
                if(line.startsWith("*") || line.startsWith(" ") || line.startsWith("\n")) continue;

//                line = line + " LIMIT 1000";
//                System.out.println(line);

                durations.put(line, 0l);
            }

            Set<String> queries = durations.keySet();
            for(int i=0; i<1; i++) {
                for (String q : queries) {

                    durations.put(q, noGuiTest(q, false) + durations.get(q));
                    System.out.println("Query:\n"+q+"\nAvg:\t"+durations.get(q));

                }
            }


//            for(String q : queries){
//                durations.put(q, (durations.get(q))/2);
//                System.out.println("Query:\n"+q+"\nAvg:\t"+durations.get(q));
//            }


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }





    //To test and validate initialization times for views, where view definition queries are stored in fileName under the example format..
    public static void initFile2(String fileName, String size){

        File file = new File(fileName);

        Map<String, Long> durations = new HashMap<>();

        try {
            Scanner myReader = new Scanner(file);

            while(myReader.hasNextLine()){

                String line = myReader.nextLine();
                if(line.startsWith("*") || line.startsWith(" ") || line.startsWith("\n")) continue;
                String query = "CREATE VIEW AS " + line.split(";")[0] + " " + line.split(";")[1];

                String viewName = line.split(";")[0];

                System.out.println(query);

                durations.put(query, 0l);

            }

            myReader.close();

            Set<String> queries = durations.keySet();

            for(int i=0; i<10; i++) {
                for (String q : queries) {
                    long now = System.currentTimeMillis();

                    noGuiTest(q, false);

                    if(i==0) toFile(size, q.split("AS")[1].trim().split(" ")[0].trim());

                    long after = System.currentTimeMillis();

                    durations.put(q, (after - now) + durations.get(q));

                }
            }


            String finalLine = "";
            for(String q : queries){
                durations.put(q, (durations.get(q))/10);
                finalLine += "Query:\n"+q+"\nAvg:\t"+durations.get(q)+"\n";
//                System.out.println("Query:\n"+q+"\nAvg:\t"+durations.get(q));
            }

            FileWriter toInit = new FileWriter(new File("./test/inits"+size));
            toInit.write(finalLine);
            toInit.flush();
            toInit.close();



        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void textBasedSmart(String queryName){

        long now = System.currentTimeMillis();
        connector.executeQuery(queryName);
        System.out.println(System.currentTimeMillis()-now);

    }


    public static void validateReturn(String size){

        testUses(size);
        System.out.println("next;");
//        countQuery("MATCH (n:User) WHERE n.upvotes > 1000 RETURN COUNT(DISTINCT n) as c"); //u 10
//        System.out.println("next;");




//        countQuery("MATCH (n:Post) WHERE n.score > 350 RETURN COUNT(n) as c"); //1
//        countQuery("MATCH (n:Post) WHERE n.score > 350 WITH COLLECT(ID(n)) AS v MATCH (n) WHERE ID(n) IN v RETURN COUNT(n) as c"); // U1

//        countQuery("MATCH (n:Post) WHERE n.score < 800 AND n.score > 350 RETURN COUNT(n) as c"); //2
//        countQuery("MATCH (n:Post) WHERE n.score < 800 AND n.score > 350 WITH COLLECT(ID(n)) AS v MATCH (n) WHERE ID(n) IN v RETURN COUNT(n) as c"); //U2

//        countQuery("MATCH (n:User) WHERE n.upvotes > 1000 RETURN COUNT(n) as c"); //3
//        countQuery("MATCH (n:User) WHERE n.upvotes > 1000 WITH COLLECT(ID(n)) AS v MATCH (n) WHERE ID(n) IN v RETURN COUNT(n) as c"); //U3

//        countQuery("MATCH (n:User) WHERE n.reputation > 90000 RETURN COUNT(n) as c"); //4
//        countQuery("MATCH (n:User) WHERE n.reputation > 90000 WITH COLLECT(ID(n)) AS v MATCH (n) WHERE ID(n) IN v RETURN COUNT(n) as c"); //U4


//        countQuery("MATCH (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) WHERE n.upvotes > 800 AND po.comments > 10  RETURN COUNT(po2) as c"); //6
//        countQuery("MATCH (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) WHERE n.upvotes > 800 AND po.comments > 10 WITH COLLECT(ID(po2)) AS v MATCH (n) WHERE ID(n) IN v RETURN COUNT(n) as c"); //6

//        countQuery("MATCH (n:Post)-[:PARENT_OF]-(m:Post) WHERE m.score > 100 AND m.score < 600 RETURN COUNT(n) as c"); //7
//        countQuery("MATCH (n:Post)-[:PARENT_OF]-(m:Post) WHERE m.score > 100 AND m.score < 600 WITH COLLECT(ID(n)) AS v MATCH (n) WHERE ID(n) IN v RETURN COUNT(n) as c"); //7

//        countQuery("MATCH (n:Tag) WHERE n.tagId = 'java' OR n.tagId = 'html' RETURN COUNT(n) as c"); //8
//        countQuery("MATCH (n:Tag) WHERE n.tagId = 'java' OR n.tagId = 'html'  WITH COLLECT(ID(n)) AS v MATCH (n) WHERE ID(n) IN v RETURN COUNT(n) as c"); // u8

//        countQuery("MATCH (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) WHERE n.upvotes > 800 AND po.comments > 10 AND po2.score > 350 RETURN COUNT(n) as c"); // use 9
        //not smart, actually stupid
//        countQuery("MATCH (n:Post) \n" +
//                "    WHERE n.score > 350 \n" +
//                "    WITH COLLECT(ID(n)) as V1\n" +
//                "    \n" +
//                "    MATCH (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) \n" +
//                "    WHERE n.upvotes > 800 AND po.comments > 10  \n" +
//                "    WITH V1, COLLECT(ID(po2)) as V8\n" +
//                "    \n" +
//                "    MATCH (n) WHERE ID(n) IN V1 AND ID(n) IN V8\n" +
//                "    RETURN COUNT(n) as c"); //U9

//        countQuery("MATCH (n:User)-[:POSTED]-(p:Post) WHERE n.upvotes > 1000 RETURN COUNT(DISTINCT p) as c"); //u 10
//        countQuery("MATCH (n:User) WHERE n.upvotes > 1000 WITH COLLECT(ID(n)) AS v MATCH (n)-[:POSTED]-(p:Post) WHERE ID(n) IN v RETURN COUNT(DISTINCT p) as c"); //u10

//        countQuery("MATCH (n:User)-[:POSTED]-(p:Post)-[:PARENT_OF]-(m:Post) WHERE n.upvotes > 1000 AND m.score > 100 AND m.score < 600 AND n.reputation > 2*p.score OR n.downvotes < p.score RETURN COUNT(n) as c"); //12
//        countQuery("MATCH (n:User) WHERE n.upvotes > 1000 WITH COLLECT(ID(n)) AS v1 " +
//                    "MATCH (n:Post)-[:PARENT_OF]-(m:Post) WHERE m.score > 100 AND m.score < 600 " +
//                            " WITH v1, COLLECT(ID(n)) AS v2 " +
//                            " MATCH (n)-[:POSTED]-(p:Post) WHERE ID(n) IN v1 AND ID(p) IN v2 " +
//                            "AND n.reputation > 2*p.score OR n.downvotes<p.score RETURN COUNT(n) as c"); //u12



//        countQuery("MATCH (n:Post) WHERE n.score > 350 RETURN COUNT(n) as c"); // v1
//        countQuery("MATCH (n:Post) WHERE n.score < 800 AND n.score > 350 RETURN COUNT(n) as c"); //v2
//        countQuery("MATCH (n:User) WHERE n.upvotes>1000 RETURN COUNT(n) as c"); //v3
//        countQuery("MATCH (n:User) WHERE n.reputation > 90000 RETURN COUNT(n) as c"); //U4
//        countQuery("MATCH p = (n:User)-[:POSTED]-(po:Post) WHERE n.reputation < 500 RETURN COUNT(n) as c"); //5 nodes
//        countQuery("MATCH p = (n:User)-[:POSTED]-(po:Post) WHERE n.reputation < 500 RETURN COUNT(p) as c"); //5 paths
//        countQuery("MATCH (n:User)-[:POSTED]-(po:Post)-[:PARENT_OF]-(po2:Post) WHERE n.upvotes > 800 AND po.comments > 10  RETURN COUNT(po2) as c"); //6
//        countQuery("MATCH (n:Post)-[:PARENT_OF]-(m:Post) WHERE m.score > 100 AND m.score < 600 RETURN COUNT(n) as c"); //7
//        countQuery("MATCH (n:User)-[:POSTED]-(p:Post) WHERE n.userId = 19 RETURN COUNT(p) as c"); // u8
//        countQuery("MATCH (n:Tag) WHERE n.tagId = 'java' OR n.tagId = 'html' RETURN COUNT(n) as c"); //U9
//        countQuery("MATCH (n:User)-[:POSTED]-(p:Post) WHERE n.upvotes > 1000 OR p.score > 350 RETURN COUNT(p) as c"); //u10
//        countQuery("MATCH (betterPost:Post)-[:PARENT_OF]-(worstPost:Post) WHERE worstPost.score < 10 AND betterPost.score > worstPost.score * 10 RETURN COUNT(betterPost) as c"); //u11
//        System.out.print("12 result:");
//        countQuery("MATCH (p1:Post)-[:HAS_TAG]-(t:Tag) WITH p1, COUNT(t) as numberOfTags WHERE numberOfTags > 20 RETURN numberOfTags as c"); //12 result
//        countQuery("MATCH (p1:Post)-[:HAS_TAG]-(t:Tag) RETURN COUNT(p1) as c"); //12 paths
//        countQuery("MATCH (p1:Post)-[:HAS_TAG]-(t:Tag) WITH p1, COUNT(t) as numberOfTags WHERE numberOfTags > 20 RETURN COUNT(p1) as c");

//        countQuery("MATCH (n:User)-[:POSTED]-(p:Post)-[:HAS_TAG]-(t:Tag) RETURN COUNT(n) as c"); //13 paths
//        countQuery("MATCH (n:User)-[:POSTED]-(p:Post)-[:HAS_TAG]-(t:Tag) WITH n,t, COUNT(*) as numberOfPosts WITH n,COLLECT(t) as tags, COLLECT(numberOfPosts) as counts, MAX(numberOfPosts) as highestTagCount WITH n,highestTagCount, [i IN range(0, size(counts)-1) | CASE WHEN counts[i] = highestTagCount THEN tags[i] ELSE NULL END] AS finalVal RETURN COUNT(n) as c");



    }






    public static void countQuery(String q){

        connector.counts(q);

    }




}
