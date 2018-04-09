import java.util.ArrayList;

public class StackConf<T> {

    ArrayList<T> mainStack = new ArrayList<T>();
    private int size = 0;



    public void push(T e){
        mainStack.add(e);
        this.size ++;
    }
    public T peek(){
        if(size == 0) return null;
        T out = mainStack.get(size-1);
        return out;
    }
    public T pop(){
        if(size == 0) return null;
        T out = mainStack.get(size-1);
        mainStack.remove(size-1);
        this.size--;
        return out;
    }

}
