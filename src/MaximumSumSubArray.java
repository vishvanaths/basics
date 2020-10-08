public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int MAX_SUM = Integer.MIN_VALUE;
        final int length = nums.length;
        if(nums == null || length == 0){
            return 0;
        }
        if(length == 1){
            return nums[0];
        }
        int dp[] = new int[length +1];
        dp[0] = 0;

        for(int i=1; i<=length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i-1], nums[i-1]);
            if(dp[i] > MAX_SUM){
                MAX_SUM = dp[i];
            }
        }

        return MAX_SUM;
    }
}
