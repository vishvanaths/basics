public class InOrderSuccessorWithParentInfo_L510 {
    public TreeNode inorderSuccessor(TreeNode node) {
        if(node == null)
            return null;
        if(node.right != null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
        while(node.parent != null && node == node.parent.right){
            node = node.parent;
        }
        return node.parent;
    }

    public TreeNode inorderSuccessorWithoutParent(TreeNode root, int data) {
        if(root == null)
            return null;
        TreeNode current = findNode(root, data);
        if(current.right != null){
            current = current.right;
            while(current.left != null){
                current = current.left;
            }
            return current;
        }else{
            TreeNode ancestor = root;
            TreeNode successor = null;
            while(ancestor != current){
                if(current.val < ancestor.val){
                    successor = ancestor;
                    ancestor = ancestor.left;
                }else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }

    }

    private TreeNode findNode(TreeNode node, int data) {
        if(node == null) return node;
        if(node.val == data){
            return node;
        }
        if(node.val < data) return findNode(node.right, data);
        else return findNode(node.left, data);

    }
}

