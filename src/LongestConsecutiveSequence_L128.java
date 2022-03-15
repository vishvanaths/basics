import java.util.HashSet;

public class LongestConsecutiveSequence_L128 {
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if(nums ==  null || nums.length == 0){
            return 0;
        }

        HashSet<Integer> numbers = new HashSet<>();
        for(int number : nums){
            numbers.add(number);
        }


        int maxSequence = 1;

        for(int i=0; i < nums.length; i++){
            int currentMaxSeq = 1;
            if(!numbers.contains(nums[i] - 1)){
                int currentNumber = nums[i];
                while(numbers.contains(currentNumber + 1)){
                    currentMaxSeq++;
                    currentNumber++;
                }
            }
            maxSequence = Math.max(maxSequence, currentMaxSeq);
        }
        return maxSequence;
    }
}

/**
 * 128. Longest Consecutive Sequence
 * Medium
 *
 * 8656
 *
 * 377
 *
 * Add to List
 *
 * Share
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */