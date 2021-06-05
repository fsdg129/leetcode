package array;

public class RotateImage48 {

	private String name = "48. Rotate Image";
	private String url = "https://leetcode.com/problems/rotate-image/";
	
    public void rotate(int[][] matrix) {
        int leftBound = 0;
        int rightBound = matrix.length - 1;
        int line = 0;
        
        Point p = new Point();
        int currentNumber, targetNumber;
        while(rightBound > leftBound) {
        	for(int i=leftBound; i<rightBound; i++) {
        		p.setPointIndex(line, i);
        		currentNumber = getValue(p, matrix);
        		for(int j=0; j<4; j++) {
	        		rotateIndex(p, matrix.length);
	        		targetNumber = getValue(p, matrix);
	        		setValue(currentNumber, p, matrix);
	        		currentNumber = targetNumber;
        		}        		
        	}
        	leftBound++;
        	rightBound--;
        	line++;
        }
        
        return;
    }
    
    private static int getValue(Point p, int[][] matrix) {
    	return matrix[p.row][p.col];
    }
    
    private static void setValue(int value, Point p, int[][] matrix) {
    	matrix[p.row][p.col] = value;
    	return;
    }
    
    private static class Point {
    	public int row;
    	public int col;
    	
    	public void setPointIndex(int row, int col) {
    		this.row = row;
    		this.col = col;
    	}
    }
    
    private void rotateIndex(Point p, int length) {
    	int newRow = length - p.col;
    	int newCol = p.row;
    	p.setPointIndex(newRow, newCol);
    }
}
