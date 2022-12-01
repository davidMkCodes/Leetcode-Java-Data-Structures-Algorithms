import java.util.Arrays;
//Leetcode #252
//https://leetcode.com/problems/meeting-rooms/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        for(int i = 1; i < intervals.length; i++){
            int prevEnd = intervals[i-1][1];
            int currStart = intervals[i][0];
            
            if(currStart < prevEnd)
                return false;
        }
        
        return true;
    }
}
