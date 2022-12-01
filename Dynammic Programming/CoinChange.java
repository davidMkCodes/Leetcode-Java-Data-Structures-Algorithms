
//Leetcode #322
//https://leetcode.com/problems/coin-change/
//Time Complexity: O(n)
//Space Complexity: O(n)
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount+1];
        for(int i = 1; i < dp.length; i++)
            dp[i] = -1;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < coins.length; j++){
                int coin = coins[j];
                
                if(coin == i){
                    dp[i] = 1;
                    break;
                }else if(coin < i && dp[i-coin] != -1){
                    if(dp[i] == -1)
                        dp[i] = 1+dp[i-coin];
                    else
                        dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }
        
        return dp[dp.length-1];
    }
}
