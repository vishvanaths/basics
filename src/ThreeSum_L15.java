import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_L15 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        for(int i=0; i< nums.length-2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int low = i+1;
                int high = nums.length - 1;
                int target = 0 - nums[i];
                while(low < high){
                    if(nums[low] +  nums[high] == target){
                        results.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] ==  nums[low+1]) low++;
                        while(low < high && nums[high] ==  nums[high-1]) high--;
                        low++;
                        high--;
                    }else if(nums[low] +  nums[high] > target){
                        high--;
                    }else{
                        low++;
                    }
                }
            }
        }

        return results;
    }
}


/**
 * 15. 3Sum
 * Medium
 *
 * 10047
 *
 * 1035
 *
 * Add to List
 *
 * Share
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */