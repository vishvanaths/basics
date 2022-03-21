public class RemoveNthNodeFromList_L19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        ListNode node = removeNthFromEnd(head, null, n, new int[]{0});
        return node;
    }

    public ListNode removeNthFromEnd(ListNode node, ListNode prevNode, int n, int[] count){
        if(node == null){
            count[0] = 0;
            return node;
        }
        removeNthFromEnd(node.next, node, n, count);
        count[0] =  count[0]+ 1;
        if(count[0] == n){
            if(prevNode == null) return node.next;
            prevNode.next = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromList_L19 l19 = new RemoveNthNodeFromList_L19();
        System.out.println(l19.removeNthFromEnd(null, 5));
    }
}

/**
 * 19. Remove Nth Node From End of List
 * Medium
 *
 * 9233
 *
 * 437
 *
 * Add to List
 *
 * Share
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */