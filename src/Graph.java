
import com.sun.source.doctree.SinceTree;

import java.util.*;

public class Graph extends GCLBaseVisitor<String> {

    private StackConf<Node> nodeStackStart = new StackConf<Node>();
    private StackConf<Node> nodeStackEnd = new StackConf<Node>();
    private ArrayList<Edge> edgeList = new ArrayList<Edge>();
    private int nodeCount;



    private void buildEdge(int count, String text,boolean Ta){
        /*
        Node n1,n2;
        n1 = nodeStackStart.peek();
        if (n1==null) {

            n1 = new Node();
            System.out.println("NEW: "+n1);
        }


        n2 = nodeStackEnd.pop();
        if(n2 == null){
            n2 = new Node();
        }

        nodeStackStart.push(n2);

        Edge e1 = new Edge(n1,text,n2);
        edgeList.add(e1);
        */
        Node n1,n2;

        if(Ta){
            n1 = new Node(this.nodeCount);
            n2 = nodeStackEnd.pop();
        }
        else{

            n1 = nodeStackStart.pop();
            n2 = new Node(this.nodeCount);
        }
        this.nodeCount++;

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

        visitChildren(ctx);
        //this.visit(ctx.exprC());

        return "";
    }
/*
    @Override public String visitBoolDouble(GCLParser.BoolDoubleContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText(),false);
        return "";
    }

    @Override public String visitBoolCompare(GCLParser.BoolCompareContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText(),false);
        return "";
    }

    @Override public String visitTrue(GCLParser.TrueContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText(),false);
        return "";
    }

    @Override public String visitBoolNot(GCLParser.BoolNotContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText(),false);
        return "";
    }

    @Override public String visitFalse(GCLParser.FalseContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText(),false);
        return "";
    }

    @Override public String visitBoolBracket(GCLParser.BoolBracketContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText(),false);
        return "";
    }

    @Override public String visitAritVar(GCLParser.AritVarContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText(),true);
        return "";
    }

    @Override public String visitAritDouble(GCLParser.AritDoubleContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText(),true);
        return "";
    }

    @Override public String visitAritParentheses(GCLParser.AritParenthesesContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText(),true);
        return "";
    }

    @Override public String visitAritPower(GCLParser.AritPowerContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText(),true);
        return "";
    }

    @Override public String visitAritDig(GCLParser.AritDigContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText(),true);
        return "";
    }

    @Override public String visitAritNeg(GCLParser.AritNegContext ctx) {
        buildEdge(ctx.getChildCount(),ctx.getText(),true);
        return "";
    }
*/

    @Override
    public String visitCAssign(GCLParser.CAssignContext ctx) {

        Node n1,n2;
        n2= nodeStackEnd.pop();
        n1 = nodeStackStart.pop();
        n1 = n1!=null?n1:new Node(nodeCount);
        n2 = n2!=null?n2:new Node(nodeCount+1);
        nodeCount++;
        Edge e1 = new Edge(n1,ctx.getText(),n2);
        edgeList.add(e1);

        //buildEdge(ctx.getChildCount(),ctx.getText(),true);
        //visitChildren(ctx);
        return "";
    }

    @Override
    public String visitCSkip(GCLParser.CSkipContext ctx) {
        Node n1,n2;
        n2= nodeStackEnd.pop();
        n1 = nodeStackStart.pop();
        n1 = n1!=null?n1:new Node(nodeCount);
        n2 = n2!=null?n2:new Node(nodeCount+1);
        nodeCount++;
        Edge e1 = new Edge(n1,ctx.getText(),n2);
        edgeList.add(e1);
        return "";
    }

    @Override
    public String visitCSep(GCLParser.CSepContext ctx) {

        visit(ctx.getChild(0));
        visit(ctx.getChild(2));
        // TODO; how to change end?

        return "";
    }
    // b -> G
    @Override public String visitGCOnCondtion(GCLParser.GCOnCondtionContext ctx) {
        String text = ctx.getChild(0).getText();
        Node n1,n2;
        n1 = nodeStackStart.pop();
        n1 = n1!=null?n1:new Node(nodeCount);
        n2 = new Node(nodeCount+1);
        nodeCount++;
        Edge e1 = new Edge(n1, text, n2);
        edgeList.add(e1);
        visit(ctx.getChild(2));

        return "";
    }
    // GC [] GC
    @Override public String visitGCOnCondition(GCLParser.GCOnConditionContext ctx) {
        Node startNode = new Node(nodeCount);

        Node endNode = new Node(nodeCount+1);
        nodeCount ++;

        nodeStackStart.push(startNode);
        nodeStackEnd.push(endNode);
        visit(ctx.getChild(0));
        nodeStackStart.pop();
        nodeStackEnd.pop();
        nodeCount --;
        nodeStackStart.push(startNode);
        nodeStackEnd.push(endNode);
        visit(ctx.getChild(2));
        //nodeStackStart.pop();

        nodeStackStart.push(endNode);

        //nodeCount ++;

        return "";
    }

    @Override
    public String visitCIf(GCLParser.CIfContext ctx) {
        visitChildren(ctx);
        return "";
    }
}