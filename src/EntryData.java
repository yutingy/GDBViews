import java.util.List;

public class EntryData {



    public List<String> dependents;
    public List<Condition> conditions;




    public boolean containsConditionOnAttribute(String attributeName){


        for(Condition c : conditions){
            if(c.attribute.equals(attributeName)) return true;
            //todo technically can be more specific. eg view condition is "n.attribute = 1" and the change
            //sets the value to attribute = 3. then it should return false.
        }


        return false;

    }


    public boolean compareWithChange(List<Condition> graphChangeConditions, GraphChange graphChange){
        //Method used to compare this EntryData object (a graph change) with other EntryData objects (view!); each object contains a condition set and
        //depending on the type of graph change, we check differently

        //returns true if the graph change affects the EntryData given as input

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

    public void setDependents(List<String> dependents) {
        this.dependents = dependents;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void addDependent(List<String> deps){
        dependents.addAll(deps);
    }
}
