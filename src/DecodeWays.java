public class DecodeWays {
    public static void main(String[] args) {
        String code = "224678";

        System.out.println(decodeWays(code.toCharArray()));
    }

    private static int decodeWays(char[] arr) {
        if(arr == null || arr.length == 0 ){
            return  0;
        }

        int[] dp = new int[arr.length + 1];
        dp[0] = 1;
        dp[1] = arr[0] == '0' ? 0 : 1;

        for(int i=2;i<=arr.length;i++){
            int singleDigit = Character.getNumericValue(arr[i-1]);
            int doubleDigit = 10 * Character.getNumericValue(arr[i -2]) + singleDigit;
            if(singleDigit > 0){
                dp[i] = dp[i] + dp[i-1];
            }

            if(doubleDigit > 10 && doubleDigit <=26){
                dp[i] = dp[i] + dp[i-2];
            }
        }
        return dp[arr.length];
    }
}


/**
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
