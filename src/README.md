Instructions for running:

No command line args. I was lazy and changed the database sizes in the code itself (in main, change the size variable for whichever db you are using). 
A config file is required (see ../test/config for an example) for the database sizes. The reference to this config file can be found in Neo4jGraphConnector.java. 

In order to test view creation/usage easily, a set of files is required. You can still manually test with the enabled terminal, but if you have a set of view definitions or a set of view use queries, then it would be easier to do automatically. See /test/initFileExample.txt for an example for view creation, and ViewUses2.txt for view usage files. Note that * is the comment character for these. An option exists in the method initFile2 to write the identifiers to disk (for later use when testing view usage and maintenance): this will write to a directory within /test/SIZE/ where SIZE is the size of your database (you may need to initialize the directory first). 

In order to load back the data, use the loadTablesFromFiles(size) method to re-populate the node and edge tables. In order to re-populate the dependency tables, use createMetaInfoFromQueries(path_to_init_file) (example commented within the main method). Then you can run testUses(size), in which you may need to modify to adjust paths to your init/use files.


All required libraries should be in /lib/



Data structure info:

Main:
nodeTable and edgeTable store as the key the view name that is used, along with the set of node or edge identifiers returned by the view. pathTable is used but ... I do not think it does anything anymore.

QueryParser: This walks down the tree and executes enter/exit based on which components are entered. Look for ANTLR documentation for details. I set up meta-data during these enter/exit methods and keep the dependencyTable updated if it is a view creation. For view usage, variables are set up (symbols used for view use, set of conditions) so that Main can know which set of identifiers it can pull from the node or edge tables. For view updates, the dependency table is referenced and a set of outdated views is returned to Main, and most steps are commented with details/logic.

DependencyTable is a hashtable with a graph component label as the key (Person, PARENT_OF, Post, etc) and a TableEntry object as the value.
  TableEntry contains a list of EntryData which are associated with itself. For instance, a TableEntry :Post may have several EntryData, which differ due to the set of conditions.
    EntryData contains a condition list (which uniquely identifies it) and a list of views which depend on it. 

All other structures used in QueryParser.java have relevant commenting in the code itself.
