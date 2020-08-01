import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicatesRemovalLinkList {
    public static Scanner sc = new Scanner(System.in); 
    public static void main(String[] args) {
        String a = "TIMULTOUS PASS WITH SIGNAGE";
        LinkedList<Character> linkedList = createLinkedList(a.toCharArray());
        System.out.println(linkedList);
        System.out.println("Which way you like cachedRemovale(1) or multiPonterRemoval(2)");
        int i = Integer.parseInt(sc.nextLine().trim());
        if( i == 1) {
            hashedDuplicateRemoval(linkedList);
        }else{
            multipointerDuplicateRemoval(linkedList);
        }

        System.out.println(linkedList);
    }

    private static void multipointerDuplicateRemoval(LinkedList<Character> linkedList) {
        Node<Character> current = linkedList.getHead();

        while( current != null){
            Node<Character> runner = current.getNext();
            Node<Character> prev = runner;
            while(runner != null){
                if(current.getData().equals(runner.getData())){
                    prev.setNext(runner.getNext());
                }else{
                    prev = runner;
                }
                runner = runner.getNext();
            }
            current = current.getNext();
           
        }
    }

    private static void hashedDuplicateRemoval(LinkedList<Character> linkedList) {
        Set<Character> uniqueCharacters = new HashSet<>();
        Node<Character> c = linkedList.getHead();
        Node<Character> prev = null;
        while(c != null){
            if(uniqueCharacters.contains(c.getData())){
                prev.setNext(c.getNext());
            }else{
                uniqueCharacters.add(c.getData());
                prev =  c;
            }
            c = c.getNext();
        }
    }

    private static LinkedList<Character> createLinkedList(char[] charArray) {
        LinkedList<Character> ls = new LinkedList<Character>();

        for(char c : charArray){
            ls.add(c);
        }
        return ls;
    }
}

class LinkedList<T>{
    Node<T> head = null;
    Node<T> tail = null;

    public Node<T> getHead() {
        return head;
    }
    public void add(T data){
        Node<T> n = new Node<T>(data);

        if(head == null) {
            head = tail = n;
        }else{
            tail.setNext(n);
            tail = n;
        }
    }

    public boolean remove(T data){
        if(head == null) return false;

        if(head.getData().equals(data)){
            head = head.getNext();
        }else{
            Node<T> n = head;

            while(n != null && n.getNext() != null){
                if(n.getNext().equals(data)){
                    n.setNext(n.getNext().getNext());
                    n.getNext();
                }else{
                    n = n.getNext();
                }
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb =  new StringBuilder();
        Node<T> n = head;
        while(n != null){
            sb.append(n.getData() + " -> ");
            n = n.getNext();
        }
        sb.append("↓ ");
        return sb.toString();
    }
}

class Node<T>{
    private T data;
    private Node<T> next;

    public Node(){
        this.data = null;
        this.next = null;
    }

    public Node(T data){
        this.data = data;
        this.next = null;
    }    
    
    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}