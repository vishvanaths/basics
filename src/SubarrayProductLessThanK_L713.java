public class SubarrayProductLessThanK_L713 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubArrayProductLessThanK(nums, k));
    }

    public static int numSubArrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }
        int start = 0, end = 0;
        int product = 1;
        while (end < nums.length) {
            product *= nums[end];
            if (product >= k) {
                product = product / nums[start++];
            }
            count += end - start + 1;
            end++;
        }

        return count;
    }
}

/**
 * 713. Subarray Product Less Than K
 * Medium
 *
 * 3713
 *
 * 128
 *
 * Add to List
 *
 * Share
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 * Accepted
 * 155,411
 * Submissions
 * 357,980
 */
