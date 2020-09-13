public class Merge2BinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;

        t1.data = t1.data + t2.data;
        if(t1.left != null || t2.left != null || t1.right != null || t2.right != null){
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        }

        return t1;
    }
}