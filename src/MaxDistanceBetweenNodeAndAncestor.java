import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxDistanceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        Integer[] tree = {8,3,10,1,6,null,14,null,null,4,7,null,null,13,null};
        TreeNode des = SerializeDeserializeBinaryTree.deserialize(Arrays.stream(tree).map(operand -> operand + "").collect(Collectors.joining(",")));

        System.out.println(findMinMaxForTree(des));
    }

    private static int findMinMaxForTree(TreeNode node) {
        if(node == null){
            return 0;
        }

        return traverseAndFind(node, node.val, node.val);
    }

    private static int traverseAndFind(TreeNode node, int min, int max) {
        min = Math.min(node.val, min);
        max = Math.max(node.val, max);

        if(node.right == null && node.left == null){
            return Math.abs(max-min);
        }else if(node.left != null && node.right != null){
            return Math.max(traverseAndFind(node.left, min, max), traverseAndFind(node.right, min, max));
        }else{
            if(node.left != null){
                return traverseAndFind(node.left, min, max);
            }else{
                return traverseAndFind(node.right, min, max);
            }
        }
    }
}
