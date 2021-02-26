import java.util.ArrayList;
import java.util.List;

public class CloneN_aryTree_L1490 {
    public N_ary_Node cloneTree(N_ary_Node root) {
        if(root == null) return root;
        N_ary_Node nTree = new N_ary_Node();
        nTree.val = root.val;

        if(root.children != null && root.children.size() > 0)
            for(N_ary_Node child : root.children){
                nTree.children.add(cloneTree(child));
            }
        return nTree;
    }
}

class N_ary_Node {
    public int val;
    public List<N_ary_Node> children;


    public N_ary_Node() {
        children = new ArrayList<N_ary_Node>();
    }

    public N_ary_Node(int _val) {
        val = _val;
        children = new ArrayList<N_ary_Node>();
    }

    public N_ary_Node(int _val,ArrayList<N_ary_Node> _children) {
        val = _val;
        children = _children;
    }
}
/**
 * 1490. Clone N-ary Tree
 * Medium
 *
 * 130
 *
 * 8
 *
 * Add to List
 *
 * Share
 * Given a root of an N-ary tree, return a deep copy (clone) of the tree.
 *
 * Each node in the n-ary tree contains a val (int) and a list (List[N_ary_N_ary_Node]) of its children.
 *
 * class N_ary_N_ary_Node {
 *     public int val;
 *     public List<N_ary_Node> children;
 * }
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 * Follow up: Can your solution work for the graph problem?
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,null,3,2,4,null,5,6]
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 *
 *
 * Constraints:
 *
 * The depth of the n-ary tree is less than or equal to 1000.
 * The total number of nodes is between [0, 10^4].
 */