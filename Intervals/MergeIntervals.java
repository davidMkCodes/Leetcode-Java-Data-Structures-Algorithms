import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

//Leetcode #56
//https://leetcode.com/problems/merge-intervals/
//Time Complexity: O(nlogn) b/c of sorting the intervals array
//Space COmplexity: O(n)
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1)
            return intervals;
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        
        int i = 1;
        
        while(i < intervals.length){
            if(intervals[i][0] > intervals[i-1][1]){
                list.add(intervals[i-1]);
                i++;
                
                if(i == intervals.length)
                    list.add(intervals[i-1]);
            }else{
                int start = intervals[i-1][0];
                int end = Math.max(intervals[i-1][1],intervals[i][1]);
                i++;
                while(i < intervals.length && intervals[i][0] <= end){
                    if(intervals[i][1] > end 
                       && (i+1 == intervals.length || intervals[i+1][0] > intervals[i][1])){
                        end = intervals[i][1];
                        i++;
                        break;
                    }
                    end = Math.max(end, intervals[i][1]);
                    i++;
                }
                
                int[]newInterval = new int[2];
                newInterval[0] = start;
                newInterval[1] = end;
                list.add(newInterval);
                
                if(i+1 == intervals.length)
                    list.add(intervals[i]);
                i++;
            }
        }
        
        int[][]sol = new int[list.size()][2];
        for(i = 0; i < list.size(); i++)
            sol[i] = list.get(i); 
        
        return sol;
    }
}
