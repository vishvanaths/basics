import java.util.LinkedList;
import java.util.*;

public class Portals_Facebook {

    public static void main(String[] args) {
        Portals_Facebook pf = new Portals_Facebook();
        System.out.println(pf.getSecondsRequired(3,3, new char[][]{{'.','E', '.'},{'.','#', '.'},{'.','S', '#'}}));;
    }

    public int getSecondsRequired(int R, int C, char[][] G) {
        boolean[][] seen = new boolean[R][C];
        Map<Integer, Integer> portal = new HashMap<>();
        int seconds = Integer.MAX_VALUE;
        int startRow = 0, startColumn = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                char ch = G[i][j];
                if (ch == 'S') {
                    startRow = i;
                    startColumn = j;
                }
            }
        }
        if (G[startRow][startColumn] == 'S') {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {startRow, startColumn, 0});
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i=0; i<size; i++){
                    int[] node = queue.remove();
                    int r = node[0], c=node[1], soFarSeconds = node[2];
                    if(!seen[r][c]){
                        seen[r][c] = true;
                        if(G[r][c] == 'E'){
                            seconds = Math.min(soFarSeconds, seconds);
                        }

                        String key = r + ":" + c;
                        if (G[r][c] >= 'a' && G[r][c] <= 'z') {
                            for (int k = 0; k < R; ++k)
                                for (int j = 0; j < C; ++j)
                                    if (G[k][j] == G[r][c]) {
                                        moveToNode(queue, k, j, soFarSeconds + 1, G, seen);
                                    }
                        }

                        if(r > 0) moveToNode(queue, r-1, c, soFarSeconds + 1, G, seen);
                        if(r < R-1) moveToNode(queue, r+1, c, soFarSeconds + 1, G, seen);
                        if(c > 0) moveToNode(queue, r, c-1, soFarSeconds + 1, G, seen);
                        if(c < C-1) moveToNode(queue, r, c+1, soFarSeconds + 1, G, seen);
                    }
                }
            }

        }
        return seconds == Integer.MAX_VALUE ? -1 : seconds;
    }

    private void moveToNode(Queue<int[]> queue, Integer r, Integer c, int soFarSeconds, char[][] G, boolean[][] seen) {
        if(G[r][c] != '#' && !seen[r][c]){
            queue.offer(new int[]{r, c, soFarSeconds});
        }
    }
}

/**
 * Portals
 * Level 2
 * Time limit: 5s
 * Solved
 * You've found yourself in a grid of cells with RR rows and CC columns. The cell in the iith row from the top and jjth column from the left contains one of the following (indicated by the character G_{i,j}G
 * i,j
 * ​
 *  ):
 * If G_{i,j}G
 * i,j
 * ​
 *   = ".", the cell is empty.
 * If G_{i,j}G
 * i,j
 * ​
 *   = "S", the cell contains your starting position. There is exactly one such cell.
 * If G_{i,j}G
 * i,j
 * ​
 *   = "E", the cell contains an exit. There is at least one such cell.
 * If G_{i,j}G
 * i,j
 * ​
 *   = "#", the cell contains a wall.
 * Otherwise, if G_{i,j}G
 * i,j
 * ​
 *   is a lowercase letter (between "a" and "z", inclusive), the cell contains a portal marked with that letter.
 * Your objective is to reach any exit from your starting position as quickly as possible. Each second, you may take either of the following actions:
 * Walk to a cell adjacent to your current one (directly above, below, to the left, or to the right), as long as you remain within the grid and that cell does not contain a wall.
 * If your current cell contains a portal, teleport to any other cell in the grid containing a portal marked with the same letter as your current cell's portal.
 * Determine the minimum number of seconds required to reach any exit, if it's possible to do so at all. If it's not possible, return -1−1 instead.
 * Constraints
 * 1 \le R, C \le 501≤R,C≤50
 * G_{i,j} \inG
 * i,j
 * ​
 *  ∈ {".", "S", "E", "#", "a"..."z"}
 * Sample test case #1
 * R = 3
 * C = 3
 * G = .E.
 *     .#E
 *     .S#
 * Expected Return Value = 4
 * Sample test case #2
 * R = 3
 * C = 4
 * G = a.Sa
 *     ####
 *     Eb.b
 * Expected Return Value = -1
 * Sample test case #3
 * R = 3
 * C = 4
 * G = aS.b
 *     ####
 *     Eb.a
 * Expected Return Value = 4
 * Sample test case #4
 * R = 1
 * C = 9
 * G = xS..x..Ex
 * Expected Return Value = 3
 * Sample Explanation
 * In the first case, you can reach an exit in 44 seconds by walking left once, then up twice, and then finally right once.
 * In the second case, you can never reach the exit.
 * In the third case, you should walk right twice, then teleport to the cell in the 3rd row and 2nd column, and finally walk left once.
 * In the fourth case, you should walk left once, teleport to the cell in the last column, and walk left once more.
 */
