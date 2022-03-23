import java.util.Arrays;

public class ReduceDishes {
    public static void main(String[] args) {
        int[] satisfaction = {-1,-8,0,5,-9};

        // System.out.println(maxSatisfaction(satisfaction));
        Arrays.sort(satisfaction);
        
        int currentSum = 0;
        int maxSum = 0;
        int increment = 0;
        int i = satisfaction.length - 1;
        
        while (i >= 0) {
            increment += satisfaction[i];
            currentSum += increment;
            maxSum = Math.max(currentSum, maxSum);
            --i;
        }
        
        System.out.println(maxSum);
    }

    private static int maxSatisfaction(int[] satisfaction) {
        quickSort(satisfaction, 0, satisfaction.length - 1);
        System.out.println(SortingAlgo.arrayToString(satisfaction));
        return runningSumLength(satisfaction);
    }

    private static int runningSumLength(int[] satisfaction) {
        int runningSum = satisfaction[satisfaction.length - 1];
        if(runningSum <= 0){
            return 0;
        }
        int i=satisfaction.length - 2;
        for(; i >= 0; i--){
            if(runningSum + satisfaction[i] >= 0){
                runningSum += satisfaction[i];
            }else{
                break;
            }
        }

        int pos = i; 
        for( ; i < satisfaction.length; i++){
            runningSum += satisfaction[i] * (i - pos + 1);
        }

        return runningSum;
    }

    private static void quickSort(int[] satisfaction, int start, int end) {
        if(start < end){
            int pIndex = partition(satisfaction, start, end);
            quickSort(satisfaction, start, pIndex - 1);
            quickSort(satisfaction, pIndex + 1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int pIndex = start;
        
        for(int i=start; i < end; i++){
            if(a[i] < pivot){
                swap(a, pIndex, i);
                pIndex++;
            }
        }
        swap(a, pIndex, end);
        return pIndex;
    }

    private static void swap(int[] a, int pIndex, int i) {
        int temp = a[pIndex];
        a[pIndex] = a[i];
        a[i] = temp;
    }
}

/**
 * 1402. Reducing Dishes
 * Hard
 *
 * 891
 *
 * 135
 *
 * Add to List
 *
 * Share
 * A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.
 *
 * Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied by its satisfaction level i.e. time[i] * satisfaction[i].
 *
 * Return the maximum sum of like-time coefficient that the chef can obtain after dishes preparation.
 *
 * Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.
 *
 *
 *
 * Example 1:
 *
 * Input: satisfaction = [-1,-8,0,5,-9] [-9, -8, -1, 0, 5]
 * Output: 14
 * Explanation: After Removing the second and last dish, the maximum total like-time coefficient will be equal to (-1*1 + 0*2 + 5*3 = 14).
 * Each dish is prepared in one unit of time.
 * Example 2:
 *
 * Input: satisfaction = [4,3,2]
 * Output: 20
 * Explanation: Dishes can be prepared in any order, (2*1 + 3*2 + 4*3 = 20)
 * Example 3:
 *
 * Input: satisfaction = [-1,-4,-5]
 * Output: 0
 * Explanation: People do not like the dishes. No dish is prepared.
 *
 *
 * Constraints:
 *
 * n == satisfaction.length
 * 1 <= n <= 500
 * -1000 <= satisfaction[i] <= 1000
 */