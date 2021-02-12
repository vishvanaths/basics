import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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
        bt.insert(19, bt.root);
        bt.insert(28, bt.root);
        bt.insert(3, bt.root);
        bt.insert(15, bt.root);

        printInfoAboutTree(bt);

        bt.delete(22, bt.root);
        printInfoAboutTree(bt);
        
        // System.out.println("Inorder successor of 3 : " + findInOrderSuccessor(3, bt.root));
    }

    private static void printInfoAboutTree(BinaryTree bt) {
        System.out.println(bt);
        System.out.println("BFS " + bt.toBFSString());
        System.out.println("DFS " + bt.toDFSString());
        System.out.println("PreOrder " + bt.preOrder(bt.root));
        System.out.println("InOrder " + bt.inOrder(bt.root));
        System.out.println("PostOrder " + bt.postOrder(bt.root));
        System.out.println("2 is present in the tree? " + bt.search(2, bt.root));
        System.out.println("21 is present in tree? " + bt.search(21, bt.root));
        System.out.println("Min : " + findMin(bt.root));
        System.out.println("Max : " + findMax(bt.root));
        System.out.println("Height : " + findTreeHeight(bt.root));
    }

    private static Integer findMax(TreeNode root) {
        TreeNode t = null;
        while (root != null) {
            t = root;
            root = root.right;
        }
        return t != null ? t.val : null;
    }

    private static int findMin(TreeNode root) {
        TreeNode t = null;
        while (root != null) {
            t = root;
            root = root.left;
        }
        return t != null ? t.val : null;
    }

    private static int findTreeHeight(TreeNode node) {
        if (node == null) {
            return -1;
        } else {
            return Math.max(findTreeHeight(node.left), findTreeHeight(node.right)) + 1;
        }
    }

}

class BinaryTree {
    TreeNode root;

    public TreeNode insert(int data, TreeNode node) {
        if (node == null) {
            node = new TreeNode(data);
        } else if (data <= node.val) {
            node.left = insert(data, node.left);
        } else {
            node.right = insert(data, node.right);
        }
        return node;
    }

    public TreeNode delete(int data, TreeNode node) {
        return null;
    }

    public String preOrder(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if(node == null) return "";
        sb.append(node.val + " " + preOrder(node.left) + " " + preOrder(node.right));
        return sb.toString();
    }

    public String inOrder(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if(node == null) return "";
        sb.append(inOrder(node.left) + " " + node.val + " " + inOrder(node.right));
        return sb.toString();
    }

    public String postOrder(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if(node == null) return "";
        sb.append(postOrder(node.left) + " " + postOrder(node.right) + node.val + " ");
        return sb.toString();
    }

    public String toDFSString() {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> sc = new Stack<>();
        sc.add(this.root);
        while (!sc.isEmpty()) {
            TreeNode n = sc.pop();
            sb.append(n.val + "|");

            if (n.right != null)
                sc.push(n.right);
            if (n.left != null)
                sc.push(n.left);
        }
        return sb.toString();
    }

    public boolean search(int data, TreeNode node) {
        if (node == null) {
            return false;
        }
        if (data == node.val) {
            return true;
        } else {
            if (data < node.val) {
                return search(data, node.left);
            } else {
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
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(this.root);
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            sb.append(n.val + "|");
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
        return sb.toString();
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);
        if (this.left != null)
            sb.append("|" + this.left.toString());
        if (this.right != null)
            sb.append("|" + this.right.toString());
        return sb.toString();
    }
}