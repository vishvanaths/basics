import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindShotRanges {
    public static void main(String[] args) {
        String[] shots = {"a", "b", "a", "b", "c", "b", "a", "c", "a", "d", "e", "f", "e", "g", "d", "e", "h", "i", "j", "k" };

        System.out.println(findShotRanges(shots));
    }

    private static List<Integer> findShotRanges(String[] shots) {
        Map<String, Integer[]> intervalsMap = new TreeMap<>();

        for(int i=0;i<shots.length;i++){
            String shot = shots[i];
            if(intervalsMap.containsKey(shot)){
                Integer[] interval = intervalsMap.get(shot);
                interval[1] = i;
                intervalsMap.put(shot, interval);
            }else{
                Integer[] interval = new Integer[2];
                interval[0] = i;
                interval[1] = i;
                intervalsMap.put(shot, interval);
            }
        }

        List<Integer> shotLengths = new ArrayList<>();
        List<Integer[]> intervals = new ArrayList<>(intervalsMap.values());
        Integer[] newInterval = {intervals.get(0)[0],intervals.get(0)[1]};
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i)[0] <= newInterval[1]){
                newInterval[0] = Math.min(intervals.get(i)[0], newInterval[0]);
                newInterval[1] = Math.max(intervals.get(i)[1], newInterval[1]);
            }else{
                shotLengths.add(newInterval[1] - newInterval[0] + 1);
                newInterval[0] = intervals.get(i)[0];
                newInterval[1] = intervals.get(i)[1];
            }
        }
        shotLengths.add(newInterval[1] + 1);
        return shotLengths;
    }


}
