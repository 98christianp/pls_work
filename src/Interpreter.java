import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Interpreter extends GCLBaseVisitor<Object> {

    private Stack<Node> nodeStackStart = new Stack<Node>();
    private Stack<Node> nodeStackEnd = new Stack<Node>();
    private ArrayList<Edge> edgeList = new ArrayList<Edge>();
    private int nodeCount = 0;

    //https://stackoverflow.com/questions/4427584/is-there-a-dictionary-which-accepts-values-of-various-data-types
    private Map<String, Object> mem = new HashMap<String, Object>();

    private void buildEdge(String text){
        Node n1,n2;
        n2 = nodeStackEnd.peek();
        n1 = nodeStackStart.peek();
        Edge e1 = new Edge(n1,text,n2);
        edgeList.add(e1);

    }

    @Override
    public String toString(){
        System.out.println("MEMORY OUT:");
        for (Map.Entry<String, Object> entry : mem.entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        return "";
    }

    @Override
    public Object visitStart(GCLParser.StartContext ctx) {
        //nodeStackStart.add(new Node(0));
        nodeStackStart.add(new Node(0));
        nodeStackEnd.add(new Node(-1));

        visitChildren(ctx);
        //this.visit(ctx.exprC());

        return "";
    }

    @Override public Object visitBoolDouble(GCLParser.BoolDoubleContext ctx) {
        switch(ctx.getChild(1).getText()){
            case "&":
                return ((boolean)visit(ctx.getChild(0)))&((boolean)visit(ctx.getChild(2)));
            case "&&":
                return ((boolean)visit(ctx.getChild(0)))&&((boolean)visit(ctx.getChild(2)));
            case "|":
                return ((boolean)visit(ctx.getChild(0)))|((boolean)visit(ctx.getChild(2)));
            case "||":
                return ((boolean)visit(ctx.getChild(0)))||((boolean)visit(ctx.getChild(2)));

        }
        return null;
    }


    @Override public Object visitBoolCompare(GCLParser.BoolCompareContext ctx) {
        switch(ctx.getChild(1).getText()){
            case ">":
                return ((int)visit(ctx.getChild(0)))>((int)visit(ctx.getChild(2)));
            case ">=":
                return ((int)visit(ctx.getChild(0)))>=((int)visit(ctx.getChild(2)));
            case "<":
                return ((int)visit(ctx.getChild(0)))<((int)visit(ctx.getChild(2)));
            case "<=":
                return ((int)visit(ctx.getChild(0)))<=((int)visit(ctx.getChild(2)));

        }
        return null;
    }


    @Override public Object visitTrue(GCLParser.TrueContext ctx) {

        return true;
    }


    @Override public Object visitBoolNot(GCLParser.BoolNotContext ctx) {

        return ! (boolean) visit(ctx.getChild(1));
    }


    @Override public Object visitFalse(GCLParser.FalseContext ctx) {

        return false;
    }


    @Override public Object visitBoolBracket(GCLParser.BoolBracketContext ctx) {

        return visit(ctx.getChild(1));
    }


    @Override public Object visitAritVar(GCLParser.AritVarContext ctx) {
        return mem.get(ctx.getText());
    }


    @Override public Object visitAritDouble(GCLParser.AritDoubleContext ctx) {
        switch(ctx.getChild(1).getText()){
            case "+":
                return ((int)visit(ctx.getChild(0)))+((int)visit(ctx.getChild(2)));
            case "*":
                return ((int)visit(ctx.getChild(0)))*((int)visit(ctx.getChild(2)));
            case "-":
                return ((int)visit(ctx.getChild(0)))-((int)visit(ctx.getChild(2)));

        }

        return null;
    }


    @Override public Object visitAritParentheses(GCLParser.AritParenthesesContext ctx) {

        return visit(ctx.getChild(1));
    }


    //TODO: assot???? just 2 then one?
    @Override public Object visitAritPower(GCLParser.AritPowerContext ctx) {
        int a = (int) visit(ctx.getChild(0));
        int b = (int) visit(ctx.getChild(2));
        return a^b;
    }


    @Override public Object visitAritDig(GCLParser.AritDigContext ctx) {

        return Integer.valueOf(ctx.getText());
    }




    @Override public Object visitAritNeg(GCLParser.AritNegContext ctx) {

        return - (int) visit(ctx.getChild(1));
    }

    @Override
    public Object visitCAssign(GCLParser.CAssignContext ctx) {
        this.mem.put(ctx.getChild(0).getText(),visit(ctx.getChild(2)));

        return null;
    }

    @Override
    public Object visitCSkip(GCLParser.CSkipContext ctx) {
        return null;
    }

    @Override
    public Object visitCSep(GCLParser.CSepContext ctx) {
        visitChildren(ctx);
        

        return null;
    }

    // b -> G
    @Override public Object visitGCOnCondtion(GCLParser.GCOnCondtionContext ctx) {
        boolean b = (boolean) visit(ctx.getChild(0));
        if(b){
            visit(ctx.getChild(2));
        }
        return b;
    }

    // GC [] GC
    @Override 
    public Object visitGCOnCondition(GCLParser.GCOnConditionContext ctx) {
        // Deterministic

        boolean a,b;
        // Too izi?
        a = (boolean) visit(ctx.getChild(0));
        if(!a){
            b = (boolean) visit(ctx.getChild(2));
            return b;
        }




        return true;
    }

    @Override
    public Object visitCIf(GCLParser.CIfContext ctx) {
        visitChildren(ctx);
        return "";
    }

    @Override public Object visitCDo(GCLParser.CDoContext ctx) {
        boolean b = true;
        while(b){
            b = (boolean) visit(ctx.getChild(1));
        }

        return null;
    }

}