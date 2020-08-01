public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedListN linkedList = KthElementFinder.createLinkedList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(linkedList);
        revesreLinkedList(linkedList);
        System.out.println("Revesred : " + linkedList);
        linkedList.head = reverse(linkedList.head);
        System.out.println("Revesred 2 : " + linkedList);
    }

    static Node1 reverse(Node1 node) { 
        if(node == null) { 
            return node; 
        } 
  
        // last node or only one node 
        if(node.next == null) { 
            return node; 
        } 
  
        Node1 newHeadNode = reverse(node.next); 
  
        // change references for middle chain 
        node.next.next = node; 
        node.next = null; 
  
        // send back new head node in every recursion 
        return newHeadNode; 
    } 
  
    private static void revesreLinkedList(LinkedListN listN) {
        Node1 prev = null;
        Node1 temp = null;
        Node1 curr = listN.head;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        listN.head = prev;
    }
}
