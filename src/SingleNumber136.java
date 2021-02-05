public class SingleNumber136 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,5,6,7,5,6,7,1,20};
        System.out.println(singleNumber(numbers));
    }

    public static int singleNumber(int[] numbers) {
        if(numbers == null || numbers.length == 0){
            throw new RuntimeException("Array Empty or null. Provide valid input");
        }else{
            int uniqueNumber = numbers[0];
            for(int i=1; i<numbers.length; i++){
                uniqueNumber ^= numbers[i];
            }
            return uniqueNumber;
        }
    }
}
/**
 * 136. Single Number
 * Easy
 *
 * 5662
 *
 * 187
 *
 * Add to List
 *
 * Share
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
