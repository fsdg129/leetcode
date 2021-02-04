package dynamicProgramming;

public class MaximalRectangle85 {

	private String name = "85. Maximal Rectangle";
	private String url = "https://leetcode.com/problems/maximal-rectangle/";
	
    public int maximalRectangle(char[][] matrix) {
     
    	if(matrix.length == 0 || matrix[0].length == 0) {
    		return 0;
    	}
    	Point[][] maxRectangle = new Point[matrix.length][matrix[0].length];
    	
    	int maxArea = 0;
    	int rowLength = matrix[0].length;
    	int col, left, right, area;
    	char number;
    	for(int i=0; i<matrix.length; i++) {
    		
    		//Calculate the height for a row
    		for(int j = 0; j < rowLength; j++) {
    			number = matrix[i][j];
    			if(number == '0') {
    				maxRectangle[i][j] = new Point(0);
    				continue;
    			}
    			col = i == 0 ? 1 : maxRectangle[i-1][j].col + 1;
    			maxRectangle[i][j] = new Point(col);
    			
    		}
    		
    		//Calculate the left boundary
    		maxRectangle[i][0].left = -1;
    		for(int j = 1; j < rowLength; j++) {
    			left = j - 1;
    			while(left >= 0 && maxRectangle[i][j].col <= maxRectangle[i][left].col) {
    				left = maxRectangle[i][left].left;
    			}
    			maxRectangle[i][j].left = left;
    		}
    		
    		//Calculate the right boundary
    		maxRectangle[i][rowLength - 1].right = rowLength;
    		for(int j = rowLength - 2; j >= 0; j--) {
    			right = j + 1;
    			while(right < rowLength && maxRectangle[i][j].col <= maxRectangle[i][right].col) {
    				right = maxRectangle[i][right].right;
    			}
    			maxRectangle[i][j].right = right;
    		}
    		
    		for(int j = 0; j < rowLength; j++) {
    			//System.out.println(String.format("%d %d %d", maxRectangle[i][j].left, maxRectangle[i][j].right, maxRectangle[i][j].col));
    			area = (maxRectangle[i][j].right - maxRectangle[i][j].left - 1) * maxRectangle[i][j].col;
    			maxArea = Math.max(maxArea, area);
    		}
    	}
    	
    	
    	return maxArea;
    	
    }
    
    private static class Point {
    	
    	//The number of adjacent 1 in the same row from top left to down right
    	//public int row;
    	
    	//The number of adjacent 1 in the same column from top left to down right
    	public int col;
    	
    	//The x-coordinate of the first point which is on the left of this point 
    	//and whose col is less than this point
    	public int left;
    	
    	//The x-coordinate of the first point which is on the right of this point 
    	//and whose col is less than this point
    	public int right;
    	
    	public Point(int col){
    		super();
    		this.col = col;
    	}
    	
    }
	
}
