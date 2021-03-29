package dynamicProgramming;

public class BestTimeToBuyAndSellStock121 {

	private String name = "121. Best Time to Buy and Sell Stock";
	private String url = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/";
	
    public int maxProfit(int[] prices) {
    	
        if(prices.length < 2) {
        	return 0;
        }
        
        int[] profit = new int[prices.length];
        
        int maxProfit = 0; 
        for(int i = 1; i < prices.length; i++) {
        	profit[i] = Math.max(0, prices[i] - prices[i-1] + profit[i-1]);
        	maxProfit = Math.max(maxProfit, profit[i]);
        }
        
        return maxProfit;
    }
	
	
}
