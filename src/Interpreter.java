import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Interpreter extends GCLBaseVisitor<Object> {
    Node lastNode;
    private boolean debug = false;
    private boolean running = true;
    private ArrayList<Edge> edgeList;

    private Map<String, Integer> mem = new HashMap<String, Integer>();

    private Interpreter(ArrayList<Edge> edgeList){
        this.edgeList = edgeList;
    }

    public void setDebug(boolean debug){
        this.debug = debug;
    }


    public String toString(){
        System.out.print(lastNode.getPosition() == -1?"Terminated ":"Stuck ");
        String s = "";
        for (Map.Entry<String, Integer> entry : mem.entrySet())
        {
            System.out.print(entry.getKey() + " " + entry.getValue() + " ");
        }

        return "";
    }

    private boolean runDone(ParseTree ctx){

        if (ctx instanceof GCLParser.GCOnCondtionContext){

            return  !(boolean)visit(ctx.getChild(0));
        }
        //System.out.println(ctx+" || "+ (ctx instanceof GCLParser.BIdentifyContext));

        return runDone(ctx.getChild(0)) && runDone(ctx.getChild(2));
    }


    private Node visitEdge(Edge e,int i){
        Node currentNode = e.fromNode;
        if (debug) System.out.println(e);

        Edge eNext = null;
        int nextI = i;

        boolean b;

        if (e.runDone) {
            b = runDone(e.edge);
        } else {
            b = (boolean) visit(e.edge);
        }


        if(this.running) {
            if (!b) {

                for (int j = i + 1; j < edgeList.size(); j++) {
                    if (edgeList.get(j).fromNode == currentNode) {
                        eNext = edgeList.get(j);
                        nextI = j;
                        break;
                    }

                }
            } else {
                for (int j = 0; j < edgeList.size(); j++) {
                    if (edgeList.get(j).fromNode == e.toNode) {
                        eNext = edgeList.get(j);
                        nextI = j;
                        break;
                    }

                }

            }

            if (eNext != null) {
                currentNode = visitEdge(eNext, nextI);
            } else {
                currentNode = e.toNode;
            }
        }
            return currentNode;
    }


    private Map<String, Integer> getMeThatSweetMemory(){

        // O(n)
        Edge e = edgeList.get(0);
        this.lastNode = visitEdge(e,0);

        return this.mem;
    };

    @Override
    public Object visitStart(GCLParser.StartContext ctx) {

        return null;
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
            case "=":
                return ((int)visit(ctx.getChild(0)))==((int)visit(ctx.getChild(2)));
            case "!=":
                return ((int)visit(ctx.getChild(0)))!=((int)visit(ctx.getChild(2)));
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

        mem.putIfAbsent(ctx.getText(),0); // Init with 0

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
    public Object visitAritDiv(GCLParser.AritDivContext ctx) {
        // TODO: The x+1 paradox?

        if(visit(ctx.getChild(2))!=null&&(int)visit(ctx.getChild(2))!=0){
            System.out.println("Stop"+(int)visit(ctx.getChild(2)));
            return (int)visit(ctx.getChild(2))/(int)visit(ctx.getChild(2));
        }

        this.running = false;

        return null;
    }

    @Override
    public Object visitCAssign(GCLParser.CAssignContext ctx) {

        // return null on 1/0?

        if (visit(ctx.getChild(2))!=null)this.mem.put(ctx.getChild(0).getText(),(int) visit(ctx.getChild(2)));

        return true;
    }

    @Override
    public Object visitCSkip(GCLParser.CSkipContext ctx) {
        return true;
    }

    @Override
    public Object visitCSep(GCLParser.CSepContext ctx) {

        return true;
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

