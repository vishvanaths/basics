import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergedIntervals_L56 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return intervals;

        PriorityQueue<Interval> heap = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);

        for(int i=0; i<intervals.length; i++){
            heap.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        List<Interval> mIntervals = new ArrayList<>();
        Interval prev = null;
        while(!heap.isEmpty()){
            Interval current = heap.remove();
            if(prev != null){
                if(current.start <= prev.end){
                    prev.end = Math.max(prev.end, current.end);
                }else{
                    mIntervals.add(prev);
                    prev = current;
                }
            }else{
                prev = current;
            }
        }
        if(prev != null)  mIntervals.add(prev);
        int j=0;
        int[][] mergedIntervals =  new int[mIntervals.size()][2];
        for(Interval i : mIntervals){
            mergedIntervals[j][0] = i.start;
            mergedIntervals[j++][1] = i.end;
        }
        return mergedIntervals;
    }
}

class Interval{
    int start;
    int end;

    public Interval(int i, int j){
        start = i;
        end = j;
    }
}

/**
 * 56. Merge Intervals
 * Medium
 *
 * 6561
 *
 * 361
 *
 * Add to List
 *
 * Share
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */