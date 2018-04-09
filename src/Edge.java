
public class Edge {
    Node fromNode;
    Node toNode;

    public String getEdge() {
        return edge;
    }

    String edge;

    public Edge(Node from,String edge,Node to){
        this.fromNode = from;
        this.toNode = to;
        this.edge = edge;
    }

    @Override
    public String toString(){
        return this.fromNode + "->" + this.toNode + "[label = " + this.edge + "];";
    }
}