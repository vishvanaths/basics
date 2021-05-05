public class IsBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left=new TreeNode(7);
        root.right=new TreeNode(14);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(9);

        System.out.println(isBST(root, null, null));
    }

    private static boolean isBST(TreeNode node, Integer lower, Integer upper) {
        if(node == null){
            return true;
        }

        if(lower != null && node.val <= lower) return false;
        if(upper != null && node.val >= upper) return false;

        return isBST(node.left, lower, node.val) && isBST(node.right, node.val, upper);
    }
}