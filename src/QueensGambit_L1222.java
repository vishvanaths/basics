import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensGambit_L1222 {
    public static void main(String[] args) {
        int[][] queens = new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] king = new int[]{0, 0};
        System.out.println(queensAttackKing(queens, king));
    }

    private static List<List<Integer>> queensAttackKing(int[][] queens, int[] king) {
        List<List<Integer>> attackingQueens = new ArrayList<>();
        if (queens == null || queens.length == 0 || king == null || king.length == 0) {
            return attackingQueens;
        }

        boolean[][] queenPresent = new boolean[8][8];
        for (int i = 0; i < queens.length; i++) {
            queenPresent[queens[i][0]][queens[i][1]] = true;
        }
        final int attackDirections = 8;
        boolean[] blocked = new boolean[attackDirections];
        int blockedCount = 0;
        int startRow = king[0];
        int startColumn = king[1];
        int counter = 1;

        while (blockedCount <= 8 && counter < attackDirections) {
            for (int direction = 1; direction <= 8; direction++) {
                if (blocked[direction - 1]) {
                    continue;
                } else {
                    int newRow = 0;
                    int newColumn = 0;
                    switch (direction) {
                        case 1:
                            newRow = startRow - counter;
                            newColumn = startColumn;
                            break;
                        case 2:
                            newRow = startRow - counter;
                            newColumn = startColumn + counter;
                            break;
                        case 3:
                            newRow = startRow;
                            newColumn = startColumn + counter;
                            break;
                        case 4:
                            newRow = startRow + counter;
                            newColumn = startColumn + counter;
                            break;
                        case 5:
                            newRow = startRow + counter;
                            newColumn = startColumn;
                            break;
                        case 6:
                            newRow = startRow + counter;
                            newColumn = startColumn - counter;
                            break;
                        case 7:
                            newRow = startRow;
                            newColumn = startColumn - counter;
                            break;
                        case 8:
                            newRow = startRow - counter;
                            newColumn = startColumn - counter;
                            break;
                    }

                    if (newRow < 8 && newRow >= 0 && newColumn < 8 && newColumn >= 0) {
                        if (queenPresent[newRow][newColumn]) {
                            blocked[direction - 1] = true;
                            List<Integer> position = new ArrayList<>(Arrays.asList(newRow, newColumn));
                            attackingQueens.add(position);
                            blockedCount++;
                        }
                    } else {
                        blocked[direction - 1] = true;
                        blockedCount++;
                    }
                }

            }
            counter++;
        }

        return attackingQueens;
    }
}

/**
 * 1222. Queens That Can Attack the King
 * Medium
 * <p>
 * 398
 * <p>
 * 81
 * <p>
 * Add to List
 * <p>
 * Share
 * On an 8x8 chessboard, there can be multiple Black Queens and one White King.
 * <p>
 * Given an array of integer coordinates queens that represents the positions of the Black Queens, and a pair of coordinates king that represent the position of the White King, return the coordinates of all the queens (in any order) that can attack the King.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * Output: [[0,1],[1,0],[3,3]]
 * Explanation:
 * The queen at [0,1] can attack the king cause they're in the same row.
 * The queen at [1,0] can attack the king cause they're in the same column.
 * The queen at [3,3] can attack the king cause they're in the same diagnal.
 * The queen at [0,4] can't attack the king cause it's blocked by the queen at [0,1].
 * The queen at [4,0] can't attack the king cause it's blocked by the queen at [1,0].
 * The queen at [2,4] can't attack the king cause it's not in the same row/column/diagnal as the king.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
 * Output: [[2,2],[3,4],[4,4]]
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
 * Output: [[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= queens.length <= 63
 * queens[i].length == 2
 * 0 <= queens[i][j] < 8
 * king.length == 2
 * 0 <= king[0], king[1] < 8
 * At most one piece is allowed in a cell.
 */