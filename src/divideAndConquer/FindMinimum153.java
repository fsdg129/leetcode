package divideAndConquer;

public class FindMinimum153 {

	private String name = "153. Find Minimum in Rotated Sorted Array";
	private String url = "https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/";
	
    public int findMin(int[] nums) {
        
    	if(nums.length == 1) {
    		return nums[0];
    	}
    	
    	int startIndex = 0;
    	int endIndex = nums.length-1;
    	if(nums[startIndex] < nums[endIndex]) {
    		return nums[0];
    	}
    	
    	while(true) {
    		if(endIndex - startIndex == 1 && nums[startIndex] > nums[endIndex] ) {
    			return nums[endIndex];
    		}
    		
    		int mid = (startIndex + endIndex) / 2;
    		
    		if(nums[mid] > nums[endIndex] ) {
    			startIndex = mid;
    		} else {
    			endIndex = mid;
    		}
    		
    	}
    }
}
