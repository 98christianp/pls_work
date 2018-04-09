
import com.sun.source.doctree.SinceTree;

import java.util.*;

public class Graph extends GCLBaseVisitor<String> {

    private Stack<Node> nodeStackStart = new Stack<Node>();
    private Stack<Node> nodeStackEnd = new Stack<Node>();
    private ArrayList<Edge> edgeList = new ArrayList<Edge>();
    private int nodeCount;



    private void buildEdge(int count, String text){
        Node n1,n2;

        if (false) {
            n1 = nodeStackStart.pop();
        }
        else {
            n1 = nodeStackStart.pop();
            //n1 = new Node();
        }


        if(count != -10){
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
        String output = "\nGraph:\n\n\ndigraph program_graph {rankdir=LR;\n" +
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


        visitChildren(ctx);
        //this.visit(ctx.exprC());

        return "";
    }

    @Override public String visitBoolDouble(GCLParser.BoolDoubleContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText());
        return "";
    }

    @Override public String visitBoolCompare(GCLParser.BoolCompareContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText());
        return "";
    }

    @Override public String visitTrue(GCLParser.TrueContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText());
        return "";
    }

    @Override public String visitBoolNot(GCLParser.BoolNotContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText());
        return "";
    }

    @Override public String visitFalse(GCLParser.FalseContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText());
        return "";
    }

    @Override public String visitBoolBracket(GCLParser.BoolBracketContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText());
        return "";
    }

    @Override
    public String visitCSep(GCLParser.CSepContext ctx) {
        visitChildren(ctx);
        return "";
    }

    @Override
    public String visitCAssign(GCLParser.CAssignContext ctx) {
            buildEdge(ctx.getChildCount(),ctx.getText());
            visitChildren(ctx);
            return "";
        }

    @Override
    public String visitCSkip(GCLParser.CSkipContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText());
        visitChildren(ctx);
        return "";
    }

    @Override public String visitGCOnCondtion(GCLParser.GCOnCondtionContext ctx) {


        //buildEdge(1,ctx.getChild(0).getText());

        visitChildren(ctx);
        return "";
    }

    @Override
    public String visitCIf(GCLParser.CIfContext ctx) {

        visitChildren(ctx);
        return "";
    }
}