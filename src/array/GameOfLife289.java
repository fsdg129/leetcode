package array;

public class GameOfLife289 {

	private String name = "289. Game of Life";
	private String url = "https://leetcode.com/problems/game-of-life/";
	
	private static int[][] offsetGroup = {
		{-1, -1}, 
		{-1,  0}, 
		{-1,  1}, 
		{0,  -1}, 
		{0,   1}, 
		{1,  -1}, 
		{1,   0}, 
		{1,   1}
		};

	//0->0 0
	//0->1 2
	//1->0 3
	//0->0 1
    public static void gameOfLife(int[][] board) {
    	int numOfNeighbors, isLiveNow, isLiveBefore;
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		numOfNeighbors = sumNeighbors(i, j, board);
        		isLiveBefore = board[i][j];
        		isLiveNow = isLive(isLiveBefore, numOfNeighbors);
        		board[i][j] = record(isLiveBefore, isLiveNow);
        	}
        }
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		board[i][j] = getNow(board[i][j]);
        	}
        }
        
        return;
    }
    
    private static int record(int isLiveBefore, int isLiveNow) {
    	if(isLiveBefore == 0 && isLiveNow == 1)
    		return 2;
    	else if(isLiveBefore == 1 && isLiveNow == 0)
    		return 3;
    	else 
    		return isLiveNow;
    }
    
    private static int isLive(int isLiveBefore, int numOfNeighbors) {
    	if(isLiveBefore == 0) {
    		if(numOfNeighbors == 3) 
    			return 1;
    		else 
    			return 0;
    	}
    	if(numOfNeighbors < 2 || numOfNeighbors > 3)
    		return 0;
    	else 
    		return 1;
    }
    
    private static int getOriginal(int num) {
    	return num % 2;
    }
    
    private static int getNow(int num) {
    	if(num == 2) {
    		return 1;
    	} else if(num == 3) {
    		return 0;
    	} else {
    		return num;
    	}
    }
    
    private static int sumNeighbors(int i, int j, int[][] board) {
    	int sum = 0, m, n;
    	for(int[] offset : offsetGroup) {
    		m = i + offset[0];
    		n = j + offset[1];
    		if(m>=0 && m<board.length && n>=0 && n<board[0].length) {
    			sum = sum + getOriginal(board[m][n]);
    		}
    	}
    	
    	return sum;
    }
    
}
