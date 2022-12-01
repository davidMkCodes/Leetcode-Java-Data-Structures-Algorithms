//Leetcode #746
//https://leetcode.com/problems/min-cost-climbing-stairs/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        
        int twoBehind = 0;
        int oneBehind = 0;
        
        for(int i = 2; i < cost.length; i++){
            int curr = Math.min(twoBehind+cost[i-2], oneBehind+cost[i-1]);
            
            twoBehind = oneBehind;
            oneBehind = curr;
        }
        
        return Math.min(twoBehind+cost[cost.length-2], oneBehind+cost[cost.length-1]);
    }
}
