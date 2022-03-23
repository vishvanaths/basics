import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//Incomplete
public class ConveyorChaos_Facebook {

    public double getMinExpectedHorizontalTravelDistance(int N, int[] H, int[] A, int[] B) {
        TreeMap<Integer, List<ConveyorInfo>> sortedData = new TreeMap<>();
        int maxConveyorBound = B[0];
        int minConveyorBound = A[0];
        for(int i=0; i<N; i++){
            if(sortedData.containsKey(H[i])){
                sortedData.put(H[i], new ArrayList<>());
            }
            maxConveyorBound = Math.max(maxConveyorBound, B[i]);
            minConveyorBound = Math.max(minConveyorBound, A[i]);
            sortedData.get(H[i]).add(new ConveyorInfo(H[i], A[i], B[i]));
        }
        return 0.0;
    }



    public static void main(String[] args) {
        ConveyorChaos_Facebook ccf = new ConveyorChaos_Facebook();
        ccf.getMinExpectedHorizontalTravelDistance(2, new int[]{10, 20}, new int[] {100000, 400000}, new int[]{600000, 800000});
    }
}

class ConveyorInfo{
    int h;
    int start;
    int end;

    public ConveyorInfo(int h, int start, int end) {
        this.h = h;
        this.start = start;
        this.end = end;
    }
}
