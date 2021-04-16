

public class NumberOfProvinces {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int providence = 0;

        for(int i=0; i<isConnected.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(isConnected, visited, i);
                providence++;
            }
        }

        return providence;
    }

    public static void dfs(int[][] isConnected, boolean[] visited, int node){
        for(int j=0; j<isConnected[0].length; j++){
            if(isConnected[node][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
}
