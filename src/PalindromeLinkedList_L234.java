public class PalindromeLinkedList_L234 {
    public static void main(String[] args) {
        ListNode head = MergeKSortedLists.createList(new int[]{1,2});
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode node = head;
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }

        int lastHalfStart = length%2 == 0 ? (length/2)+1 : (length/2)+2 ;
        ListNode lastHalf = head;
        while(lastHalfStart != 1){
            lastHalf = lastHalf.next;
            lastHalfStart--;
        }
        ListNode firstHalf = reverseFirst(head, length);

        while(firstHalf != null && lastHalf!= null){
            if(firstHalf.val != lastHalf.val){
                return false;
            }
            firstHalf = firstHalf.next;
            lastHalf = lastHalf.next;
        }
        return true;
    }

    private static ListNode reverseFirst(ListNode head, int length) {
        int endAt =length/2;
        ListNode curr = head;
        ListNode prev = null;

        while(endAt != 0){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            endAt--;
        }
        return prev;
    }
}
