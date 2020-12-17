import java.util.LinkedList;
import java.util.List;

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





}
