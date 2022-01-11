public class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(0);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(9);
        doublyLinkedList.add(8);
        doublyLinkedList.add(7);
        System.out.println(doublyLinkedList);
        doublyLinkedList.delete(0);
        System.out.println(doublyLinkedList);
    }
}

class DoublyLinkedList{
    DNode head, tail;

    public void add(int data){
        DNode dn = new DNode(data);

        if(head == null){
            head = tail = dn;
        }else{
            tail.next = dn;
            dn.previous = tail;
            tail = dn;
        }
    }

    public void delete(int data){
        DNode dn = head;

        if(head == null){
            return;
        }
        
        while(dn != null){
            if(dn.data == data){
                if(dn == head){
                    head = dn.next;
                    dn.next.previous = null;
                }else if(dn == tail){
                    tail = dn.previous;
                    dn.previous.next = null;
                }else{
                    dn.next.previous = dn.previous;
                    dn.previous.next = dn.next;
                }
            }
            dn = dn.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DNode dn = head;
        while(dn != null){
            sb.append(dn.data + " ");
            dn =  dn.next;
        }
        return sb.toString();
    }
}

class  DNode{
    int data;
    DNode next, previous;

    public DNode(int data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
