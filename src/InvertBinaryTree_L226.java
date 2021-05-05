public class InvertBinaryTree_L226 {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode node) {
        if(node == null) return null;
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;
        invertTree(node.left);
        invertTree(node.right);
        return node;
    }
}

/**
 * 226. Invert Binary Tree
 * Easy
 *
 * 4776
 *
 * 71
 *
 * Add to List
 *
 * Share
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 */