import java.util.Arrays;

public class The3SumClosest_L16 {
    public static void main(String[] args) {
       int[] nums = new int[]{1,1,-1,-1,}; int target = 0;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return -1;
        }

        Arrays.sort(nums);

        int closetsSum = nums[0] + nums[1] + nums[2];


        for(int i=0; i< nums.length; i++){
            int a_pointer = i+1;
            int b_pointer = nums.length - 1;
            while(a_pointer < b_pointer){
                int value = nums[a_pointer] + nums[i] + nums[b_pointer];
                if(value < target){
                    a_pointer++;
                }else{
                    b_pointer--;
                }
                if(Math.abs(value - target) < Math.abs(closetsSum - target)){
                    closetsSum = value;
                }
            }
        }
        return closetsSum;
    }

}

/**
 * 16. 3Sum Closest
 * Medium
 *
 * 2861
 *
 * 164
 *
 * Add to List
 *
 * Share
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */