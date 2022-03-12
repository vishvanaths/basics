// Add any extra import statements you may need here


class BillionUsers_facebook {

    // Add any helper functions you may need here

    int b = 1_000_000_000;
    int getBillionUsersDay(float[] growthRates) {
        int end = 2000;
        int start = 1;

        while(start < end){
            int mid = (start+end)/2;
            double total =0;
            for(float gr : growthRates){
                total += Math.pow(gr, mid);
            }

            if(b < total){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        float[] test_1 = {1.1f, 1.2f, 1.3f};
        int expected_1 = 79;
        int output_1 = getBillionUsersDay(test_1);
        check(expected_1, output_1);

        float[] test_2 = {1.01f, 1.02f};
        int expected_2 = 1047;
        int output_2 = getBillionUsersDay(test_2);
        check(expected_2, output_2);


        // Add your own test cases here

    }
    public static void main(String[] args) {
        new BillionUsers_facebook().run();
    }
}