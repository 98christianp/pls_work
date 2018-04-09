
import com.sun.source.doctree.SinceTree;

import java.util.*;

public class Graph extends GCLBaseVisitor<String> {

    private Stack<Node> nodeStackStart = new Stack<Node>();
    private Stack<Node> nodeStackEnd = new Stack<Node>();
    private ArrayList<Edge> edgeList = new ArrayList<Edge>();
    private int nodeCount;

    private void buildEdge(int count, String text){
        Node n1 = nodeStackStart.pop();
        nodeStackStart.push(new Node());

        Node n2;
        if(count !=0){
            n2 = new Node();
        }
        else {
            n2 = nodeStackEnd.pop();
        }

        Edge e1 = new Edge(n1,text,n2);
        edgeList.add(e1);
    }

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
        System.out.println(1);
        nodeStackStart.push(new Node());
        System.out.println(2);
        nodeStackEnd.push(new Node(-1));
        System.out.println(3);
        this.visit(ctx.b());
        System.out.println(4);
        return "";
    }

    @Override
    public String visitBoolCompare(GCLParser.BoolCompareContext ctx) {

        buildEdge(ctx.getChildCount(),ctx.getText());

        visitChildren(ctx);

        return "";
    }

    @Override
    public String visitTrue(GCLParser.TrueContext ctx) {
        visitChildren(ctx);
        return "";
    }

    @Override
    public String visitCSep(GCLParser.CSepContext ctx) {
        System.out.println("TEST2");
        buildEdge(ctx.getChildCount(),ctx.getText());
        visitChildren(ctx);
        return "";
    }
    @Override
    public String visitCSkip(GCLParser.CSkipContext ctx) {
        System.out.println("TEST1");
        buildEdge(ctx.getChildCount(),ctx.getText());
        visitChildren(ctx);
        return "";
    }

}