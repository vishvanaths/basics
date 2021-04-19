public class MaximalSquare_L221 {
    public static void main(String[] args) {

    }

    public int maximalSquare(char[][] matrix) {
        int result = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int answer = 0;
        for(int i=0; i<matrix.length;  i++){
            for(int j=0; j<matrix[0].length;  j++){

                if(matrix[i][j] == '1'){
                    dp[i][j] = 1;
                    if(i > 0 && j > 0){

                        dp[i][j] += Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                    }
                    answer =  Math.max(dp[i][j], answer);
                }


            }
        }

        return answer*answer;
    }
}


/**
 * 221. Maximal Square
 * Medium
 *
 * 4485
 *
 * 106
 *
 * Add to List
 *
 * Share
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * Example 2:
 *
 *
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * Example 3:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 * Accepted
 */