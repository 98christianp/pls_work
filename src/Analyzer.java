import java.util.*;


public class Analyzer extends Interpreter {

    public HashMap<String, String> abstractMemory = new HashMap<String,String>();
    private ArrayList<Edge> edges;

    public Analyzer(ArrayList<Edge> edgeList){
        super(edgeList);
        this.edges = edgeList;
    }

    @Override
    public Object visitCAssign(GCLParser.CAssignContext ctx) {
        this.abstractMemory.put(ctx.getChild(0).getText(), null);
        return true;
    }






}
