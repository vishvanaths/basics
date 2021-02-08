import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII_L253 {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        if(intervals.length == 1){
            return 1;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> meetingRoomScheduler = new PriorityQueue<>((o1, o2) -> o1-o2);
        meetingRoomScheduler.add(intervals[0][1]);

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= meetingRoomScheduler.peek()){
                meetingRoomScheduler.poll();
            }
            meetingRoomScheduler.add(intervals[i][1]);
        }
        return meetingRoomScheduler.size();
    }
}

/**
 * 253. Meeting Rooms II
 * Medium
 *
 * 3393
 *
 * 55
 *
 * Add to List
 *
 * Share
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */