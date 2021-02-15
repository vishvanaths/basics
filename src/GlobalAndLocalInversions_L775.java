public class GlobalAndLocalInversions_L775 {
    public static void main(String[] args) {
        int[] A = new int[]{1,0,2};
        System.out.println(isIdealPermutation(A));
    }
    public static boolean isIdealPermutation(int[] A) {
        if(A == null || A.length == 0){
            return true;
        }
        int max = -1;
        for (int i=0; i<A.length-2;i++){
            max =  Math.max(A[i], max);
            if(max > A[i+2]) return false;
        }
        return true;
    }
}

/**
 * 775. Global and Local Inversions
 * Medium
 *
 * 523
 *
 * 195
 *
 * Add to List
 *
 * Share
 * We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.
 *
 * The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].
 *
 * The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].
 *
 * Return true if and only if the number of global inversions is equal to the number of local inversions.
 *
 * Example 1:
 *
 * Input: A = [1,0,2]
 * Output: true
 * Explanation: There is 1 global inversion, and 1 local inversion.
 * Example 2:
 *
 * Input: A = [1,2,0]
 * Output: false
 * Explanation: There are 2 global inversions, and 1 local inversion.
 * Note:
 *
 * A will be a permutation of [0, 1, ..., A.length - 1].
 * A will have length in range [1, 5000].
 * The time limit for this problem has been reduced.
 */