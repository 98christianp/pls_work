import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class SignAnalysis extends GCLBaseVisitor<Object> {
    Node lastNode;
    private boolean debug = false;
    private boolean running = true;
    private ArrayList<Edge> edgeList;


    private Map<String, String> currentAbstractMem = new HashMap<>();
    private Set<Map<String, String>> currentSemanticMem;
    private String pElements[] = {"+"};
    Set<String> setP = new HashSet<>(Arrays.asList(pElements));
    private String pmElements[] = {"+","-"};
    Set<String> setPM = new HashSet<>(Arrays.asList(pmElements));
    private String pmzElements[] = {"+","-","+"};
    Set<String> setPMZ = new HashSet<>(Arrays.asList(pmzElements));

    /*

          + 0 - x1
        +
        0
        -
        x2
        */

    // Number shit
    private final String[][][] assignPower =new String[][][]{{new String[] {"+"}, new String[] {"0"},new String[] {"+","-"}},
                                                            {new String[] {"1"}, new String[] {"1"},new String[] {"1"}},
                                                            {new String[] {"+","-"}, new String[] {"0"},new String[] {"u"}}};

    private final String[][][] assignPlus =new String[][][]{{new String[] {"+"}, new String[] {"+"},new String[] {"+","0","-"}},
                                                            {new String[] {"+"}, new String[] {"0"},new String[] {"-"}},
                                                            {new String[] {"+","0","-"}, new String[] {"-"},new String[] {"-"}}};

    private final String[][][] assignSub =new String[][][]{{new String[] {"+","0","-"}, new String[] {"-"},new String[] {"+"}},
                                                            {new String[] {"-"}, new String[] {"0"},new String[] {"-"}},
                                                            {new String[] {"+"}, new String[] {"+"},new String[] {"+","0","-"}}};

    private final String[][][] assignMul =new String[][][]{{new String[] {"+"}, new String[] {"0"},new String[] {"-"}},
                                                             {new String[] {"0"}, new String[] {"0"},new String[] {"0"}},
                                                             {new String[] {"-"}, new String[] {"0"},new String[] {"+"}}};

    // Booleans
    // >=
    private final String[][][] assignBE =new String[][][]{{new String[] {"tt","ff"}, new String[] {"ff"},new String[] {"ff"}},
                                                            {new String[] {"tt"}, new String[] {"tt"},new String[] {"ff"}},
                                                            {new String[] {"tt"}, new String[] {"tt"},new String[] {"ff","tt"}}};

    // >
    private final String[][][] assignB =new String[][][]{{new String[] {"tt","ff"}, new String[] {"ff"},new String[] {"ff"}},
                                                        {new String[] {"tt"}, new String[] {"ff"},new String[] {"ff"}},
                                                        {new String[] {"tt"}, new String[] {"tt"},new String[] {"ff","tt"}}};

    // <=
    private final String[][][] assignLE =new String[][][]{{new String[] {"tt","ff"}, new String[] {"tt"},new String[] {"tt"}},
                                                        {new String[] {"ff"}, new String[] {"tt"},new String[] {"tt"}},
                                                        {new String[] {"ff"}, new String[] {"ff"},new String[] {"ff","tt"}}};

    // <
    private final String[][][] assignL =new String[][][]{{new String[] {"tt","ff"}, new String[] {"tt"},new String[] {"tt"}},
                                                        {new String[] {"ff"}, new String[] {"ff"},new String[] {"tt"}},
                                                        {new String[] {"ff"}, new String[] {"ff"},new String[] {"ff","tt"}}};

    // =
    private final String[][][] assignE =new String[][][]{{new String[] {"tt","ff"}, new String[] {"ff"},new String[] {"ff"}},
                                                        {new String[] {"ff"}, new String[] {"tt"},new String[] {"ff"}},
                                                        {new String[] {"ff"}, new String[] {"ff"},new String[] {"ff","tt"}}};

    // =
    private final String[][][] assignNE =new String[][][]{{new String[] {"tt","ff"}, new String[] {"tt"},new String[] {"tt"}},
                                                            {new String[] {"tt"}, new String[] {"tt"},new String[] {"tt"}},
                                                            {new String[] {"tt"}, new String[] {"tt"},new String[] {"ff","tt"}}};



    private Map<Node,Set<Map<String, String>>> mem = new HashMap<>();
    
    public SignAnalysis(ArrayList<Edge> edgeList){
        this.edgeList = edgeList;



    }

    public void setDebug(boolean debug){
        this.debug = debug;
    }

    private boolean compareAbstracMems(Map<String, String> a1,Map<String, String> a2){
        return a1.equals(a2);
    }

    private Map<String, String> cloneMap(Map<String, String> map){
        Map<String, String> mapClone = new HashMap<>();
        for(Map.Entry<String,String> entry : map.entrySet()){
            mapClone.put(entry.getKey(),entry.getValue());
        }
        return mapClone;
    }

    // Chaotic
    public void start(){
        Set<Map<String, String>> EmptySet;

        // for all q -> A(q):={}
        for(Edge e : edgeList){
            EmptySet = new HashSet<>();
            this.mem.putIfAbsent(e.toNode,EmptySet);
        }


        Edge e = edgeList.get(0);
        currentAbstractMem.put("a","-");
        boolean found;

        // Set starting memory
        Set<Map<String, String>> StartMemSet = new HashSet<>();
        StartMemSet.add(currentAbstractMem);

        this.mem.putIfAbsent(e.fromNode,StartMemSet);


        boolean chaoticRun = true;
        while(chaoticRun){

            chaoticRun = false;

            for(Edge edge : edgeList){
                for(Map<String, String> abstractMem : this.mem.get(edge.fromNode)){
                    this.currentSemanticMem = new HashSet<>();
                    this.currentAbstractMem = cloneMap(abstractMem);


                    visit(edge.edge);

                    for(Map<String, String> abstractMem1 : this.currentSemanticMem){
                        found = false;
                        for(Map<String, String> abstractMem2 : this.mem.get(edge.toNode)){

                            if(compareAbstracMems(abstractMem1,abstractMem2)){

                                found = true;

                            }
                        }
                        if(!found){
                            this.mem.get(edge.toNode).add(abstractMem1);
                            chaoticRun = true;
                        }

                    }
                }
            }
        }
    }


    public String toString(){
        //System.out.print(lastNode.getPosition() == -1?"Terminated ":"Stuck ");
        String s = "";
        for(Map.Entry<Node,Set<Map<String, String>>> allAbstractMem : this.mem.entrySet()){
            System.out.println(allAbstractMem.getKey());
            System.out.println(allAbstractMem.getValue());
            /*
            for(Map<String,String> abstractMem : allAbstractMem.getValue()){
                for (Map.Entry<String, String> entry : abstractMem.entrySet())
                {
                    System.out.println(entry.getKey() + " " + entry.getValue() + " ");
                }
            }
            */

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

    private String getSign(int x){
        return x>0?"+":x<0?"-":"0";
    }


    private Set<String> getSignsAsSet(String x1,String x2, String[][][] table){
        Set<String> rSet = new HashSet<>();
        
        if(x1.equals("u") || x2.equals("u")){
            rSet.add("u");
        }
        else {
            int x1i = x1.equals("+")?0:x1.equals("0")?1:2;
            int x2i = x2.equals("+")?0:x2.equals("0")?1:2;
            rSet.addAll(Arrays.asList(table[x2i][x1i]));
        }
        return rSet;
    }

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
        Set<String> rSet = new HashSet<>();
        rSet.add(currentAbstractMem.get(ctx.getText()));
        return rSet;
    }


    @Override public Object visitAritDouble(GCLParser.AritDoubleContext ctx) {
        Set<String> rSet = new HashSet<>();

        switch(ctx.getChild(1).getText()){
            case "+":
                for(String a : (Set<String>) visit(ctx.getChild(0))){
                    for(String b : (Set<String>) visit(ctx.getChild(2))){
                        rSet.addAll(getSignsAsSet(a, b, this.assignPlus));
                    }
                }
                break;
            case "*":
                for(String a : (Set<String>) visit(ctx.getChild(0))){
                    for(String b : (Set<String>) visit(ctx.getChild(2))){
                        rSet.addAll(getSignsAsSet(a, b, this.assignMul));
                    }
                }
                break;
            case "-":
                for(String a : (Set<String>) visit(ctx.getChild(0))){
                    for(String b : (Set<String>) visit(ctx.getChild(2))){
                        rSet.addAll(getSignsAsSet(a, b, this.assignSub));
                    }
                }
                break;

        }
        return rSet;
    }


    @Override public Object visitAritParentheses(GCLParser.AritParenthesesContext ctx) {

        return visit(ctx.getChild(1));
    }



    @Override public Object visitAritPower(GCLParser.AritPowerContext ctx) {
        Set<String> rSet = new HashSet<>();
        for(String a : (Set<String>) visit(ctx.getChild(0))){
            for(String b : (Set<String>) visit(ctx.getChild(2))){

                rSet.addAll(getSignsAsSet(a, b, this.assignPower));
            }
        }
        return rSet;
    }


    @Override public Object visitAritDig(GCLParser.AritDigContext ctx) {
        Set<String> digSet = new HashSet<>();
        digSet.add(getSign(Integer.valueOf(ctx.getText())));
        return digSet;
    }




    @Override public Object visitAritNeg(GCLParser.AritNegContext ctx) {
        Set<String> rSet = new HashSet<>();
        String out;
        for(String a : (Set<String>) visit(ctx.getChild(1))){

            switch (a){
                case "-":
                    out = "+";
                    break;
                case "+":
                    out = "-";
                    break;
                default:
                    out = a;
                    break;
            }
            rSet.add(out);
        }
        return rSet;
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

        Map<String, String> refAbstractMem;
        boolean found;
        if (visit(ctx.getChild(2))!=null){
            for(String sign : (Set<String>)visit(ctx.getChild(2))){


                refAbstractMem = cloneMap(this.currentAbstractMem);
                refAbstractMem.put(ctx.getChild(0).getText(),sign);
                found = false;
                for(Map<String, String> a : this.currentSemanticMem){


                    if(compareAbstracMems(a,refAbstractMem)){
                        found = true;
                    }
                }
                if(!found){

                    this.currentSemanticMem.add(refAbstractMem);

                }
            }

        }

        return true;
    }

    @Override
    public Object visitCSkip(GCLParser.CSkipContext ctx) {
        this.currentSemanticMem.add(currentAbstractMem);
        return true;
    }

    @Override
    public Object visitCSep(GCLParser.CSepContext ctx) {

        return true;
    }

    // b -> G
    @Override public Object visitGCOnCondtion(GCLParser.GCOnCondtionContext ctx) {
        Set<String> b = (Set<String>) visit(ctx.getChild(0));

        if(b.contains("tt")){
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

