import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideViewList = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while(!nodeQueue.isEmpty()){
            for(int i=0;i<nodeQueue.size();i++){
                TreeNode node = nodeQueue.poll();
                if(i == 0)rightSideViewList.add(node.data);
                if(node.right != null) nodeQueue.offer(node.right);
                if(node.left != null) nodeQueue.offer(node.left);
            }
        }
        return rightSideViewList;
    }
}

/**
 * 199. Binary Tree Right Side View
 * Medium
 *
 * 2720
 *
 * 155
 *
 * Add to List
 *
 * Share
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
