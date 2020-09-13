import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    public static void main(final String[] args) {
        final BinaryTree bt = new BinaryTree();
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

        String s = serialize(bt.root);
        System.out.println(s);
        System.out.println(deserialize(s));

    }

    // Encodes a tree to a single string.
    public static String serialize(final TreeNode root) {
        final StringBuilder sb = new StringBuilder();

        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            final TreeNode tr = queue.remove();
            if (tr != null) {
                queue.add(tr.left);
                queue.add(tr.right);
            }
            sb.append(tr == null ? "null" : tr.data).append(",");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(final String data) {
        final String[] strs = data.split(",");

        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));// null check needed
        queue.add(root);
        for (int i = 1; i < strs.length; i += 2) {
            TreeNode curr = queue.remove();
            String left = strs[i];
            String right = strs[i + 1];
            if (!left.equals("null")) {
                TreeNode leftN = new TreeNode(Integer.parseInt(left));
                curr.left = leftN;
                queue.add(leftN);
            }
            if (!right.equals("null")) {
                TreeNode rightN = new TreeNode(Integer.parseInt(right));
                curr.right = rightN;
                queue.add(rightN);
            }
        }
        return root;
    }

//    public static TreeNode deserialize(final String data) {
//        final String[] strs = data.split(",");
//
//        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));// null check needed
//
//        for(int i=1; i<strs.length;i++){
//
//        }
//        return root;
//    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


}
