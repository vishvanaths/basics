import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
// Add any extra import statements you may need here


class MaximumLengthSubstring_Facebook {

    // Add any helper functions you may need here


    int minLengthSubstring(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()){
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        int left=0;
        int right=0;
        int windowLength = -1;
        Map<Character, Integer> windowCount = new HashMap<>();
        int charsSoFar = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(windowCount.containsKey(c)){
                windowCount.put(c, windowCount.get(c) + 1);
            }else{
                windowCount.put(c, 1);
            }

            if(map.containsKey(c) && map.get(c) == windowCount.get(c)){
                charsSoFar++;
            }


            while(left <= right && charsSoFar == map.size()){
                char inc= s.charAt(left);
                if(windowLength == -1){
                    windowLength = right -left +1;
                }else{
                    windowLength = Math.max(windowLength, right-left+1);
                }
                windowCount.put(inc, windowCount.get(inc) - 1);
                if (map.containsKey(inc) && windowCount.get(inc) < map.get(inc)) {
                    charsSoFar--;
                }
                left++;
            }

            right++;
        }

        return windowLength;
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
    public void run() throws IOException {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) throws IOException {
        new MaximumLengthSubstring_Facebook().run();
    }
}

/***
 **
 * Minimum Length Substrings
 * You are given two strings s and t. You can select any substring of string s and rearrange the characters of the selected substring. Determine the minimum length of the substring of s such that string t is a substring of the selected substring.
 * Signature
 * int minLengthSubstring(String s, String t)
 * Input
 * s and t are non-empty strings that contain less than 1,000,000 characters each
 * Output
 * Return the minimum length of the substring of s. If it is not possible, return -1
 * Example
 * s = "dcbefebce"
 * t = "fd"
 * output = 5
 * Explanation:
 * Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the minimum length required is 5.
 */