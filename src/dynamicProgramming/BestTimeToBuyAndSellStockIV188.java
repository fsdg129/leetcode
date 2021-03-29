package dynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV188 {

	private String name = "188. Best Time to Buy and Sell Stock IV";
	private String url = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/";
	
    public int maxProfit(int k, int[] prices) {
        
        if(prices.length <= 0 || k <= 0) {
            return 0;
        }
        
        if(2 * k >= prices.length) {
        	int[] profit = new int[prices.length];
        	profit[0] = 0;
        	for(int i = 1; i < profit.length; i++) {
        		profit[i] = prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] + profit[i - 1] : profit[i - 1];
        	}
        	return profit[profit.length - 1];
        }
        
        // 0: not holding a stock, 1: hold a stock
    	int[][][] profit = new int[prices.length + 1][k + 1][2];

    	profit[0][0][0] = 0;
    	for(int day = 1; day <= prices.length; day++) {
    		
    		profit[day][0][0] = 0;
    		for(int transNum = 1; transNum <= Math.min(k, day / 2); transNum++) {
    			if(2 * transNum != day)
		    		profit[day][transNum][0] = Math.max(profit[day - 1][transNum][0], 
		    				profit[day - 1][transNum - 1][1] + prices[day - 1]);
    			else
    				profit[day][transNum][0] = profit[day - 1][transNum - 1][1] + prices[day - 1];
    		}
    		
    		for(int transNum = 0; transNum <= Math.min(k, (day - 1) / 2); transNum++) {
    			if(2 * transNum + 1 != day)
    	    		profit[day][transNum][1] = Math.max(profit[day - 1][transNum][1], 
    	    				profit[day - 1][transNum][0] - prices[day - 1]);
    			else
    				profit[day][transNum][1] = profit[day - 1][transNum][0] - prices[day - 1];
    		}
    		
    	}
    	
    	return Arrays.stream(profit[prices.length]).mapToInt(r -> r[0]).max().getAsInt();
    	
    }
	
	
}
