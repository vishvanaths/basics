import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FindModeInBST {
    public static void main(String[] args) {

    }
    Integer prev=null; int count=0; int max=0;
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();

        traverse(root, modes);
        int[] modeaArr = new int[modes.size()];
        for(int i=0; i<modes.size(); i++){
            modeaArr[i] = modes.get(i);
        }
        return modeaArr;
    }

    private void traverse(TreeNode node, List<Integer> modes) {
        if(node == null){
            return;
        }

        traverse(node.left, modes);
        if(prev != null){
            if(prev == node.val){
                count++;
            }else{
                count = 1;
            }
        }else{
            count = 1;
        }

        if(count > max){
            modes.clear();
            max = count;
            modes.add(node.val);
        }else if(count == max){
            modes.add(node.val);
        }
        prev=node.val;
        traverse(node.right, modes);
    }
}

/**
 * 501. Find Mode in Binary Search Tree
 * Easy
 *
 * 1215
 *
 * 399
 *
 * Add to List
 *
 * Share
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
