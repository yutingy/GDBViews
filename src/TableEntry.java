import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TableEntry {


    private String myKey;
    private List<EntryData> entries;

    public TableEntry(String k){
        myKey=k;
        entries = new LinkedList<>();
    }


    public boolean isEmpty(){
        if(entries.size()==0) return true;
        return false;
    }

    public void addEntry(EntryData e){
        entries.add(e);
    }

    public List<EntryData> getEntries() {
        return entries;
    }


    public boolean addSameDependents(Set<Condition> edConds, List<String> deps){





        for(EntryData myED : entries){


//            System.out.println("Mine: ");
//            for(Condition c : myED.getConditions()) c.printCondition();
//            System.out.println("Compared with : ");


            Set<Condition> myConds = new HashSet<>(myED.getConditions());
//            for(Condition d : myConds) d.printCondition();

            if(myConds.equals(edConds)){

                int i = entries.indexOf(myED);
                entries.get(i).addDependent(deps);
                return true;
            }

        }

        return false;

    }

}
