import java.util.List;

public class GraphChange{

    enum changeType{
        DELETE,
        INSERT,
        UPDATE
    }

    //variables that will exist no matter the changeType
    public String fullQuery;
    public List<Condition> conditionList;
    public changeType graphChangeType;

    //deletion-only variables
    public String deletedVarName;
    public String deletedVarLabel;


    //insertion-only variables
    public String insertedQuery;


    //update-only variables
    public String updatedAttribute;
    public String updatedVariableName;


    public changeType getGraphChangeType() {
        return graphChangeType;
    }

    public GraphChange(String query, changeType changetype){

        if(query.contains("SET") || query.contains("REMOVE"))   graphChangeType = changeType.UPDATE;
        if(query.contains("DELETE")) graphChangeType = changeType.DELETE;
        if(query.contains("CREATE")) graphChangeType = changeType.INSERT;

        //all work for figuring out the above variables are here.
        //or maybe it should be in the parser..the parser makes more sense, to be honest since it can directly check the
        //modified values and look for their labels that should have been in the search

        /*

        MATCH ....

        DELETE n

         */
        if(graphChangeType == changeType.DELETE){

            String deletedVar = query.split("DELETE")[1].strip();




        }



    }



}
