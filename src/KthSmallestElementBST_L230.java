import java.util.Stack;

public class KthSmallestElementBST_L230 {
    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        int[] tracking = new int[]{0, -1};
        findWithInOrder(root, tracking, k);
        return tracking[1];
    }

    private void findWithInOrder(TreeNode node, int[] tracking, int k) {
        if(node == null){
            return;
        }
        findWithInOrder(node.left, tracking, k);
        tracking[0] += 1;
        if(tracking[0] == k){
            tracking[1] = node.val;
            return;
        }
        findWithInOrder(node.right, tracking, k);
    }

    //Better Solution
    public int kthSmallest_Iterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

}
/**
 * 230. Kth Smallest Element in a BST
 * Medium
 *
 * 3486
 *
 * 81
 *
 * Add to List
 *
 * Share
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */