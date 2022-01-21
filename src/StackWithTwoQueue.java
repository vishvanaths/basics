import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueue {
    static int size = 0;
    Queue<Integer> q1 =  new LinkedList<>();
    Queue<Integer> q2 =  new LinkedList<>();

    public static void main(String[] args) {
        StackWithTwoQueue s = new StackWithTwoQueue();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + s.size());
    }

    private int size() {
        return StackWithTwoQueue.size;
    }

    public void push(int i){
        size++;
        q2.add(i);

        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public int pop(){
       if(q1.isEmpty()) q1.peek();
       size--;
       return q1.remove();
    }

    public int top(){
        return q1.peek();
    }
}
