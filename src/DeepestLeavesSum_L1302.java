import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeepestLeavesSum_L1302 {
    public static void main(String[] args) {

    }

    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return -1;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int deepNodeSum = 0;

        while (!nodeQueue.isEmpty()){
            deepNodeSum = 0;
            int queue = nodeQueue.size();
            for(int i=0; i<queue; i++){
                TreeNode n = nodeQueue.poll();
                deepNodeSum += n.val;
                if(n.left != null) nodeQueue.offer(n.left);
                if(n.right != null) nodeQueue.offer(n.right);
            }
        }
        return deepNodeSum;
    }
}


/**
 * 1302. Deepest Leaves Sum
 * Medium
 *
 * 954
 *
 * 53
 *
 * Add to List
 *
 * Share
 * Given a binary tree, return the sum of values of its deepest leaves.
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
 */