public class MonotonicArray_L896 {
    public static void main(String[] args) {

    }

    public boolean isMonotonic(int[] A) {
        if(A == null || A.length == 0){
            return true;
        }

        boolean increasing = false, decreasing=false;
        for(int i=0;i<A.length-1;i++){
            if(A[i] == A[i+1]){
                continue;
            }else if(A[i] < A[i+1]){
                increasing = true;
            }else{
                decreasing = true;
            }
            if(increasing == true && decreasing == true) return false;
        }

        return true;
    }
}

/**
 * 896. Monotonic Array
 * Easy
 *
 * 897
 *
 * 42
 *
 * Add to List
 *
 * Share
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 *
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 *
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 *
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 *
 * Input: [1,1,1]
 * Output: true
 */