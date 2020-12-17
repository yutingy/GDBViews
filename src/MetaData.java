import gen.ViewParser;

import java.util.HashSet;
import java.util.Set;

public class MetaData {

    //

    enum MetaType {
        RETURNSYMBOL,
        RELATIONSHIP1, //AtomAtom
        RELATIONSHIP2, //AtomVar
        RELATIONSHIP3, //VarAtom
        RELATIONSHIP4, //VarVar
        NODETYPE
    }

    MetaType metaType;
    String returnSymbol;
    ViewQueryListener.retType returnType;

    ViewParser.ViewatomContext Leftctx;
    ViewParser.ViewatomContext Rightctx;
    ViewParser.QueryContext qctx;

    Set<ViewParser.BoolexprContext> conditions = new HashSet<ViewParser.BoolexprContext>();


    String nodeName;
    String nodeType;

    String relationshipName;
    String relationshipType;

    String LHSName; //can be view name
    String RHSName; //can be view name

    public MetaData(String LHS, String RHS, String relationship, MetaType mType){
        metaType = mType;
        LHSName = LHS;
        RHSName = RHS;

        if(relationship.contains(":")) {
            // r:Type or :Type

            int parts = relationship.split(":").length;

            if(parts==2){
                String rName = relationship.split(":")[0];
                String rType = relationship.split(":")[1];

                relationshipName = rName;
                relationshipType = rType;
            }
            else{
                relationshipName = "";
                relationshipType = relationship.split(":")[0];
            }

        }
        else{
            // [] or [r]
            relationshipType = "";

            if(relationship.equals("")){
                relationshipName = "";
            }
            else{
                relationshipName = relationship;
            }

        }

        //System.out.println(relationshipName + ":" + relationshipType);

    }

    public MetaData(String nName, String nType){
        nodeName = nName;
        nodeType = nType;
        metaType = MetaType.NODETYPE;
    }

    public MetaData(String returnsymbol, ViewQueryListener.retType returntype){

        returnSymbol = returnsymbol; //symbol of return
        metaType = MetaType.RETURNSYMBOL; //type of metadata - return
        returnType = returntype; //path, nodes, etc
    }

    public MetaData(){
        //null constructor
    }

    public void setLeftAtom(ViewParser.ViewatomContext context){

        Leftctx = context;

    }

    public void setRightAtom(ViewParser.ViewatomContext context){
        Rightctx = context;
    }

    public void setQuery(ViewParser.QueryContext ctx){
        qctx = ctx;
    }

    public String toString(){
        return "MetaType " + metaType;
    }

    public void printConditions(){

        for (ViewParser.BoolexprContext ctx : conditions){

            System.out.println(ctx.getText());

        }

    }





}
