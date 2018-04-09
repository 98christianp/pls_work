
import java.util.*;

public class Graph extends GCLBaseVisitor<String> {

    private Stack<Node> nodeStackStart;
    private Stack<Node> nodeStackEnd;
    private ArrayList<Edge> edgeList;
    private int nodeCount;

    @Override
    public String toString(){
        String output = "digraph program_graph {rankdir=LR;\n" +
                "node [shape = circle]; q▷;\n" +
                "node [shape = doublecircle]; q◀; \n" +
                "node [shape = circle]";

        for(Edge e : this.edgeList){
            output.concat(e + "\n");
        }
        output.concat("}");
        return output;

    }

    @Override
    public String visitStart(GCLParser.StartContext ctx) {
        nodeStackStart.add(new Node());
        nodeStackEnd.add(new Node(-1));
        this.visit(ctx.b());
        return "";
    }

    @Override
    public String visitBoolCompare(GCLParser.BoolCompareContext ctx) {
        Node n1 = nodeStackStart.pop();
        nodeStackStart.push(new Node());
        String text = ctx.getText();
        Node n2;
        if(ctx.getChildCount() !=0){
            n2 = new Node();
        }
        else {
            n2 = nodeStackEnd.pop();
        }

        Edge e1 = new Edge(n1,text,n2);
        edgeList.add(e1);
        visitChildren(ctx);

        return "";
    }

    @Override
    public String visitTrue(GCLParser.TrueContext ctx) {
        visitChildren(ctx);
        return "";
    }




}