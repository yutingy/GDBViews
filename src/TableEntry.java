import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.util.*;

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

    public Set<EntryData> getSameDependents(Set<Condition> edConds){

        Set<EntryData> returnSet = new HashSet<>();


        for(EntryData myED : entries){


//            System.out.println("Mine: ");
//            for(Condition c : myED.getConditions()) c.printCondition();
//            System.out.println("Compared with : ");


            Set<Condition> myConds = new HashSet<>(myED.getConditions());
//            for(Condition d : myConds) d.printCondition();

            if(myConds.equals(edConds)){

                returnSet.add(myED);
            }

        }

        return returnSet;
    }


    //Used so FAR for DELETIONS and UPDATES
    public Set<EntryData> filterIrrelevantEntryData(Set<Condition> conditions){

        //Given the conditions as input, which EntryData will ABSOLUTELY not be affected by
        //purely these conditions? ASSUMING all condition sets are joined by AND clauses.
        //>> As long as there is a MISMATCH of a condition, it can be filtered out. Otherwise, it should be
        //marked.


        //First thing to check: mismatches of conditions (done)
        //Second thing to check: does the change contain any on attributes not present in an EntryData?
        //      if so we FORCE these to be invalidated (keep them!) aka distinct sets. (DONE since
        //              DONE since DEFAULT is ENTIRE SET and in case of disjoint sets LOOP WILL DO NOTHING
        //Third thing to check: what if we don't have any conditions in our EntryData?
        //      if so then we must be safe an re-evaluate (DONE since DEFAULT IS THE ENTIRE SET)

        Set<EntryData> returnSet = new HashSet<>();
        returnSet.addAll(entries);


        //if conditions is empty (i.e, the graph change has no conditions) then we return the full set
        if(conditions == null || conditions.isEmpty()) return returnSet;



        for(EntryData myED : entries){


            Set<Condition> myConds = new HashSet<>(myED.getConditions());

            if(myConds.isEmpty()) continue;

            boolean breakLoop = false;
            for(Condition cMine : myConds){
                if(breakLoop) break;

                for(Condition cTheir : conditions){



                    if(cMine.attribute.equals(cTheir.attribute)){
                        if(cMine.conditionString.contains(">")){
                            if(cTheir.conditionString.contains(">")){
                                //view: a>3. change: a>4.
                                //should be affected, don't filter it out
                            }
                            if(cTheir.conditionString.contains("<")){
                                //view: a>3. change: a<2. filter.
                                //view: a>3. change: a<4. don't filter.

                                String valMine = cMine.conditionString.split(">")[1];
                                String valTheir = cTheir.conditionString.split("<")[1];

                                if(StringUtils.isNumeric(valMine) && StringUtils.isNumeric(valTheir)){
                                    if((Integer.parseInt(valMine) >= Integer.parseInt(valTheir))){
                                        //Then WE FILTER THIS. Since this EntryData SHOULD NOT BE AFFECTED
                                        returnSet.remove(myED);
                                        breakLoop = true;
                                        break;
                                    }
                                }
                            }
                            if(cTheir.conditionString.contains("=")){
                                //same as above

                                String valMine = cMine.conditionString.split(">")[1];
                                String valTheir = cTheir.conditionString.split("=")[1];

                                if(StringUtils.isNumeric(valMine) && StringUtils.isNumeric(valTheir)){
                                    if((Integer.parseInt(valMine) >= Integer.parseInt(valTheir))){
                                        //Then WE FILTER THIS. Since this EntryData SHOULD NOT BE AFFECTED
                                        returnSet.remove(myED);
                                        breakLoop = true;
                                        break;
                                    }
                                }
                            }
                        }


                        if(cMine.conditionString.contains("<")){
                            if(cTheir.conditionString.contains(">")){

                                //view: a<3. change: a>4. filter.
                                //view: a<3. change: a>2. don't filter.

                                String valMine = cMine.conditionString.split(">")[1];
                                String valTheir = cTheir.conditionString.split("<")[1];

                                if(StringUtils.isNumeric(valMine) && StringUtils.isNumeric(valTheir)){
                                    if((Integer.parseInt(valMine) <= Integer.parseInt(valTheir))){
                                        //Then WE FILTER THIS. Since this EntryData SHOULD NOT BE AFFECTED
                                        returnSet.remove(myED);
                                        breakLoop = true;
                                        break;
                                    }
                                }
                            }
                            if(cTheir.conditionString.contains("=")){

                                //view: a<3. change: a>4. filter.
                                //view: a<3. change: a>2. don't filter.

                                String valMine = cMine.conditionString.split(">")[1];
                                String valTheir = cTheir.conditionString.split("=")[1];

                                if(StringUtils.isNumeric(valMine) && StringUtils.isNumeric(valTheir)){
                                    if((Integer.parseInt(valMine) <= Integer.parseInt(valTheir))){
                                        //Then WE FILTER THIS. Since this EntryData SHOULD NOT BE AFFECTED
                                        returnSet.remove(myED);
                                        breakLoop = true;
                                        break;
                                    }
                                }
                            }
                            if(cTheir.conditionString.contains("<")){
                                //view: a<3. change: a<4.
                                //should be affected, don't filter it out
                            }
                        }


                        if(cMine.conditionString.contains("=")){
                            if(cTheir.conditionString.contains(">")){
                                //view: a=3. change: a>4. filter.
                                //view: a=3. change: a>2. don't filter.
                                String valMine = cMine.conditionString.split("=")[1];
                                String valTheir = cTheir.conditionString.split(">")[1];

                                if(StringUtils.isNumeric(valMine) && StringUtils.isNumeric(valTheir)){
                                    if((Integer.parseInt(valMine) <= Integer.parseInt(valTheir))){
                                        //Then WE FILTER THIS. Since this EntryData SHOULD NOT BE AFFECTED
                                        returnSet.remove(myED);
                                        breakLoop = true;
                                        break;
                                    }
                                }
                            }
                            if(cTheir.conditionString.contains("<")){
                                //view: a=3. change: a<2. filter.
                                //view: a=3. change: a<4. don't filter.
                                String valMine = cMine.conditionString.split("=")[1];
                                String valTheir = cTheir.conditionString.split("<")[1];

                                if(StringUtils.isNumeric(valMine) && StringUtils.isNumeric(valTheir)){
                                    if((Integer.parseInt(valMine) >= Integer.parseInt(valTheir))){
                                        //Then WE FILTER THIS. Since this EntryData SHOULD NOT BE AFFECTED
                                        returnSet.remove(myED);
                                        breakLoop = true;
                                        break;
                                    }
                                }


                            }
                            if(cTheir.conditionString.contains("=")){

                                //if they're the same value then we don't filter. If they're not the same value
                                //then this view should not be affected, so filter.
                                String valMine = cMine.conditionString.split("=")[1];
                                String valTheir = cTheir.conditionString.split("=")[1];

                                if(!valMine.equals(valTheir)){
                                    returnSet.remove(myED);
                                    breakLoop = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        return returnSet;


    }

}
