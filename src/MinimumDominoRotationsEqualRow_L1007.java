public class MinimumDominoRotationsEqualRow_L1007 {
    public static void main(String[] args) {
        int[] A = new int[] {2,1,2,4,2,2}, B = new int[]{5,2,6,2,3,2};
        System.out.println(minDominoRotations(A, B));
    }
    public static int minDominoRotations(int[] A, int[] B) {
        if((A == null && B == null) || (A.length == 0 && B.length == 0)){
            return 0;
        }
        if((A == null && B != null) || (A != null && B == null) ||(A.length != B.length)){
            return -1;
        }

        int minRotation = Math.min(numberOfRotations(A[0], A, B), numberOfRotations(B[0], A, B));
        minRotation = Math.min(minRotation, numberOfRotations(A[0], B, A));
        minRotation = Math.min(minRotation, numberOfRotations(B[0], B, A));

        return minRotation;
    }

    private static int numberOfRotations(int target, int[] a, int[] b) {
        int numberOfRotations = 0;
        for(int i=0; i<a.length; i++){
            if(a[i] != target){
                if(b[i] != target){
                    return Integer.MAX_VALUE;
                }else {
                    numberOfRotations++;
                }
            }
        }
        return numberOfRotations;
    }
}

/**
 * 1007. Minimum Domino Rotations For Equal Row
 * Medium
 *
 * 1180
 *
 * 190
 *
 * Add to List
 *
 * Share
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * We may rotate the ith domino, so that A[i] and B[i] swap values.
 *
 * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
 *
 * If it cannot be done, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by A and B: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 * Example 2:
 *
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 *
 *
 * Constraints:
 *
 * 2 <= A.length == B.length <= 2 * 104
 * 1 <= A[i], B[i] <= 6
 */