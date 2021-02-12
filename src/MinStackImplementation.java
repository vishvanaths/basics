public class MinStackImplementation {
    public static void main(String[] args) {
        MinStack<Integer> minStack = new MinStack<>();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Min : " + minStack.getMin()); // return -3
        minStack.pop();
        System.out.println("Top : " + minStack.top()); // return 0
        System.out.println("Min : " + minStack.getMin()); // return -2
        // System.out.println(minStack);
    }
    /**
     * Your MinStack object will be instantiated and called as such: MinStack obj =
     * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
     * = obj.getMin();
     */
}

class MinStack<T> {
    StackNode<T> top = null;

    /** initialize your val structure here. */
    public MinStack() {
        top = null;
    }

    public void push(T x) {
        StackNode<T> n = new StackNode<T>(x);
        if (top == null) {
            top = n;
        } else {
            n.setNext(top);
            top = n;
        }
    }

    public void pop() {
        top = top.getNext();
    }

    public T top() {
        return top.getData();
    }

    public T getMin() {
        StackNode<T> n = top;
        T min = top.getData();
        while (n != null) {
            // if (Comparator.comparing(min, n.getData()) <= 0) {
            //     min = n.getData();
            // }
            n = n.getNext();
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StackNode<T> n = top;
        while (n != null) {
            sb.append(n.getData() + " -> ");
            n = n.getNext();
        }
        sb.append("↓ ");
        return sb.toString();
    }
}

class StackNode<T> {
    private T data;
    private StackNode<T> next;

    public StackNode() {
        this.next = null;
        this.data = null;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public StackNode(T data) {
        this.data = data;
    }

    public StackNode(T data, StackNode<T> next) {
        this.next = next;
        this.data = data;
    }

}