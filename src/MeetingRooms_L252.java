import java.lang.reflect.Array;
import java.util.Arrays;

public class MeetingRooms_L252 {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{5,10},{15,20},{0,30}};
        System.out.println(canAttendMeetings(intervals));
    }
    public static boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length < 2){
            return true;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
}

/**
 * 252. Meeting Rooms
 * Easy
 *
 * 836
 *
 * 44
 *
 * Add to List
 *
 * Share
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: true
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti < endi <= 106
 */
