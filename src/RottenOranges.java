import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(findRottingTime(grid));

    }

    private static int findRottingTime(int[][] grid) {
        Queue<Pair> rottenQueue = new LinkedList<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int freshOranges = 0;

        for(int i=0; i<ROWS;i++){
            for(int j=0; j<COLS; j++){
                if(grid[i][j] == 2){
                    rottenQueue.offer(new Pair(i, j));
                }
                if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        rottenQueue.offer(new Pair(-1, -1));
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int minutes = 0;
        while(!rottenQueue.isEmpty()){
            Pair p = rottenQueue.poll();
            if(p.row == -1 && p.col == -1){
                if(!rottenQueue.isEmpty()){
                    rottenQueue.offer(new Pair(-1, -1));
                    minutes++;
                }
            }else{ //found rotten orange
                for (int[] d : directions) {
                    int neighborRow = p.row + d[0];
                    int neighborCol = p.col + d[1];
                    if (neighborRow >= 0 && neighborRow < ROWS &&
                            neighborCol >= 0 && neighborCol < COLS) {
                        if (grid[neighborRow][neighborCol] == 1) {
                            // this orange would be contaminated
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            // this orange would then contaminate other oranges
                            rottenQueue.offer(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }
        }

        return (freshOranges == 0) ? minutes : -1;

    }
}

class Pair{
    int row, col;

    public Pair(int row, int col){
        this.col = col;
        this.row = row;
    }
}
