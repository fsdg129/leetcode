package dynamicProgramming;

public class ProfitableSchemes879 {

	private String name = "879. Profitable Schemes";
	private String url = "https://leetcode.com/problems/profitable-schemes/";
	
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
    	Result result = new Result();
    	schemeBacktrack(n, 0, 0, minProfit, 0, group, profit, result);
    	
    	return (int) (result.count % (1_000_000_000 + 7));
    	
    }
    
    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        
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
