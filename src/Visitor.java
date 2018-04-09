public class Visitor extends GCLBaseVisitor<Edge> {

    @Override
    public Edge visitStart(GCLParser.StartContext ctx) {
        return this.visit(ctx.b());
    }
    @Override
    public Edge visitBoolCompare(GCLParser.BoolCompareContext ctx) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        String text = ctx.getText();
        Edge e1 = new Edge(n1,text,n2);
        return (e1);
    }
    @Override
    public Edge visitTrue(GCLParser.TrueContext ctx) {
        return visitChildren(ctx);
    }


    

}