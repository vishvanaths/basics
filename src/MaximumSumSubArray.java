public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5};
        System.out.println(myAtoi("4193 with words"));
    }
    public static int myAtoi(String s) {
        s = s.trim();
        boolean negative = (s.charAt(0) == '-' );

        s = negative ? s.substring(1) : s;

        int i=0;
        for(char c : s.toCharArray()){
            if(c > '9' || c < '0'){
                break;
            }
            i++;
        }
        s = s.substring(0, i);
        int j=s.length()-1;
        int value = 0;
        for(i=0; i<s.length(); i++){
            value += (Math.pow(10, j--) * (s.charAt(i) - '0'));
        }

        return value;
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int currSum = 0;
        int result = Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while(j<nums.length){
            if(currSum + nums[j] == target){
                result = Math.min(result, (j-i));
                currSum -= nums[i];
                i++;

            }else if(currSum + nums[j] < target){
                currSum += nums[j];
                j++;
            }else if(currSum + nums[j] > target){
                currSum = currSum - nums[i];
                i++;
            }
        }

        return result;
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
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     *
     * A subarray is a contiguous part of an array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Example 2:
     *
     * Input: nums = [1]
     * Output: 1
     * Example 3:
     *
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     *
     *
     * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     */
}
