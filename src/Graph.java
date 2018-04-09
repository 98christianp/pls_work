
import com.sun.source.doctree.SinceTree;

import java.util.*;

public class Graph extends GCLBaseVisitor<String> {

    private Stack<Node> nodeStackStart = new Stack<Node>();
    private Stack<Node> nodeStackEnd = new Stack<Node>();
    private ArrayList<Edge> edgeList = new ArrayList<Edge>();
    private int nodeCount;

    private void buildEdge(int count, String text){
        Node n1 = nodeStackStart.pop();
        Node n2;

        System.out.println("Children;"+count);
        if(count != 0){
            n2 = new Node();
        }
        else {
            n2 = nodeStackEnd.pop();
        }
        nodeStackStart.push(n2);

        Edge e1 = new Edge(n1,text,n2);
        edgeList.add(e1);

    }

    @Override
    public String toString(){
        String output = "digraph program_graph {rankdir=LR;\n" +
                "node [shape = circle]; q▷;\n" +
                "node [shape = doublecircle]; q◀; \n" +
                "node [shape = circle]\n";


        for(Edge e : this.edgeList){

            output = output.concat(e + "\n");
        }
        output = output.concat("}");
        return output;

    }

    @Override
    public String visitStart(GCLParser.StartContext ctx) {

        nodeStackStart.push(new Node());

        nodeStackEnd.push(new Node(-1));

        this.visit(ctx.exprC());

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
        System.out.println("c:"+ctx.getChildCount());
        //buildEdge(ctx.getChildCount(),ctx.getText());
        visitChildren(ctx);
        return "";
    }
    @Override
    public String visitCSkip(GCLParser.CSkipContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText());
        visitChildren(ctx);
        return "";
    }

}