import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    final int capacity;
    int curr_size = 0;
    Map<Integer, DoubleNode> cache = new HashMap<>();
    DLinkedList dList = new DLinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            dList.moveToFront(cache.get(key));
            return cache.get(key).value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        DoubleNode n = new DoubleNode(key, value);
        if(curr_size < capacity){
            dList.addToHead(n);
            cache.put(key, n);
            curr_size++;
        }else{
            DoubleNode k = dList.removeLast();
            cache.remove(k.key);
            dList.addToHead(n);
            cache.put(key, n);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1);
//        lRUCache.put(2, 2);
        lRUCache.get(2);    // return 1
        lRUCache.put(3, 2); // evicts key 2
        lRUCache.get(2);    // returns -1 (not found)
//        lRUCache.put(4, 4); // evicts key 1
//        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
//        lRUCache.get(4);    // return 4
    }
}


class DLinkedList{
    DoubleNode head, tail;

    public void add(int key, int value){
        DoubleNode dn = new DoubleNode(key, value);

        add(dn);
    }

    private void add(DoubleNode dn) {
        if(head == null){
            head = tail = dn;
        }else{
            tail.next = dn;
            dn.previous = tail;
            tail = dn;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleNode dn = head;
        while(dn != null){
            sb.append("[" + dn.key + " :" + dn.value + "]" + " ");
            dn =  dn.next;
        }
        return sb.toString();
    }

    public DoubleNode removeLast() {
        DoubleNode key = null;
        if(tail != null){
            key = tail;
            tail = tail.previous;
//            tail.next = null;
        }
        return key;
    }

    public void addToHead(DoubleNode n) {
        if(head != null){
            n.next = head;
            head.previous = n;
            head = n;
            head.previous = null;
        }else{
            head = tail = n;
        }
    }

    public void moveToFront(DoubleNode n) {
        if(n != null){
            if(n.next != null){
                n.next.previous = n.previous;
            }else{
                tail = n.previous;
                //tail.next =  null;
            }
            if(n.previous != null){
                n.previous.next = n.next;
            }else{
                head = n.next;
                //head.previous = null;
            }
            addToHead(n);
        }
    }
}

class DoubleNode{
    int key;
    int value;
    DoubleNode next, previous;

    public DoubleNode(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.previous = null;
    }
}

/**
 * 146. LRU Cache
 * Medium
 *
 * 6525
 *
 * 276
 *
 * Add to List
 *
 * Share
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1);
 * lRUCache.put(2, 2);
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // evicts key 2
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // evicts key 1
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 * Constraints:
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * At most 3 * 104 calls will be made to get and put.
 */