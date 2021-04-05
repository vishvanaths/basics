import java.util.ArrayList;
import java.util.List;

public class Path_Sum2_L113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();

        if(root == null) return results;

        allPaths(root, targetSum, new ArrayList<>(), results);

        return results;
    }

    public void allPaths(TreeNode current, int soFar, List<Integer> currentPath, List<List<Integer>> results) {
        if(current == null) return;

        if(current.val == soFar && current.left == null && current.right == null){
            currentPath.add(current.val);
            results.add(currentPath);
            return;
        }
        currentPath.add(current.val);
        allPaths(current.left, soFar-current.val, new ArrayList<>(currentPath), results);
        allPaths(current.right, soFar-current.val, new ArrayList<>(currentPath), results);
    }
}

/**
 * 113. Path Sum II
 * Medium
 *
 * 2665
 *
 * 84
 *
 * Add to List
 *
 * Share
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */