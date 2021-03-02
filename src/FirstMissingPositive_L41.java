public class FirstMissingPositive_L41 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{2,1}));
    }
    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;

        int MAX_NUM = nums.length;

        boolean onePresent = false;

        for(int i=0;i<MAX_NUM; i++){
            if(nums[i] == 1){
                onePresent = true;
                break;
            }
        }

        if(!onePresent) return 1;

        if (MAX_NUM == 1)
            return 2;

        for(int i=0;i<MAX_NUM; i++){
            if(nums[i] <= 0 || nums[i] >MAX_NUM ){
                nums[i] = 1;
            }
        }

        for(int i=0;i<MAX_NUM; i++){
            int a = Math.abs(nums[i]);

            if (a == MAX_NUM)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }

        for(int i=1;i<MAX_NUM; i++){
            if(nums[i] > 0){
                return i;
            }
        }

        if(nums[0] > 0){
            return MAX_NUM;
        }
        return MAX_NUM+1;
    }
}

/**
 * 41. First Missing Positive
 * Hard
 *
 * 5266
 *
 * 943
 *
 * Add to List
 *
 * Share
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 300
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space?
 */
