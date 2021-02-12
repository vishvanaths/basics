public class SymmetricTree_L101 {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymetricSubTree(root, root);
    }

    private boolean isSymetricSubTree(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;

        return (n1.val == n2.val)
                && isSymetricSubTree(n1.left, n2.right)
                && isSymetricSubTree(n1.right, n2.left);
    }
}
