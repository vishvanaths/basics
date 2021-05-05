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
