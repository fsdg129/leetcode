package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

public class LongestIncreasingSubsequence300 {

	private String name = "300. Longest Increasing Subsequence";
	private String url = "https://leetcode.com/problems/longest-increasing-subsequence/";
	
    public int lengthOfLIS(int[] nums) {
        
    	if(nums.length < 1)
    		return 0;
    	
    	ArrayList<Integer> smallNums = new ArrayList<>();
    	smallNums.add(nums[0]);
    	int value, insertIndex;
    	for(int i=1; i<nums.length; i++) {
    		value = nums[i];
    		if(value > smallNums.get(smallNums.size() - 1).intValue()) {
    			smallNums.add(value);
    		} else {
    			insertIndex = Collections.binarySearch(smallNums, value);
    			if(insertIndex < 0) {
    				insertIndex = -insertIndex - 1;
    				smallNums.set(insertIndex, value);
    			}
    		}
    	}
    	
    	return smallNums.size();
    }
	
	
}
