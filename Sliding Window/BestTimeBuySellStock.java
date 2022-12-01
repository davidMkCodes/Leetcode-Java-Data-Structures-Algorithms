//Leetcode #121
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//Time Complexity: O(n)
//Space Complexity: O(1)
public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minPrice)
                minPrice = prices[i];
            else
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        
        return maxProfit;
    }
}
