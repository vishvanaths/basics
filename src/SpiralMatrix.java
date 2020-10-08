import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                            { 1, 2, 3 },
                            { 4, 5, 6 },
                            { 7, 8, 9 }
                        };

        spiralOrder(matrix);
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return spiral;
        }
        int TOP = 0;
        int LEFT = 0;
        int BOTTOM = matrix.length-1;
        int RIGHT = matrix[0].length-1;

        int MAX = matrix.length * matrix[0].length;

        while(spiral.size() < MAX){
            for(int i=LEFT; i<=RIGHT && spiral.size() < MAX; i++){
                spiral.add(matrix[TOP][i]);
            }
            TOP++;

            for(int i=TOP; i<=BOTTOM && spiral.size() < MAX; i++){
                spiral.add(matrix[i][RIGHT]);
            }
            RIGHT--;

            for(int i=RIGHT; i >= LEFT && spiral.size() < MAX; i--){
                spiral.add(matrix[BOTTOM][i]);
            }
            BOTTOM--;
            for(int i=BOTTOM; i>=TOP && spiral.size() < MAX; i--){
                spiral.add(matrix[i][LEFT]);
            }
            LEFT++;
        }
        return spiral;
    }
}

/***
 *54. Spiral Matrix
 * Medium
 *
 * 2851
 *
 * 601
 *
 * Add to List
 *
 * Share
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */