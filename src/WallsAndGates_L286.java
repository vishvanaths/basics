import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates_L286 {
    public static final int EMPTY_ROOM = 2147483647;
    private static final int GATE = 0;
    private static final int WALL = -1;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );
    public static void main(String[] args) {
        int[][] rooms = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates(rooms);
    }
    public static void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0){
            return;
        }
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;

        Queue<Integer[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new Integer[] { row, col });
                }
            }
        }

        while(!q.isEmpty()){
            Integer[] gate = q.poll();
            int gRow = gate[0];
            int gColumn = gate[1];
            for(int i=0;i<DIRECTIONS.size(); i++){
                int nRow = gRow + DIRECTIONS.get(i)[0];
                int nColumn = gColumn + DIRECTIONS.get(i)[1];
                if(nRow >= m || nRow < 0 || nColumn < 0 || nColumn >= n || rooms[nRow][nColumn] != EMPTY_ROOM ){
                    continue;
                }
                rooms[nRow][nColumn] = rooms[gRow][gColumn] + 1;
                q.add(new Integer[]{ nRow, nColumn });
            }
        }
    }
}

/**
 * 286. Walls and Gates
 * Medium
 *
 * 1506
 *
 * 22
 *
 * Add to List
 *
 * Share
 * You are given an m x n grid rooms initialized with these three possible values.
 *
 * -1 A wall or an obstacle.
 * 0 A gate.
 * INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 * Example 2:
 *
 * Input: rooms = [[-1]]
 * Output: [[-1]]
 * Example 3:
 *
 * Input: rooms = [[2147483647]]
 * Output: [[2147483647]]
 * Example 4:
 *
 * Input: rooms = [[0]]
 * Output: [[0]]
 *
 *
 * Constraints:
 *
 * m == rooms.length
 * n == rooms[i].length
 * 1 <= m, n <= 250
 * rooms[i][j] is -1, 0, or 231 - 1.
 */