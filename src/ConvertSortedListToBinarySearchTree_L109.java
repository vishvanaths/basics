import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree_L109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        List<Integer> sortedList = new ArrayList<>();
        while(head != null){
            sortedList.add(head.val);
            head = head.next;
        }

        return constructTree(sortedList, 0, sortedList.size());
    }

    private TreeNode constructTree(List<Integer> sortedList, int start, int end) {
        if(start > end) return null;

        int mid = start + end /2;

        TreeNode node = new TreeNode(sortedList.get(mid));
        node.left = constructTree(sortedList, start, mid - 1);
        node.right = constructTree(sortedList,mid + 1, end);
        return node;
    }
}
