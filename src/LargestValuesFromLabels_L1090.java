import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LargestValuesFromLabels_L1090 {
    public static void main(String[] args) {
        int[] values = new int[]{9,8,8,7,6}, labels = new int[]{0,0,0,1,1}; int num_wanted = 3, use_limit = 1;
        System.out.println(largestValsFromLabels(values, labels, num_wanted, use_limit));
    }
    public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        if(labels == null || values == null || labels.length == 0
                || values.length == 0 || labels.length != values.length || use_limit <=0){
            return -1;
        }
        PriorityQueue<LabelValue> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        for(int i=0; i<labels.length; i++){
            LabelValue lb = new LabelValue(labels[i], values[i]);
            priorityQueue.add(lb);
        }
        Map<Integer, Integer> labelUsage = new HashMap<>();

        int result = 0;
        for(int i=1;i<=num_wanted && !priorityQueue.isEmpty();){
            LabelValue lb = priorityQueue.poll();
            if(labelUsage.containsKey(lb.label) && labelUsage.get(lb.label) >= use_limit){
                //Do nothing
            }else{
                labelUsage.put(lb.label, labelUsage.containsKey(lb.label) ? labelUsage.get(lb.label) + 1 : 1);
                result += lb.value;
                i++;
            }
        }

        return result;
    }
}

class LabelValue{
    int label;
    int value;

    public LabelValue(int label, int value){
        this.label=label;
        this.value=value;
    }
}
