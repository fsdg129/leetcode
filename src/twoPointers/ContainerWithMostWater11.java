package twoPointers;

public class ContainerWithMostWater11 {

	private String name = "11. Container With Most Water";
	private String url = "https://leetcode.com/problems/container-with-most-water/";
	
    public int maxArea(int[] height) {
        
    	int first = 0;
    	int last =  height.length - 1;
    	int area = 0;
    	
    	while(last > first) {
    		if(height[first] > height[last]) {    			
    			area = Math.max(area, height[last] * (last - first));
    			last--;
    		} else {
    			area = Math.max(area, height[first] * (last - first));
    			first++;
    		}
    	}
    	
    	return area;
    }
}
