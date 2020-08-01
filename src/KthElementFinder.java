public class KthElementFinder {
    public static int item;
    public static void main(String[] args) {
        LinkedListN linkedList = createLinkedList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        findKthElementFromLast(linkedList.head, -3);
        System.out.println(item);
    }

    private static int findKthElementFromLast(Node1 node, int findPos) {
        if(node.next == null){
            return 0;
        }else{
            int currpos = findKthElementFromLast(node.next, findPos) - 1;
            if(currpos == findPos){
                item = node.data;
            }
            return currpos;
        }
        
    }

    public static LinkedListN createLinkedList(int... values) {
        LinkedListN linkedList = new LinkedListN();
        Node1 prev = null;
        for(int val : values){
            Node1 n = new Node1(val);
            if(linkedList.head == null){
                linkedList.head = n;
            }
            if(prev != null){
                prev.next = n;
            }
            prev = n;
        }
        return linkedList;
    }

}

class LinkedListN { 
    Node1 head; // head of list 
  
    /* Linked list Node*/

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node1 t =  head;
        while(t != null){
            sb.append(t.data + " ");
            t = t.next; 
        }
        return sb.toString();
    }

}


class Node1 { 
    int data; 
    Node1 next; 

    // Constructor to create a new node 
    // Next is by default initialized 
    // as null 
    Node1(int d) { data = d; } 
} 