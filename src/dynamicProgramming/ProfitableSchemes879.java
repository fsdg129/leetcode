package dynamicProgramming;

import java.util.Arrays;

public class ProfitableSchemes879 {

	private String name = "879. Profitable Schemes";
	private String url = "https://leetcode.com/problems/profitable-schemes/";
	
	public static void main(String[] args) {
		int n = 10;
		int minProfit = 5;
		int[] group = {2, 3, 5};
		int[] profit = {6, 7, 8};
		
		int result = profitableSchemes2DDP(n, minProfit, group, profit);
		System.out.println(result);
	}
	
    public static int profitableSchemes2DDP(int n, int minProfit, int[] group, int[] profit) {
        
    	if(group.length < 0)
    		return 0;
    	
    	int[][] numbers = new int[n + 1][minProfit + 1];
    	
    	//Initial the first line
		for(int j=0; j<=n; j++) {
			for(int k=0; k<=minProfit; k++) {
				numbers[j][k] = 0; 				
			}
		}
		numbers[0][0] = 1;
		if(n >= group[0]) {
			if(profit[0] >= minProfit)
				numbers[group[0]][minProfit] = 1;
			else
				numbers[group[0]][profit[0]] = 1;
		}
		
    	for(int i=1; i<group.length; i++) {    		
    		for(int j=n; j>=group[i]; j--) {
				for(int k=minProfit; k>=Math.max(minProfit-profit[i], 0); k--) {
					numbers[j][minProfit] = modSum(numbers[j][minProfit], numbers[j-group[i]][k]);
				}
    			for(int k=minProfit-1; k>=profit[i]; k--) {
    				numbers[j][k] = modSum(numbers[j][k], numbers[j-group[i]][k-profit[i]]);
    			}
    		}
    	}
    	
    	
    	int result = 0;
    	for(int j=0; j<=n; j++) {
    		result = modSum(result, numbers[j][minProfit]);
    	}

    	return result;
    }
	
	
	
    public static int profitableSchemes3DDP(int n, int minProfit, int[] group, int[] profit) {
        
    	if(group.length < 0)
    		return 0;
    	
    	int[][][] numbers = new int[group.length][n + 1][minProfit + 1];
    	
    	//Initial the first line
		for(int j=0; j<=n; j++) {
			for(int k=0; k<=minProfit; k++) {
				numbers[0][j][k] = 0; 				
			}
		}
		numbers[0][0][0] = 1;
		if(n >= group[0]) {
			if(profit[0] >= minProfit)
				numbers[0][group[0]][minProfit] = 1;
			else
				numbers[0][group[0]][profit[0]] = 1;
		}
		
    	for(int i=1; i<group.length; i++) {
    		for(int j=0; j<=n; j++) {
    			for(int k=0; k<minProfit; k++) {
    				numbers[i][j][k] = numbers[i-1][j][k];
    				if(j >= group[i] && k>=profit[i])
    					numbers[i][j][k] = modSum(numbers[i][j][k], numbers[i-1][j-group[i]][k-profit[i]]);
    			}
    			
    			numbers[i][j][minProfit] = numbers[i-1][j][minProfit];
    			if(j >= group[i]) {
    				for(int k=0; k<=minProfit; k++) {
    					if(k + profit[i] >= minProfit)
    						numbers[i][j][minProfit] = modSum(numbers[i][j][minProfit], numbers[i-1][j-group[i]][k]);
    				}
    			} 
    		}
    	}
    	
//    	for(int i=0; i<group.length; i++) {
//    		System.out.println("i = " + String.valueOf(i));
//    		for(int j=0; j<=n; j++) {
//    			System.out.println(Arrays.toString(numbers[i][j]));
//    		}
//    	}
    	
    	int result = 0;
    	for(int j=0; j<=n; j++) {
    		result = modSum(result, numbers[group.length - 1][j][minProfit]);
    	}

    	return result;
    }
    
    private static int modSum(int a, int b) {
    	final int mod = 1_000_000_000 + 7;
    	int sum = a % mod + b % mod;
    	return sum % mod;
    }
    
    public int profitableSchemesDFS(int n, int minProfit, int[] group, int[] profit) {
        
    	Result result = new Result();
    	schemeBacktrack(n, 0, 0, minProfit, 0, group, profit, result);
    	
    	return (int) (result.count % (1_000_000_000 + 7));
    	
    }
    
    private static void schemeBacktrack(int n, int used, int index, int minProfit, int generateProfit, 
    		int[] group, int[] profit, Result result) {
    	
    	if(used > n)
    		return;
    	if(index >= group.length) {
    		if(generateProfit >= minProfit)
    			result.count++;
    		return;
    	}

    	
    	schemeBacktrack(n, used + group[index], index + 1, minProfit, generateProfit + profit[index], 
    			group, profit, result);
    	schemeBacktrack(n, used, index + 1, minProfit, generateProfit, group, profit, result);
    	
    }
    
    private static class Result {
    	long count = 0L;
    }
}
