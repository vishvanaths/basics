public class UniquePaths_L65 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
    public static int uniquePaths(int m, int n) {
        if(m <=0 || n <= 0){
            return -1;
        }

        int[][] solution = new int[m][n];

        for(int i=0; i<n; i++){
            solution[0][i] = 1;
        }
        for(int i=0; i<m; i++){
            solution[i][0] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                solution[i][j] = solution[i-1][j] + solution[i][j-1];
            }
        }
        return solution[m-1][n-1];
    }
}
