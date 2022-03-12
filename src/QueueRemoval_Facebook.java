import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class QueueRemoval_Facebook {

    // Add any helper functions you may need here


    int[] findPositions(int[] arr, int x) {
        int[] res = new int[x];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<arr.length; i++){
            int[] valIndex = new int[2];
            valIndex[0] = arr[i];
            valIndex[1] = i+1;
            queue.add(valIndex);
        }

        int j=0;
        while(x > j){
            int[] maxIndex = new int[2];
            Arrays.fill(maxIndex, -1);
            Queue<int[]> q= new LinkedList<>();
            for(int i=0; i<x && !queue.isEmpty(); i++){
                int[] item = queue.remove();

                if(maxIndex[0] < item[0]){
                    maxIndex[0] = item[0];
                    maxIndex[1] = item[1];
                }
                item[0] = (item[0] - 1 <= 0 ) ? 0 : (item[0] -1);
                q.add(item);
            }

            while(!q.isEmpty()){
                int[] item = q.remove();
                if(item[1] != maxIndex[1])
                queue.add(item);
            }

            res[j++] = maxIndex[1];

        }

        return res;
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
        int n_1 = 6;
        int x_1 = 5;
        int[] arr_1 = {1, 2, 2, 3, 4, 5};
        int[] expected_1 = {5, 6, 4, 1, 2 };
        int[] output_1 = findPositions(arr_1, x_1);
        check(expected_1, output_1);

        int n_2 = 13;
        int x_2 = 4;
        int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int[] expected_2 = {2, 5, 10, 13};
        int[] output_2 = findPositions(arr_2, x_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new QueueRemoval_Facebook().run();
    }
}