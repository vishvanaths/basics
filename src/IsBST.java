public class IsBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left=new TreeNode(7);
        root.right=new TreeNode(14);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(9);

        System.out.println(isBST(root, null, null));
    }

    private static boolean isBST(TreeNode node, Integer min, Integer max) {
        if(node == null)
            return true;
        
        if((min != null && node.val <= min) || (max != null && max < node.val))
            return false;
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }
}