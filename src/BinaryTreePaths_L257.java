import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_L257 {
    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null) return paths;

        String path = String.valueOf(root.val);
        if(root.left != null) dfs(root.left, path, paths); else paths.add(path);
        if(root.right != null) dfs(root.right, path, paths); else paths.add(path);

        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if(node.left != null) dfs(node.left, path + "=>" + node.val, paths); else paths.add(path);
        if(node.right != null) dfs(node.right, path+ "=>" + node.val, paths); else paths.add(path);
    }
}

/**
 * 257. Binary Tree Paths
 * Easy
 *
 * 2346
 *
 * 124
 *
 * Add to List
 *
 * Share
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */