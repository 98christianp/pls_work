public class Node {
    int position;
    public static int count = 0;

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public Node(){
        this.setPosition(count);
        ++this.count;
    }

    public Node(int p){
        this.position = p;
    }

    public String toString(){
        return ("q"+(this.position == 0?"▷":this.position == -1?"◀":String.valueOf(this.position)));
    }
}