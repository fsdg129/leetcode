package dynamicProgramming;

public class LargestRectangleInHistogram84 {

	private String name = "84. Largest Rectangle in Histogram";
	private String url = "https://leetcode.com/problems/largest-rectangle-in-histogram/";
	
    public int largestRectangleArea(int[] heights) {
        
    	int[] leftBound = new int[heights.length];
    	leftBound[0] = -1;
    	
    	int left;
    	for(int i=1; i<heights.length; i++) {
    		left = i-1;
    		while(left >= 0) {
    			if(heights[i] > heights[left]) {	
    				break;
    			} else {
    				left = leftBound[left];
    			}
    		}
    		leftBound[i] = left;
    	}
    	
    	int[] rightBound = new int[heights.length];
    	rightBound[heights.length - 1] = heights.length;
    	
    	int right;
    	for(int i=heights.length - 2; i >= 0; i--) {
    		right = i+1;
    		while(right < heights.length) {
    			if(heights[i] > heights[right]) {
    				break;
    			} else {
    				right = rightBound[right];
    			}
    		}
    		rightBound[i] = right;
    	}
    	
    	int maxArea = 0;
    	int area;
    	for(int i=0; i<heights.length; i++) {
    		
    		area = (rightBound[i] - leftBound[i] - 1) * heights[i];
    		maxArea = Math.max(maxArea, area);
    	}
    	
    	return maxArea;	
    }
}
