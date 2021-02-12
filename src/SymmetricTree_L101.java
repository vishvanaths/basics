public class SymmetricTree_L101 {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricSubTree(root, root);
    }

    private boolean isSymmetricSubTree(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;

        return (n1.val == n2.val)
                && isSymmetricSubTree(n1.left, n2.right)
                && isSymmetricSubTree(n1.right, n2.left);
    }
}
