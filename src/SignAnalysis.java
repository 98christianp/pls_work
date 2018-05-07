import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class SignAnalysis extends GCLBaseVisitor<Object> {
    Node lastNode;
    private boolean debug = false;
    private boolean running = true;
    private ArrayList<Edge> edgeList;


    private Map<String, String> currentAbstractMem = new HashMap<>();

    private String pElements[] = {"+"};
    Set<String> setP = new HashSet<>(Arrays.asList(pElements));
    private String pmElements[] = {"+","-"};
    Set<String> setPM = new HashSet<>(Arrays.asList(pmElements));
    private String pmzElements[] = {"+","-","+"};
    Set<String> setPMZ = new HashSet<>(Arrays.asList(pmzElements));
    

    private final String[][][] assignPower;



    private Map<Node,Set<Map<String, String>>> mem = new HashMap<>();
    
    private SignAnalysis(ArrayList<Edge> edgeList){
        this.edgeList = edgeList;
        /*

          + 0 - x1
        -
        0
        +
        x2
        */
        this.assignPower = new String[][][]{{new String[] {"+"}, new String[] {"0"},new String[] {"u"}},
                                            {new String[] {"1"}, new String[] {"1"},new String[] {"1"}},
                                            {new String[] {"+"}, new String[] {"0"},new String[] {"+","-"}}};


    }

    public void setDebug(boolean debug){
        this.debug = debug;
    }

    // Chaotic
    private void start(){
        Set<Map<String, String>> EmptySet;

        // for all q -> A(q):={}
        for(Edge e : edgeList){
            EmptySet = new HashSet<>();
            this.mem.putIfAbsent(e.fromNode,EmptySet);
        }


        Edge e = edgeList.get(0);

        // Set starting memory
        Set<Map<String, String>> StartMemSet = new HashSet<>();
        StartMemSet.add(currentAbstractMem);
        this.mem.put(e.fromNode,StartMemSet);
        boolean chaoticRun = true;
        while(chaoticRun){
            for(Edge edge : edgeList){
                for(Map<String, String> abstractMem : this.mem.get(edge.fromNode)){
                    this.currentAbstractMem = abstractMem;
                    visit(edge.edge);
                }

            }
        }
        this.lastNode = visitEdge(e,0);


    }


    public String toString(){
        System.out.print(lastNode.getPosition() == -1?"Terminated ":"Stuck ");
        String s = "";
        for(Map.Entry<Node,Set<Map<String, String>>> allAbstractMem : this.mem.entrySet()){
            System.out.println(allAbstractMem.getKey());
            for(Map<String,String> abstractMem : allAbstractMem.getValue()){
                for (Map.Entry<String, String> entry : abstractMem.entrySet())
                {
                    System.out.println(entry.getKey() + " " + entry.getValue() + " ");
                }
            }

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

                // TODO Remove b?
                if (!b) {
                    // TODO: mem2-> mem1, mem2
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
                return currentNode;
            }
        return currentNode;
        }


    private String getSign(int x){
        return x>0?"+":x<0?"-":"0";
    }


    private Set<String> getSignsAsSet(String x1,String x2, String[][][] table){
        Set<String> rSet = new HashSet<>();
        
        if(x1.equals("u") || x2.equals("u")){
            rSet.add("u");
        }
        else {
            int x1i = x1.equals("-")?0:x1.equals("0")?1:2;
            int x2i = x2.equals("-")?0:x2.equals("0")?1:2;
            rSet.addAll(Arrays.asList(table[x1i][x2i]));
        }
        return rSet;
    }

    @Override
    public Object visitStart(GCLParser.StartContext ctx) {

        return null;
    }
    /*
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
    */

    @Override public Object visitAritVar(GCLParser.AritVarContext ctx) {

        // TODO: what if abscent? mem.putIfAbsent(ctx.getText(),)

        return currentAbstractMem.get(ctx.getText());
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

            return (int)visit(ctx.getChild(2))/(int)visit(ctx.getChild(2));
        }

        this.running = false;

        return null;
    }

    @Override
    public Object visitCAssign(GCLParser.CAssignContext ctx) {


        if (visit(ctx.getChild(2))!=null)this.currentAbstractMem.put(ctx.getChild(0).getText(),getSign((int) visit(ctx.getChild(2))));

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

