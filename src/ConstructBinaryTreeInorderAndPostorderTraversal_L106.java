import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInorderAndPostorderTraversal_L106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        int[] nodePosition = new int[]{postorder.length - 1};
        Map<Integer, Integer> idx_map = new HashMap<>();
        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
        return treeBuilder(inorder, postorder, 0, inorder.length - 1, nodePosition, idx_map);
    }

    private TreeNode treeBuilder(int[] inorder, int[] postorder, int inorderStart, int inOrderEnd, int[] nodePosition, Map<Integer, Integer> idx_map) {
        if (inorderStart > inOrderEnd) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[nodePosition[0]]);
        int boundary = idx_map.get(node.val);
        nodePosition[0]--;
        node.right = treeBuilder(inorder, postorder, boundary + 1, inOrderEnd, nodePosition, idx_map);
        node.left = treeBuilder(inorder, postorder, inorderStart, boundary - 1, nodePosition, idx_map);
        return node;
    }
}

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Medium
 * <p>
 * 2434
 * <p>
 * 45
 * <p>
 * Add to List
 * <p>
 * Share
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */