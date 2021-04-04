import java.util.ArrayList;
import java.util.List;

public class Subsets_L73 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return result;
        }

        generateSubsets(0, new ArrayList<Integer>(), nums, result);

        return result;
    }

    public static void generateSubsets(int index, List<Integer> current, int[] nums, List<List<Integer>> result){
        result.add(new ArrayList<>(current));

        for(int i=index; i<nums.length; i++){
            current.add(nums[i]);
            generateSubsets(i+1, current, nums, result);
            current.remove(current.size() -1);
        }
    }
}

/**
 * 78. Subsets
 * Medium
 *
 * 5500
 *
 * 111
 *
 * Add to List
 *
 * Share
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */