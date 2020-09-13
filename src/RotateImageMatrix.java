public class RotateImageMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        System.out.println(printArray(matrix));

        //swap
        final int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if(i != j){
                    int tmp = matrix[i][j];
                    matrix[i][j] =  matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }

        //reverse each row
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length /2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = tmp;
            }
        }

        System.out.println(printArray(matrix));
    }


    private static String printArray(int[][] a) {
        StringBuilder sb = new StringBuilder();
//        sb.append("[");
        for(int[] i : a){
//            sb.append("[");
            for(int j : i){
                sb.append(j + ",");
            }
            sb.append("\n");
        }
//        sb.append("]");

        return sb.toString();
    }
}
/**
 * To rotate, we can transpose the matrix firstly, then reverse columns:
 * for a matrix:
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * <p>
 * 1/ transpose: swap( matrix[i][j], matrix[j][i] )
 * [1,4,7],
 * [2,5,8],
 * [3,6,9]
 * <p>
 * 2/ reverse columns: swap( matrix[][i], matrix[][j] )
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 */