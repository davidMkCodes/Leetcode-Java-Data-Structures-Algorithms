import java.util.List;
import java.util.ArrayList;

//Leetcode #57
//https://leetcode.com/problems/insert-interval/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int start = newInterval[0];
        int end = newInterval[1];
        
        List<int[]> list = new ArrayList<>();
        
        int i = 0;
        while(i < intervals.length && intervals[i][1] < start){
            list.add(intervals[i]);
            i++;
        }
        
        if(i < intervals.length && intervals[i][0] <= start && intervals[i][1] >= start)
            newInterval[0] = intervals[i][0];
        
        while(i < intervals.length && intervals[i][0] <= end){
            if(intervals[i][1] > end){
                newInterval[1] = intervals[i][1];
                i++;
                break;
            }

            i++;
        }
        
        
        list.add(newInterval);
        
        
        while(i < intervals.length){
            list.add(intervals[i]);
            i++;
        }
        
        int[][] sol = new int[list.size()][2];
        for(i = 0; i < list.size(); i++){
            sol[i] = list.get(i);
        }
        
        return sol;
    }
}
