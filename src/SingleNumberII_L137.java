public class SingleNumberII_L137 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }
    // HashMap is direct solution but request as no memory usage
    public static int singleNumber(int[] nums) {
        if(nums == null || nums.length%3 == 1){
            return -1;
        }


        int seenOnce = 0;
        int seenTwice = 0;

        for(int i=0; i< nums.length; i++){
            seenOnce = ~seenTwice & (seenOnce ^ nums[i]);
            seenTwice = ~seenOnce & (seenTwice ^ nums[i]);
        }
        return seenOnce;
    }

}

/**
 * 137. Single Number II
 * Medium
 *
 * 2352
 *
 * 396
 *
 * Add to List
 *
 * Share
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which appears once.
 *
 *
 * Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */