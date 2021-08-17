package main;

import java.io.*;
import java.util.*;

import jess.*;
import org.neo4j.configuration.GraphDatabaseSettings;
import org.neo4j.dbms.api.DatabaseManagementService;
import org.neo4j.graphdb.*;
//import org.neo4j.graphdb.factory.GraphDatabaseFactory;
//import org.neo4j.graphdb.factory.GraphDatabaseSettings;
//import org.neo4j.helpers.collection.IteratorUtil;
//import org.neo4j.kernel.impl.core.NodeProxy;


import org.neo4j.dbms.api.DatabaseManagementServiceBuilder;
import org.neo4j.graphdb.Node;

public class Neo4jGraphConnector{

    //NEO4J using enterprise edition 4.0.4 JARS (community will not work for multi databases)

    public static GraphDatabaseService db;
    public static long startTime;
    public static long endTime;


    DatabaseManagementService databaseManagementService;



    public static Set<String> nodeSet = new HashSet<String>();
    public Set<String> getNodeSet(){
        return nodeSet;
    }

    public static Set<Relationship> pathQuery(String query){

 //       System.out.println("Executing query: " + query);

        Set<Relationship> retset = new HashSet<>();



        try (Transaction tx = db.beginTx()) {
            Result result = tx.execute(query);

            while (result.hasNext()) {
//                System.out.println("next");
                Map<String, Object> row = result.next();
                for (Map.Entry<String, Object> column : row.entrySet()) {

                    Path path = (Path)column.getValue();


                    Iterable<Relationship> iterable = path.relationships();
                    Iterator<Relationship> it = iterable.iterator();

                    while(it.hasNext()){
                        Relationship rel = it.next();
                        retset.add(rel);

                    }


                }

            }

            relationshipNodes(retset);

            tx.commit();


        }


        System.out.println("Return set contains " + retset.size());
        return retset;
    }

    public Set<String> executeQuery(String query){

        Set<String> nodeids = new HashSet<String>();

        if(query.equals("")) return nodeids ;

        //System.out.println("Executing query: " + query);

        if(query.contains("REMOVE") || query.contains("SET")) return nodeids; //todo remove when testing

//        if(!query.equals("")) return nodeids;

        String rows = "";
        int numResults = 0;


        if(query.contains("RETURN DISTINCT ID(")){

            try( Transaction tx = db.beginTx()){
                Result result = tx.execute( query );
                while (result.hasNext())
                {
                    Map<String, Object> row = result.next();
                    for (Map.Entry<String, Object> column : row.entrySet())
                    {
                        nodeids.add(column.getValue().toString());
                    }


                }
                tx.commit();
            }

        }

        else if(query.contains("RETURN COUNT")){
            try (Transaction tx = db.beginTx()) {
                Result result = tx.execute(query);

                while(result.hasNext()){
                    Map<String, Object> row = result.next();
                    for (Map.Entry<String, Object> column : row.entrySet()) {
                        rows += column.getKey() + ": " + column.getValue() + "; ";
                    }
                }
                System.out.println(rows);

//                List<String> columns = result.columns();
//                Iterator<Long> counts = result.columnAs("c");
//                counts.forEachRemaining(val -> System.out.println(val));
////                System.out.println(counts);


            }
        }

        else {
            try (Transaction tx = db.beginTx()) {
                Result result = tx.execute(query);
                while (result.hasNext()) {
                    Map<String, Object> row = result.next();
                    numResults++;
                    for (Map.Entry<String, Object> column : row.entrySet()) {



                        rows += column.getKey() + ": " + column.getValue() + "; ";
                    }
                    rows += "\n";

                }
                tx.commit();


            }
        }
        System.out.println("Execution done");


        return nodeids;

    }

    public static void counts(String q){

        try (Transaction tx = db.beginTx()) {
            Result result = tx.execute(q);

            List<String> columns = result.columns();
            Iterator<Long> counts = result.columnAs("c");
            System.out.println(counts.next());


        }
    }


    public void shutdown(){
        databaseManagementService.shutdown();
    }


    public static Set<String> relationshipNodes(Set<Relationship> relationshipSet){

        Set<String> nodeids = new HashSet<String>();
        for(Relationship r : relationshipSet){
            Node[] nodeSet = r.getNodes();
            for (Node n : nodeSet){
                String nodeid = ""+n.getId();
                if(!nodeids.contains(nodeid)) nodeids.add(nodeid);
            }
        }

        nodeSet = nodeids;
        return nodeids;
    }

    public Neo4jGraphConnector(String size) {

        String path = getDbPath(size);
        File dbHome = new File(path);

        databaseManagementService = new DatabaseManagementServiceBuilder(dbHome)
                .setConfig(GraphDatabaseSettings.default_database, "neo4j")
                .build();


        db = databaseManagementService.database("neo4j");
        System.out.println("neo4j graph connector set-up done.");

    }


    public String getDbPath(String size){
        String configPath = "/test/config";
        try {
            Scanner sc = new Scanner(new File(configPath));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line.startsWith(size.toLowerCase())){
                    return line.split("=")[1];
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }



    //for the Jess side...

    public static Set<JessNode> getNodes(String query, Rete engine) throws JessException {


        Set<JessNode> nodeSet = new HashSet<>();

        String after = (query.split(":")[1]);
        String label = after.split("\\)")[0];

        System.out.println("Label is " + label);

        NodeEnum lab = NodeEnum.User; //default
        if(label.equals("Post")) lab = NodeEnum.Post;
        else if (label.equals("Tag")) lab = NodeEnum.Tag;
        else if (label.equals("User"));
        else System.out.println("invalid label specified");


        try (Transaction tx = db.beginTx();
             Result result = tx.execute(query)) {
            while (result.hasNext()) {
                Map<String, Object> row = result.next();
                JessNode entry = new JessNode();

                //todo manual label set
                entry.setLabel(lab);




                for (Map.Entry<String, Object> column : row.entrySet()) {



                    if(column.getValue() == null) continue;

                    if((""+column.getKey()).equals("id")) {
                        entry.setId(Integer.parseInt(""+column.getValue()));
                        continue;
                    }

                    switch (lab){

                        case User:{

                            switch(""+column.getKey()) {
                                case "displayname": {
                                    entry.setDisplayname("" + column.getValue());
                                    break;
                                }
                                case "userId": {
                                    entry.setUserId(Integer.parseInt("" + column.getValue()));
                                    break;
                                }
                                case "aboutme": {
                                    entry.setAboutme("" + column.getValue());
                                    break;
                                }
                                case "reputation": {
                                    entry.setReputation(Integer.parseInt("" + column.getValue()));
                                    break;
                                }
                                case "upvotes": {
                                    entry.setUpvotes(Integer.parseInt("" + column.getValue()));
                                    break;
                                }
                                case "downvotes": {
                                    entry.setDownvotes(Integer.parseInt("" + column.getValue()));
                                    break;
                                }
                                case "views": { //doesn't work since the other middleware sets views to an array
                                    entry.setViews(Integer.parseInt("" + column.getValue()));
                                    break;
                                }
                                default:{
                                    System.out.println("Userdefaulted");
                                    break;
                                }
                            }

                            break;

                        }
                        case Post:{

                            switch(""+column.getKey()){

                                //Post type
                                case "body":{

                                    entry.setBody(""+column.getValue());
                                    break;
                                }
                                case "comments":{
                                    entry.setComments(Integer.parseInt(""+column.getValue()));
                                    break;
                                }
                                case "postId":{
                                    entry.setPostId(Integer.parseInt(""+column.getValue()));
                                    break;
                                }
                                case "score":{
                                    entry.setScore(Integer.parseInt(""+column.getValue()));
                                    break;
                                }
                                case "tagId":{
                                    entry.setTagId((""+column.getValue()));
                                    break;
                                }
                                default:{
                                    System.out.println("Postdefaulted");
                                    break;
                                }
                            }

                            break;

                        }
                        case Tag:{
                            if ((""+column.getKey()).equals("tagId")){
                                entry.setTagId(""+column.getValue());
                            }

                            break;

                        }

                    }


                }

                engine.add(entry);
//                nodeSet.add(entry);

            }
        }
        return nodeSet;
    }

    public static Set<JessEdge> getEdges(String query, Rete engine) throws JessException {


        Set<JessEdge> edgeSet = new HashSet<>();

        String after = (query.split(":")[1]);
        String label = after.split("]")[0];

        System.out.println("Label is " + label);

        EdgeEnum lab = EdgeEnum.POSTED; //default
        if(label.equals("PARENT_OF")) lab = EdgeEnum.PARENT_OF;
        else if (label.equals("HAS_TAG")) lab = EdgeEnum.HAS_TAG;
        else if (label.equals("POSTED"));
        else System.out.println("invalid label found");


        try (Transaction tx = db.beginTx();
             Result result = tx.execute(query)) {
            while (result.hasNext()) {


                Map<String, Object> row = result.next();
                JessEdge entry = new JessEdge();


//                System.out.println(row.toString());

                //todo manual label set
                entry.setLabel(lab);



                for (Map.Entry<String, Object> column : row.entrySet()) {

                    if(column.getValue() == null) continue;

                    boolean flag = true;



                    switch(""+column.getKey()) {
                        case "identity": {
                            entry.setIdentity(Integer.parseInt(""+ column.getValue()));
//                            if(Integer.parseInt(""+column.getValue())!=191317 && Integer.parseInt(""+column.getValue())!=1950652) flag = false;
                            break;
                        }
                        case "start": {
                            entry.setStart(Integer.parseInt("" + column.getValue()));
                            break;
                        }
                        case "end": {
                            entry.setEnd(Integer.parseInt(""+ column.getValue()));;
                            break;
                        }
                        default:{
                            System.out.println("defaulted");
                            break;
                        }
                    }



                }

                engine.add(entry);
//                edgeSet.add(entry);

            }
        }
        return edgeSet;
    }


    public static void main(String[] args){

        //main method not used, only for testing purposes

        Neo4jGraphConnector connector  = new Neo4jGraphConnector("small");

//        connector.executeQuery("MATCH path = (n)-[]-(m)\n" +
//                "FOREACH(pathnode in nodes(path) | SET(CASE WHEN NOT EXISTS(pathnode.views) THEN pathnode END).views = [] SET pathnode.views = (CASE WHEN \"hiddenview1\" IN pathnode.views THEN [] ELSE [\"hiddenview1\"] END) + pathnode.views)\n" +
//                "FOREACH(pathnode in relationships(path) | SET(CASE WHEN NOT EXISTS(pathnode.views) THEN pathnode END).views = [] SET pathnode.views = (CASE WHEN \"hiddenview1\" IN pathnode.views THEN [] ELSE [\"hiddenview1\"] END) + pathnode.views)");

        test("MATCH(n:User) where n.reputation>100 return n");



        connector.shutdown();




    }

    public static void test(String query){



        String rows = "";

        long now = System.currentTimeMillis();


            try( Transaction tx = db.beginTx()){
                Result result = tx.execute( query );
                while (result.hasNext())
                {
//                    Map<String, Object> row = result.next();
//                    for (Map.Entry<String, Object> column : row.entrySet())
//                    {
//                        rows += column.getKey() + ": " + column.getValue() + "; ";
//                    }


                }
                tx.commit();
            }

        long nownow = System.currentTimeMillis();
        System.out.println("Execution done: total time = " + (nownow -now));

    }


}

