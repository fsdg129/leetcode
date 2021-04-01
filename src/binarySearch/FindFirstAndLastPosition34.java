package binarySearch;

public class FindFirstAndLastPosition34 {

	private String name = "34. Find First and Last Position of Element in Sorted Array";
	private String url = "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/";
	
    public int[] searchRange(int[] nums, int target) {
        int leftBound = leftBound(nums, target);
        if(leftBound == -1) {
        	return new int[] { -1, -1 };
        }
        int rightBound = rightBound(nums, target);
        return new int[] { leftBound, rightBound };
    }
    
    public static int leftBound(int[] nums, int target) {
    	
    	int left = 0;
    	int right = nums.length - 1;
    	int mid;
    	
    	while(left <= right) {
    		mid = left + (right - left) / 2;
    		if(nums[mid] == target) {
    			if(right == left)
    				return mid;
    			right = mid;
    		} else if(nums[mid] < target) {
    			left = mid + 1;
    		} else {
    			right = mid - 1;
    		}
    	}
    	return -1;
    }
    
    public static int rightBound(int[] nums, int target) {
    	
    	int left = 0;
    	int right = nums.length - 1;
    	int mid;
    	
    	while(left <= right) {
    		mid = left + (right - left + 1) / 2;
    		if(nums[mid] == target) {
    			if(right == left)
    				return mid;
    			left = mid;
    		} else if(nums[mid] < target) {
    			left = mid + 1;
    		} else {
    			right = mid - 1;
    		}
    	}
    	
    	return -1;

    }
	
}
