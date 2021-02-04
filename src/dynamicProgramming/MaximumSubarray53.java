package dynamicProgramming;

import java.util.Arrays;

public class MaximumSubarray53 {

	private String name = "53. Maximum Subarray";
	private String url = "https://leetcode.com/problems/maximum-subarray/";
	
    public int maxSubArray(int[] nums) {
        
    	if(nums.length == 0) {
    		return nums[0];
    	}
    	
    	int[] maxSubArray = new int[nums.length];
    	maxSubArray[0] = nums[0];
    	
    	for(int i=1; i<nums.length; i++) {
    		maxSubArray[i] = maxSubArray[i-1] > 0 ? maxSubArray[i-1] + nums[i] : nums[i];
    	}
    	
    	return Arrays.stream(maxSubArray).max().getAsInt();
    }
    
    public int maxSubArray2(int[] nums) {
        
    	if(nums.length == 0) {
    		return nums[0];
    	}
    	
    	int currentSum = nums[0];
    	int maxSum = currentSum;
    	
    	for(int i=1; i<nums.length; i++) {
    		currentSum = currentSum > 0 ? currentSum + nums[i] : nums[i];
    		maxSum = Math.max(maxSum, currentSum);
    	}
    	
    	return maxSum;
    }
}
