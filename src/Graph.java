
import com.sun.source.doctree.SinceTree;
import org.antlr.v4.runtime.tree.ParseTree;


import java.util.*;

public class Graph extends GCLBaseVisitor<String> {

    private Stack<Node> nodeStackStart = new Stack<Node>();
    private Stack<Node> nodeStackEnd = new Stack<Node>();
    public ArrayList<Edge> edgeList = new ArrayList<Edge>();
    private int nodeCount = 0;



    private void buildEdge(ParseTree ctx){
        Node n1,n2;
        n2 = nodeStackEnd.peek();
        n1 = nodeStackStart.peek();
        Edge e1 = new Edge(n1,ctx,n2);
        edgeList.add(e1);

    }

    private void buildEdge(ParseTree ctx,boolean runDone){
        Node n1,n2;
        n2 = nodeStackEnd.peek();
        n1 = nodeStackStart.peek();
        Edge e1 = new Edge(n1,ctx,n2,true);
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
        //nodeStackStart.add(new Node(0));
        nodeStackStart.add(new Node(0));
        nodeStackEnd.add(new Node(-1));

        visitChildren(ctx);
        //this.visit(ctx.exprC());

        return "";
    }
/*
    @Override public String visitBoolDouble(GCLParser.BoolDoubleContext ctx) {
        buildEdge(ctx.getChildCount(),ctx,false);
        return "";
    }

    @Override public String visitBoolCompare(GCLParser.BoolCompareContext ctx) {
        buildEdge(ctx.getChildCount(),ctx,false);
        return "";
    }

    @Override public String visitTrue(GCLParser.TrueContext ctx) {
        buildEdge(ctx.getChildCount(),ctx,false);
        return "";
    }

    @Override public String visitBoolNot(GCLParser.BoolNotContext ctx) {
        buildEdge(ctx.getChildCount(),ctx,false);
        return "";
    }

    @Override public String visitFalse(GCLParser.FalseContext ctx) {
        buildEdge(ctx.getChildCount(),ctx,false);
        return "";
    }

    @Override public String visitBoolBracket(GCLParser.BoolBracketContext ctx) {
        buildEdge(ctx.getChildCount(),ctx,false);
        return "";
    }

    @Override public String visitAritVar(GCLParser.AritVarContext ctx) {
        buildEdge(ctx.getChildCount(),ctx,true);
        return "";
    }

    @Override public String visitAritDouble(GCLParser.AritDoubleContext ctx) {
        buildEdge(ctx.getChildCount(),ctx,true);
        return "";
    }

    @Override public String visitAritParentheses(GCLParser.AritParenthesesContext ctx) {
        buildEdge(ctx.getChildCount(),ctx,true);
        return "";
    }

    @Override public String visitAritPower(GCLParser.AritPowerContext ctx) {
        buildEdge(ctx.getChildCount(),ctx,true);
        return "";
    }

    @Override public String visitAritDig(GCLParser.AritDigContext ctx) {
        buildEdge(ctx.getChildCount(),ctx,true);
        return "";
    }

    @Override public String visitAritNeg(GCLParser.AritNegContext ctx) {
        buildEdge(ctx.getChildCount(),ctx,true);
        return "";
    }
*/

    @Override
    public String visitCAssign(GCLParser.CAssignContext ctx) {
        buildEdge(ctx);
        return "";
    }

    @Override
    public String visitCSkip(GCLParser.CSkipContext ctx) {
        buildEdge(ctx);
        return "";
    }

    @Override
    public String visitCSep(GCLParser.CSepContext ctx) {


        nodeStackEnd.add(new Node(nodeCount+1));
        nodeCount++;

        visit(ctx.getChild(0));

        nodeStackStart.pop();
        nodeStackStart.add(nodeStackEnd.pop());


        visit(ctx.getChild(2));

        return "";
    }

    // b -> G
    @Override public String visitGCOnCondtion(GCLParser.GCOnCondtionContext ctx) {
        ParseTree text = ctx.getChild(0);

        nodeStackEnd.add(new Node(nodeCount+1));
        nodeCount++;

        buildEdge(text);

        nodeStackStart.pop();
        nodeStackStart.add(nodeStackEnd.pop());

        visit(ctx.getChild(2));

        return "";
    }

    // GC [] GC
    @Override public String visitGCOnCondition(GCLParser.GCOnConditionContext ctx) {
        Node startNode = nodeStackStart.peek();

        visit(ctx.getChild(0));
        nodeStackStart.pop();
        nodeStackStart.add(startNode);
        visit(ctx.getChild(2));


        return "";
    }

    @Override
    public String visitCIf(GCLParser.CIfContext ctx) {
        visitChildren(ctx);
        return "";
    }

    @Override public String visitCDo(GCLParser.CDoContext ctx) {
        //ParseTree b = done(ctx.getChild(1));


        Node returner = nodeStackStart.peek();
        //nodeStackStart.add(returner);
        //nodeStackEnd.add(returner);
        nodeStackEnd.add(returner);

        visit(ctx.getChild(1));
        nodeStackEnd.pop();
        nodeStackStart.pop();
        nodeStackStart.add(returner);

        buildEdge(ctx.getChild(1),true);

        nodeCount++;
        return "";
    }




}