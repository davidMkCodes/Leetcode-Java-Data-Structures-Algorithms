import java.util.Arrays;
import java.util.PriorityQueue;

//Leetcode #253
//https://leetcode.com/problems/meeting-rooms-ii/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class MeetingRoomsTwo {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b) -> a-b);
        
        
        for(int i = 0; i < intervals.length; i++){
            
            if(!que.isEmpty() && que.peek() <= intervals[i][0])
                que.poll();
            
            que.add(intervals[i][1]);
                
        }
        
        return que.size();
    }
}
