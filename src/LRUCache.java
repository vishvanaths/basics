import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    final int CAPACITY;
    Map<Integer, DNode_> cache = new HashMap<>();
    DoublyLinkedList_ doublyLinkedList_ = new DoublyLinkedList_();

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            doublyLinkedList_.moveToHead(cache.get(key));
            return cache.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            DNode_ dNode = cache.get(key);
            dNode.value = value;
            doublyLinkedList_.moveToHead(cache.get(key));
        }else{
            DNode_ dNode = new DNode_(key, value);
            if(cache.size() == CAPACITY){
                DNode_ dNodeLast = doublyLinkedList_.removeLast();
                cache.remove(dNodeLast.key);
            }
            doublyLinkedList_.addToHead(dNode);
            cache.put(key, dNode);

        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.put(3, 3); // cache is {1=1, 2=2}
        lRUCache.put(4, 4); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(4) + ",");    // return 1
        System.out.println(lRUCache.get(3) + ",");    // returns -1 (not found)
        System.out.println(lRUCache.get(2) + ",");    // return 1
        System.out.println(lRUCache.get(1) + ",");    // returns -1 (not found)
        lRUCache.put(5, 5); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1) + ",");    // return -1 (not found)
        System.out.println(lRUCache.get(2) + ",");    // return 3
        System.out.println(lRUCache.get(3) + ",");    // return 1
        System.out.println(lRUCache.get(4) + ",");    // return 1
        System.out.println(lRUCache.get(5) + ",");    // return 4
    }
}

class DoublyLinkedList_{
    DNode_ head, tail;

    public void addToHead(DNode_ dNode) {
        if(head == null){
            head = dNode;
            tail = dNode;
        }else{
            dNode.next = head;
            head.previous = dNode;
            head = dNode;
        }
    }

    public void moveToHead(DNode_ dNode_) {
        if(dNode_ != head){
            if(dNode_ == tail){
                tail = dNode_.previous;
                dNode_.next = null;
            }else{
                dNode_.next.previous = dNode_.previous;
                dNode_.previous.next = dNode_.next;
            }
            dNode_.next = head;
            head.previous = dNode_;
            head = dNode_;
        }
    }

    public DNode_ removeLast() {
        if(tail != null){
            DNode_ temp = tail;
            if(tail == head){
                tail = head = null;
            }else{
                tail = tail.previous;
                tail.next=null;
            }
            return temp;
        }

        return null;
    }
}

class DNode_{
    public int key;
    public int value;
    public DNode_ next;
    public DNode_ previous;

    public DNode_(int key, int value){
        this.key = key;
        this.value = value;
    }

    public DNode_(int value,DNode_ next, DNode_ previous){
        this.key = key;
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}