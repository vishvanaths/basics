public class BinaryTreeMaximumPathSum {
    public static int MAXGAIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode tr = SerializeDeserializeBinaryTree.deserialize("-7,-2,-8");
        System.out.println(maxPathSum(tr));
    }
    public static int maxPathSum(TreeNode root) {
        calculateMaxGain(root) ;
        return MAXGAIN;
    }

    private static int calculateMaxGain(TreeNode node) {
        if(node == null){
            return 0;
        }

        int left_gain = Math.max(calculateMaxGain(node.left), 0);
        int right_gain = Math.max(calculateMaxGain(node.right), 0);
        int curr_gain = node.val + left_gain + right_gain;
        MAXGAIN = Math.max(MAXGAIN, curr_gain);
        return node.val + Math.max(left_gain, right_gain);

    }
}
