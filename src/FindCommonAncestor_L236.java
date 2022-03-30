import java.util.*;

public class FindCommonAncestor_L236 {

    /**
     * High memory case
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();

        Map<TreeNode, TreeNode> parentChildMap = new HashMap<>();

        parentChildMap.put(root, null);
        stack.push(root);

        while(!parentChildMap.containsKey(p) || !parentChildMap.containsKey(q)){
            TreeNode node = stack.pop();

            if(node.left != null){
                stack.push(node.left);
                parentChildMap.put(node.left, node);
            }

            if(node.right != null){
                stack.push(node.right);
                parentChildMap.put(node.right, node);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while(p != null){
            ancestors.add(p);
            p = parentChildMap.get(p);
        }

        while(!ancestors.contains(q)){
            q = parentChildMap.get(q);
        }

        return q;
    }

    /** fastet solution without extra space **/
    TreeNode answer;
    public TreeNode lowestCommonAncestorFast(TreeNode root, TreeNode p, TreeNode q) {
        traverseTree(root, p, q);
        return answer;
    }

    public boolean traverseTree(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;

        int left = traverseTree(node.left, p, q) ? 1:0;

        int right = traverseTree(node.right, p, q) ? 1:0;

        int mid = (node == p || node == q) ? 1 : 0;

        if(mid + left + right >= 2) this.answer = node;

        return (mid + left + right > 0);

    }
}

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * Medium
 *
 * 9147
 *
 * 267
 *
 * Add to List
 *
 * Share
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */