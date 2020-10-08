public class MaxDifferenceInArrayElements {
    public static void main(String[] args) {
        int[] prices =  {4, 5, 2, 1, 6, 10, 4, 9, 11};
        System.out.println(getMaxDifference(prices));
    }

    private static int getMaxDifference(int[] prices) {
        int profit = Math.max(prices[1] - prices[0], 0);
        int minStock = prices[0];

        for(int i=1; i<prices.length; i++){
            if((prices[i] - minStock) > profit){
                profit = prices[i] - minStock;
            }

            if(minStock > prices[i]){
                minStock = prices[i];
            }
        }
        return profit;
    }
}


/**
 * Best Time to Buy and Sell Stock
 * Given an array of integers where the ith integer represents the price of the stock on day i, return the largest possible profit from completing one transaction (i.e. buying 1 share and selling 1 share).
 * Examples: Given the following prices...
 *
 * // Buy on day 1 and sell on day 5 for a profit of 5 - 1 = 4.
 * prices = [1, 2, 3, 4, 5], return 4.
 * // Buy on day 4 and sell on day 9 for a profit of 11 - 1 = 10.
 * prices = [4, 5, 2, 1, 6, 10, 4, 9, 11], return 10.
 * // Buying and selling the stock at any point would yield a negative profit.
 * prices = [33, 18, 8, 2], return 0
 */
