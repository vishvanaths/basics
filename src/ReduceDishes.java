import java.util.Arrays;

public class ReduceDishes {
    public static void main(String[] args) {
        int[] satisfaction = {-2,5,-1,0,3,-3};

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