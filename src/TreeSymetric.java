import java.util.LinkedList;
import java.util.Queue;

public class TreeSymetric {
    public static void main(String[] args) {
        String data = "1,2,2,2,null,2,null";

        isSymmetric(SerializeDeserializeBinaryTree.deserialize(data));
    }

    public static boolean isSymmetric(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();
        boolean b = checkSymmetric(root, queue);
        System.out.println(b);
        return b;
    }

    private static boolean checkSymmetric(TreeNode root, Queue<Integer> queue) {
        if(root == null){
            return true;
        }
        addToQueue(root.left, queue);
        return removeFromQueue(root.right, queue) && queue.isEmpty();
    }

    private static boolean removeFromQueue(TreeNode node, Queue<Integer> queue) {
        if(node != null){
            boolean right = removeFromQueue(node.right, queue);
            boolean self = queue.remove() == node.val;
            boolean left = removeFromQueue(node.left, queue);
            
            return left && self && right;
        }else {
            return true;
        }
    }

    private static void addToQueue(TreeNode node, Queue<Integer> queue) {
        if(node != null){
            addToQueue(node.left, queue);
            queue.add(node.val);
            addToQueue(node.right, queue);
        }
    }
}
