
//Leetcode #309
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
//Decision Tree solution
//Works, but time limit exceeded. Improve speed
public class BuySellStockCooldown {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, helper(prices, i+1, true, prices[i]));
        }
        
        return maxProfit;
    }
    
    private int helper(int[] prices, int idx, boolean needToSell, int boughtPrice){
        if(idx >= prices.length)
            return 0;
        
        int maxProfit = 0;
        if(needToSell){
            for(int i = idx; i < prices.length; i++){
                int profit = prices[i] - boughtPrice;
                if(profit > 0){
                    int restProfit = helper(prices, i+2, false, Integer.MIN_VALUE);
                    maxProfit = Math.max(maxProfit, profit+restProfit);
                }
            }
            
            return maxProfit;
        }else{
            for(int i = idx; i < prices.length; i++){
                maxProfit = Math.max(maxProfit, helper(prices, i+1, true, prices[i])); 
            }
            
            return maxProfit;
        }
    }
}
