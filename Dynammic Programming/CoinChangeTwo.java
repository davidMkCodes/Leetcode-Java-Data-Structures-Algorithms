//Leetcode #518
//https://leetcode.com/problems/coin-change-ii/
//Time Complexity: O(n*m)
//Space Complexity: o(n*m)
public class CoinChangeTwo {
    public int change(int amount, int[] coins) {
        int[][]dp = new int[coins.length+1][amount+1];
        
        dp[0][0] = 1;
        for(int i = 1; i < dp.length; i++)
            dp[i][0] = 1;
        
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                int coin = coins[i-1];
                
                dp[i][j] += dp[i-1][j];
                if(j-coin >= 0)
                    dp[i][j] += dp[i][j-coin] ;            
            }
        }
        
        
        return dp[dp.length-1][dp[0].length-1];
    }
}
