

import java.util.*;
public class Graph extends GCLBaseVisitor<void> {

    private Stack<Node> nodeStackStart;
    private Stack<Node> nodeStackEnd;
    private ArrayList<Edge> edgeList;
    private int nodeCount;

    @Override
    public String toString(){

        for(Edge e : this.edgeList){
            System.out.println(e);
        }


    }

    @Override
    public void visitStart(GCLParser.StartContext ctx) {
        nodeStackStart.add(new Node());
        nodeStackEnd.add(new Node(-1));
        System.out.println(ctx.getParent().getText());
        return this.visit(ctx.b());
    }

    @Override
    public void visitBoolCompare(GCLParser.BoolCompareContext ctx) {
        Node n1 = nodeStackStart.pop();
        nodeStackStart.push(new Node());
        String text = ctx.getText();
        if(ctx.hasChildren()){
            Node n2 = new Node();
        }
        else{
            Node n2 = nodeStackEnd.pop();
        }
        Edge e1 = new Edge(n1,text,n2);
        ArrayList.add(Edge);

        visitChildren();
    }

    @Override
    public void visitTrue(GCLParser.TrueContext ctx) {
        visitChildren(ctx);
    }




}
