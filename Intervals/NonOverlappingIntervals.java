import java.util.Arrays;

//Leetcode #435
//https://leetcode.com/problems/non-overlapping-intervals/
//Time Complexity: O(n^2)
//Space Complexity: O(n)
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        int[]dp = new int[intervals.length];
        dp[0] = 1;

        for(int i = 1; i < dp.length; i++){
            int currStart = intervals[i][0];
            int max = 0;
            
            for(int j = i-1; j >= 0; j--){
                int prevEnd = intervals[j][1];
                
                if(currStart >= prevEnd){
                    max = Math.max(max, dp[j]);
                    break;
                }
            }
            
            dp[i] = max+1;
        }
        
        return intervals.length-dp[dp.length-1];
    }
}
