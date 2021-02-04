package dynamicProgramming;


public class PerfectSquares279 {

	private String name = "303. Range Sum Query - Immutable";
	private String url = "https://leetcode.com/problems/range-sum-query-immutable/";
	
    public int numSquares(int n) {
        
    	int[] numbers = new int[n + 1];
    	numbers[0] = 0;
    	
    	int number, j;
    	for(int i=1; i<=n; i++) {
    		
    		number = Integer.MAX_VALUE;
    		j = 1;
    		while(i - j * j >= 0) {
    			number = Math.min(numbers[i - j * j] + 1, number);
    			j++;
    		}
    		numbers[i] = number;
    		
    	}
    	
    	return numbers[n];

    }
}
