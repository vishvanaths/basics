import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2_L40 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> results =  new ArrayList<>();
        Arrays.sort(candidates);

        LinkedList<Integer> seed = new LinkedList<>();
        seed.add(candidates[0]);
        backtrack(candidates, 1, target, candidates[0], seed, results);

        return results;
    }

    public static void backtrack(int[] candidates, int index, int target, int currValue, LinkedList<Integer> seed, List<List<Integer>> results){
        if(target == currValue){
            results.add(new LinkedList<>(seed));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            if(candidates[i - 1] == candidates[i]){
                continue;
            }
            if((currValue + candidates[i] <= target) && i+1 < candidates.length){
                seed.add(candidates[i]);
                backtrack(candidates, i + 1, target, currValue + candidates[i], seed, results);
                seed.removeLast();
            }else{
                break;
            }
        }
    }
}

/**
 * 40. Combination Sum II
 * Medium
 *
 * 4880
 *
 * 131
 *
 * Add to List
 *
 * Share
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */