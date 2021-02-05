import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodeReturnForest {
    public static void main(String[] args) {
        DeleteNodeReturnForest deleteNodeReturnForest = new DeleteNodeReturnForest();
        deleteNodeReturnForest.delNodes(null, null);
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> newForest = new ArrayList<>();
        
        Set<Integer> toDeleteSet = new HashSet<>();
        for(int value : to_delete){
            toDeleteSet.add(value);
        }
        
        removeNodes(root, toDeleteSet, newForest);
        if(!toDeleteSet.contains(root.data)){
            newForest.add(root);
        }
        return newForest;        
    }

    private TreeNode removeNodes(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> newForest) {
        if(node == null){
            return null;
        }

        node.left = removeNodes(node.left, toDeleteSet, newForest);
        node.right = removeNodes(node.right, toDeleteSet, newForest);

        if(toDeleteSet.contains(node.data)){
            if(node.left != null) newForest.add(node.left);
            if(node.right != null) newForest.add(node.right);
            return null;
        }

        return node;
    }
}


/**
 *
 * 1110. Delete Nodes And Return Forest
 * Medium
 *
 * 1425
 *
 * 48
 *
 * Add to List
 *
 * Share
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest.  You may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
 */