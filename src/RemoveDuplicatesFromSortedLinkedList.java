public class RemoveDuplicatesFromSortedLinkedList {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        ListNode prev = null;

        while(node!=null) {
            if(node.next != null && node.val == node.next.val){
                int val = node.val;

                while(node != null && val == node.val){
                    node = node.next;
                }
                if(prev == null){
                    head = node;
                }else{
                    prev.next = node;
                }
            }else{
                prev = node;
                node = node.next;
            }
        }
        return head;
    }
}


/***
 *82. Remove Duplicates from Sorted List II
 * Medium
 *
 * 2001
 *
 * 112
 *
 * Add to List
 *
 * Share
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Return the linked list sorted as well.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 */