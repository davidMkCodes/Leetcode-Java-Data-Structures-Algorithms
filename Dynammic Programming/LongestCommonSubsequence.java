//Leetcode #1142
//https://leetcode.com/problems/longest-common-subsequence/
//Time Complexity: O(m*n)
//Space Complexity: o(m*n)
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][]dp = new int[text1.length()+1][text2.length()+1];
        
        for(int i = text1.length()-1; i >= 0; i--){
            for(int j = text2.length()-1; j >= 0; j--){
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                
                if(c1 == c2)
                    dp[i][j] = dp[i+1][j+1]+1;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                
                
            }
        }
        
        return dp[0][0];
    }
}
