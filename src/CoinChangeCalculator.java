import java.util.Arrays;

public class CoinChangeCalculator {
    public static void main(String[] args) {
        int[] arr = {186,419,83,408};
        int target = 6249;
//        Arrays.sort(arr, Collections.reverseOrder());
//        int coin = -1;
//        for(int i=0;i<arr.length;i++){
//            coin = findCoinCount(arr, target, i);
//            if(coin != -1){
//                break;
//            }
//        }
        System.out.println(coinChange(arr, target));
    }

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i=1; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if((i - coins[j]) >= 0 ){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}


/**
 *
 * 322. Coin Change
 * Medium
 *
 * 4814
 *
 * 148
 *
 * Add to List
 *
 * Share
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
