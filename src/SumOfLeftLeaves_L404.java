public class SumOfLeftLeaves_L404 {
    public static void main(String[] args) {

    }

    public int sumOfLeftLeaves(TreeNode root) {
        return calculateLeftSum(root,false);
    }

    private int calculateLeftSum(TreeNode node, boolean left) {
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return left ? node.val : 0;
        }
        return calculateLeftSum(node.left, true) +
                calculateLeftSum(node.right, false);
    }
}
/**
 * 404. Sum of Left Leaves
 * Easy
 *
 * 1670
 *
 * 161
 *
 * Add to List
 *
 * Share
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */