//Leetcode #300
//https://leetcode.com/problems/longest-increasing-subsequence/
//Time Complexity: O(n*n)
//Space Complexity: O(n)
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[]dp = new int[nums.length];
        int maxLIS = 1;
        dp[0] = 1;
        
        for(int i = 1; i < dp.length; i++){
            int LIS = 1;
            
            for(int j = i-1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    LIS = Math.max(LIS, 1+dp[j]);
                }
            }
            
            dp[i] = LIS;
            maxLIS = Math.max(maxLIS, LIS);
        }
        
        return maxLIS;
    }
}
