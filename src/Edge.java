import org.antlr.v4.runtime.tree.ParseTree;

public class Edge {
    Node fromNode;
    Node toNode;
    boolean runDone;

    public ParseTree getEdge() {
        return edge;
    }

    ParseTree edge;

    public Edge(Node from, ParseTree edge, Node to){
        this.fromNode = from;
        this.toNode = to;
        this.edge = edge;
        this.runDone = false;
    }
    public Edge(Node from, ParseTree edge, Node to,boolean runDone){
        this.fromNode = from;
        this.toNode = to;
        this.edge = edge;
        this.runDone = true;
    }
    private String done(ParseTree ctx){

        if (ctx instanceof GCLParser.GCOnCondtionContext){

            return  "(!("+ctx.getChild(0).getText()+"))";
        }
        //System.out.println(ctx+" || "+ (ctx instanceof GCLParser.BIdentifyContext));
        // TODO: Check other class or naaaaah?
        return done(ctx.getChild(0)) + "&&" +done(ctx.getChild(2));
    }

    @Override
    public String toString(){
        return this.fromNode + "->" + this.toNode + "[label = " + (this.runDone?done(this.edge):this.edge.getText()) + "];";
    }
}