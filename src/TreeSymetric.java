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
        addToStack(root.left, queue);
        return removeFromStack(root.right, queue) && queue.isEmpty();
    }

    private static boolean removeFromStack(TreeNode node, Queue<Integer> queue) {
        if(node != null){
            boolean right = removeFromStack(node.right, queue);
            boolean self = queue.remove() == node.val;
            boolean left =removeFromStack(node.left, queue);
            
            return left && self && right;
        }else {
            return true;
        }
    }

    private static void addToStack(TreeNode node, Queue<Integer> queue) {
        if(node != null){
            addToStack(node.left, queue);
            queue.add(node.val);
            addToStack(node.right, queue);
        }
    }
}
