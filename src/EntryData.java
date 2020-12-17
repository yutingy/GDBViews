import java.util.List;

public class EntryData {



    public List<String> dependents;
    public List<Condition> conditions;



    public boolean compareWithChange(List<Condition> graphChangeConditions, GraphChange graphChange){
        //returns true if the graph change affects this EntryData

        switch(graphChange.getGraphChangeType()){

            case DELETE:{


            }

            case INSERT:{

            }

            case UPDATE:{

            }


        }





        return false;
    }


}
