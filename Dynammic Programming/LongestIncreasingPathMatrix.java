//Leetcode #329
//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
//Time Complexity: O(n*m)
//Space COmplexity: O(n*m)
public class LongestIncreasingPathMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        
        int[][]dp = new int[matrix.length][matrix[0].length];
        int LIP = 1;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(dp[i][j] == 0){
                    dp[i][j] = 1;
                    helper(i, j , dp, matrix);
                }
            }
        }
        
        for(int i = 0; i < dp.length; i++)
            for(int j = 0; j < dp[0].length; j++)
                LIP = Math.max(LIP, dp[i][j]);
        
        return LIP;
    }
    
    private void helper(int i, int j, int[][]dp, int[][]matrix){
        
        if(j-1 >= 0 && matrix[i][j] < matrix[i][j-1]){
            if(dp[i][j-1] == 0){
                dp[i][j-1] = 1;
                helper(i, j-1, dp, matrix);
            }
            
            dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + 1);
        }
        if(i-1 >= 0 && matrix[i][j] < matrix[i-1][j]){
            if(dp[i-1][j] == 0){
                dp[i-1][j] = 1;
                helper(i-1, j, dp, matrix);
            }
            
            dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + 1);
        }
        if(j+1 < dp[0].length && matrix[i][j] < matrix[i][j+1]){
            if(dp[i][j+1] == 0){
                dp[i][j+1] = 1;
                helper(i, j+1, dp, matrix);
            }
            
            dp[i][j] = Math.max(dp[i][j], dp[i][j+1] + 1);
        }
        if(i+1 < dp.length && matrix[i][j] < matrix[i+1][j]){
            if(dp[i+1][j] == 0){
                dp[i+1][j] = 1;
                helper(i+1, j, dp, matrix);
            }
            
            dp[i][j] = Math.max(dp[i][j], dp[i+1][j] + 1);
        }
    }
}
