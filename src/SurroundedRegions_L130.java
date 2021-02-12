public class SurroundedRegions_L130 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        System.out.println();
    }

    public static void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }

        int rows = board.length;
        int columns = board[0].length;

        for(int i=0;i<rows; i++){
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][columns-1] == 'O') dfs(i, columns-1, board);
        }

        for(int i=0;i<columns; i++){
            if(board[0][i] == 'O') dfs(0, i, board);
            if(board[rows-1][i] == 'O') dfs(rows-1, i, board);
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j < board[i].length; j++){
                if(board[i][j] == 'X'){
                    continue;
                }
                if(board[i][j] == '~'){
                    board[i][j] = 'O';
                    continue;
                }
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(int row, int column, char[][] board) {
        if(row < 0 || row >= board.length || column < 0 || column >= board[row].length || board[row][column] == 'X' || board[row][column] == '~'){
            return;
        }
        if(board[row][column] == 'O'){
            board[row][column] = '~';
            dfs(row+1, column, board);
            dfs(row-1, column, board);
            dfs(row, column+1, board);
            dfs(row, column-1, board);
        }
    }
}
