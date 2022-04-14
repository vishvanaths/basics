public class FindIn2DArray_L74 {
    public static void main(String[] args) {
        FindIn2DArray_L74 find = new FindIn2DArray_L74();
        System.out.println(find.searchMatrix(new int[][]{{1}},0));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c= matrix[0].length;
        int start=0;
        int end=r-1;

        int row = -1;
        while(start <= end){
            int mid = start + (end -start)/2;

            if(matrix[mid][0] <= target && matrix[mid][c -1] >= target){
                row = mid;
                break;
            }else if(target < matrix[mid][0]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        if (row == -1) return false;
        start = 0;
        end = c-1;

        while(start<= end){
            int mid = start + (end -start)/2;

            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }
}

/**
 * 74. Search a 2D Matrix
 * Medium
 *
 * 7189
 *
 * 262
 *
 * Add to List
 *
 * Share
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 */