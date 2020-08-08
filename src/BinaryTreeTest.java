public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = bt.insert(10, null);
        bt.insert(14, bt.root);
        bt.insert(9, bt.root);
        bt.insert(11, bt.root);
        bt.insert(2, bt.root);
        bt.insert(13, bt.root);
        bt.insert(22, bt.root);

        System.out.println(bt);
        System.out.println(bt.search(2, bt.root));
        System.out.println(bt.search(21, bt.root));
        System.out.println("Min : " + findMin(bt.root));
        System.out.println("Max : " + findMax(bt.root));
    }

    private static Integer findMax(TreeNode root) {
        TreeNode t = null;
        while(root != null){
            t = root;
            root =  root.right;
        }
        return t != null ? t.data : null;
    }

    private static int findMin(TreeNode root) {
        TreeNode t = null;
        while(root != null){
            t = root;
            root =  root.left;
        }
        return t != null ? t.data : null;
    }


}


class BinaryTree {
    TreeNode root;

    public TreeNode insert(int data, TreeNode node) {
        if (node == null) {
            node = new TreeNode(data);
        } else if (data <= node.data) {
            node.left = insert(data, node.left);
        } else {
            node.right = insert(data, node.right);
        }
        return node;
    }

    public boolean search(int data, TreeNode node) {
        if(node == null){
            return false;
        }
        if(data == node.data){
            return true;
        }
        else{
            if(data < node.data){
                return search(data, node.left);
            }else{
                return search(data, node.right);
            }
        }
        
    }

    @Override
    public String toString() {
        if (root != null) {
            return root.toString();
        }
        return null;
    }

    public String toBFSString() {
        if (root != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(root.data + "|");
            TreeNode n = root;
            while (n != null) {
                if (n.left != null)
                    sb.append(n.left.data + "|");
                if (n.right != null)
                    sb.append(n.right.data + "|");
                if (n.left != null)
                    n = n.left;
                else
                    n = n.right;
            }
            return sb.toString();
        }
        return null;
    }
}

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.data);
        if (this.left != null)
            sb.append("|" + this.left.toString());
        if (this.right != null)
            sb.append("|" + this.right.toString());
        return sb.toString();
    }
}