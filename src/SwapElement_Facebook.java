import java.util.*;
// Add any extra import statements you may need here


class SwapElement_Facebook {

    // Add any helper functions you may need here


    int[] findMinArray(int[] arr, int k) {
        // Write your code here
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        List<Integer> items = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            treeMap.put(arr[i], i);
            items.add(arr[i]);
        }
        int[] result = new int[arr.length];
        int i=0;

        for(Map.Entry<Integer, Integer> entry : treeMap.entrySet()){
            int position = entry.getValue();
            if(position <= k){
                result[i] = entry.getKey();
                items.remove(entry.getKey());
                k = k - position;
                i++;
            }

            if(k <= 0){
                break;
            }
        }

        for(int val : items){
            result[i++] = val;
        }
        return result;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int n_1 = 3, k_1 = 2;
        int[] arr_1 = {5, 3, 1};
        int[] expected_1 = {1, 5, 3};
        int[] output_1 = findMinArray(arr_1,k_1);
        check(expected_1, output_1);

        int n_2 = 5, k_2 = 3;
        int[] arr_2 = {8, 9, 11, 2, 1};
        int[] expected_2 = {2, 8, 9, 11, 1};
        int[] output_2 = findMinArray(arr_2,k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new SwapElement_Facebook().run();
    }
}

/**
 * Element Swapping
 * Given a sequence of n integers arr, determine the lexicographically smallest sequence which may be obtained from it after performing at most k element swaps, each involving a pair of consecutive elements in the sequence.
 * Note: A list x is lexicographically smaller than a different equal-length list y if and only if, for the earliest index at which the two lists differ, x's element at that index is smaller than y's element at that index.
 * Signature
 * int[] findMinArray(int[] arr, int k)
 * Input
 * n is in the range [1, 1000].
 * Each element of arr is in the range [1, 1,000,000].
 * k is in the range [1, 1000].
 * Output
 * Return an array of n integers output, the lexicographically smallest sequence achievable after at most k swaps.
 * Example 1
 * n = 3
 * k = 2
 * arr = [5, 3, 1]
 * output = [1, 5, 3]
 * We can swap the 2nd and 3rd elements, followed by the 1st and 2nd elements, to end up with the sequence [1, 5, 3]. This is the lexicographically smallest sequence achievable after at most 2 swaps.
 * Example 2
 * n = 5
 * k = 3
 * arr = [8, 9, 11, 2, 1]
 * output = [2, 8, 9, 11, 1]
 * We can swap [11, 2], followed by [9, 2], then [8, 2].
 */