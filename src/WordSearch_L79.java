public class WordSearch_L79 {
    public static void main(String[] args) {
        char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}; String word = "ABCEFSADEESE";
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){
            return false;
        }
        if(word == null || word.length() == 0){
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        if(m*n < word.length()){
            return false;
        }

        char startChar = word.charAt(0);

        for(int i=0;i<m; i++){
            for (int j=0;j<n; j++){
                if(board[i][j] == startChar && dfsWord(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsWord(char[][] board, String word, int row, int column, int index) {
        if(index == word.length()){
            return true;
        }
        char nextChar = word.charAt(index);
        int m = board.length;
        int n = board[0].length;
        if(row >= m || row < 0 || column >= n || column < 0 || board[row][column] != nextChar){
            return false;
        }
        char temp = board[row][column];
        board[row][column] = ' ';
        boolean result = dfsWord(board, word, row, column+1, index+1)
                || dfsWord(board, word, row, column-1, index+1)
                || dfsWord(board, word, row+1, column, index+1)
                || dfsWord(board, word, row-1, column, index+1);

        board[row][column] = temp;
        return result;
    }
}
/**
 *79. Word Search
 * Medium
 *
 * 5192
 *
 * 225
 *
 * Add to List
 *
 * Share
 * Given an m x n board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 200
 * 1 <= word.length <= 103
 * board and word consists only of lowercase and uppercase English letters.
 */