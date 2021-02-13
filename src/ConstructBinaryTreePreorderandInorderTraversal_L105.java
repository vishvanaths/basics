public class ConstructBinaryTreePreorderandInorderTraversal_L105 {
    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7}, inorder = {9,3,15,20,7};
        System.out.println(buildTree(preorder, inorder));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0 || inorder.length == 0);

        return treeCreator(0, 0, inorder.length-1, preorder, inorder);
    }

    private static TreeNode treeCreator(int preOrderStart, int inOrderStart, int inOrderEnd, int[] preorder, int[] inorder) {
        if(inOrderStart > inOrderEnd || preOrderStart >= preorder.length){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preOrderStart]);
        int inIndex = 0;
        for(int i=inOrderStart; i<= inOrderEnd; i++){
            if(inorder[i] == node.val){
                inIndex = i;
                break;
            }
        }

        node.left = treeCreator(preOrderStart+1, inOrderStart, inIndex-1, preorder, inorder);
        node.right = treeCreator(preOrderStart+inIndex - inOrderStart + 1, inIndex+1, inOrderEnd, preorder, inorder);

        return node;
    }
}
