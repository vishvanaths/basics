public class BinarySearchSample_LES {
    //First
    public int search(int[] nums, int target) {
        return findIndex(nums, 0, nums.length -1, target);
    }

    public int findIndex(int[] nums, int start, int end, int target){
        if(start > end) return -1;
        int mid = start + (end - start)/2;

        if(nums[mid] == target) return mid;

        if(nums[mid] > target) return findIndex(nums, start, mid-1, target);
        else
            return findIndex(nums, mid+1, end, target);
    }

    //Second
    public int firstBadVersion(int n) {
        int start=0;
        int end=n;

        while(start < end){
            int mid = start + (end -start)/2;

            if(isBadVersion(mid)) end = mid;
            else start = mid+1;
        }

        return start;
    }

    private boolean isBadVersion(int mid) {
        return false;//sample method
    }

    //Third - Here insert position can be 0 or beyond last place so while has equal to start as <= end
    public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length -1;

        while(start <= end){
            int mid = start + (end -start)/2;

            if(nums[mid] == target) return mid;
            if(nums[mid] > target) end = mid -1;
            else start = mid+1;
        }

        return start;
    }
}

/**
 * First
 * 704. Binary Search
 * Easy
 *
 * 4387
 *
 * 103
 *
 * Add to List
 *
 * Share
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */

/**
* Second
 * 278. First Bad Version
 * Easy
 *
 * 4540
 *
 * 1716
 *
 * Add to List
 *
 * Share
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 *
 * Input: n = 1, bad = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= bad <= n <= 231 - 1
 */

/**
 * Third
 * 35. Search Insert Position
 * Easy
 *
 * 7301
 *
 * 394
 *
 * Add to List
 *
 * Share
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */