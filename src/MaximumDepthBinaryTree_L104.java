public class MaximumDepthBinaryTree_L104 {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        int[] maxDepath = new int[1];
        findMaxDepth(root, maxDepath, 0);
        return maxDepath[0];
    }

    private void findMaxDepth(TreeNode node, int[] maxDepath, int currentDepth) {
        if(node == null) return;

        maxDepath[0] = Math.max(maxDepath[0], currentDepth);
        findMaxDepth(node.left, maxDepath, currentDepth+1);
        findMaxDepth(node.right, maxDepath, currentDepth+1);
    }
}
