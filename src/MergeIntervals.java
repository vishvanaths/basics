import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] a = {{0,2},{5,10},{13,23},{24,25}}; 
        int[][] b = {{1,5},{8,12},{15,24},{25,26}};

        System.out.println(printArray(intervalIntersection(a, b)));
    }

    private static String printArray(int[][] a) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int[] i : a){
            sb.append("[");
            for(int j : i){
                sb.append(j + ",");
            }
            sb.append("]");
        }
        sb.append("]");

        return sb.toString();
    }

    public static int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> overlapsList = new ArrayList<>();

        int i=0, j=0;

        while(i < a.length && j <b.length){

            int hi = Math.min(a[i][1], b[j][1]);
            int lo = Math.max(a[i][0], b[j][0]);

            if(lo <= hi){
                int[] over = new int[2];
                over[0] = lo;
                over[1] = hi;
                overlapsList.add(over);
            }
            if(a[i][1] < b[j][1]){
                i++;
            }else{
                j++;
            }
        }

        return overlapsList.toArray(new int[overlapsList.size()][]);
    }


    public static int[][] intervalIntersection1(int[][] a, int[][] b) {

        List<Integer[]> overlapsList = new ArrayList<>();
        getOverLaps(a, b, overlapsList);
        getOverLaps(b, a, overlapsList);
        Collections.sort(overlapsList, 
        (o1, o2) -> o1[0].compareTo(o2[0]));
        int[][] matrix = new int[overlapsList.size()][2];   
        int i=0;   
        for(Integer[] arr : overlapsList){
            matrix[i][0] = arr[0];
            matrix[i++][1] = arr[1]; 
        }
        return matrix;
    }

    private static void getOverLaps(int[][] a, int[][] b, List<Integer[]> overlapsList) {
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(b[j][0] < a[i][0] && a[i][0] <= b[j][1]){
                    Integer[] overlap = new Integer[2];
                    overlap[0] = a[i][0];
                    overlap[1] = b[j][1];
                    if(!overlapsList.contains(overlap))
                        overlapsList.add(overlap);
                    break;
                }
                if(a[i][1] < b[j][0]){
                    break;
                }
            }
        }
    }
}
