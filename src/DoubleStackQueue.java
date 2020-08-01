import java.util.*;


public class DoubleStackQueue {
  public static void main(String[] args) {
    MyDoubleStackQueue<Integer> queue = new MyDoubleStackQueue<Integer>();
    
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    System.out.println(queue.dequeue());
    queue.enqueue(5);
    queue.enqueue(7);
    queue.enqueue(8);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    queue.enqueue(9);
    queue.enqueue(10);
    queue.enqueue(11);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());    
  }
}


class MyDoubleStackQueue<T>{
  private Stack<T> newItemStack;
  private Stack<T> oldItemStack;
  
  public MyDoubleStackQueue(){
      newItemStack = new Stack<T>();
      oldItemStack= new Stack<T>();
  }
  
  public void enqueue(T element){
    newItemStack.push(element);
  }
  
  public T peek(){
    shiftItems();
    return oldItemStack.peek();
  }
  
  public T dequeue(){
    shiftItems();
    return oldItemStack.pop();
  }
  
  private void shiftItems(){
    if(oldItemStack.isEmpty()){
      while(!newItemStack.isEmpty()){
        oldItemStack.push(newItemStack.pop());
      }
    }
  }
}