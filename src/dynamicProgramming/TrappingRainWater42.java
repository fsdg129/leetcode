package dynamicProgramming;

public class TrappingRainWater42 {

	private String name = "42. Trapping Rain Water";
	private String url = "https://leetcode.com/problems/trapping-rain-water/";
	
    public int trap(int[] height) {
        
    	if(height.length <= 0) {
    		return 0;
    	}
    	
    	int[] leftMax = new int[height.length];
    	leftMax[0] = -1;
    	for(int i=1; i<leftMax.length; i++) {
    		leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
    	}
    	
    	int[] rightMax = new int[height.length];
    	rightMax[rightMax.length - 1] = -1;
    	for(int i=rightMax.length - 2; i>=0; i--) {
    		rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
    	}
    	
    	int minHeight;
    	int water = 0;
    	for(int i=1; i<height.length-1; i++) {
    		minHeight = Math.min(leftMax[i], rightMax[i]);
    		water += Math.max(0, minHeight - height[i]);
    	}
    	
    	return water;
    }
    
}
