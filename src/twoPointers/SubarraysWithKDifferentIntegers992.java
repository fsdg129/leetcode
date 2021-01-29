package twoPointers;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers992 {

	private String name = "992. Subarrays with K Different Integers";
	private String url = "https://leetcode.com/problems/subarrays-with-k-different-integers/";
	
    public int subarraysWithKDistinct(int[] A, int K) {
    	
        Map<Integer, Integer> numberCounts = new HashMap<>();
        int goodSubarray = 0;
        
        int left = 0;
        int right = -1;
        int newNumber;
        
        while(true) {
        	
        	if(numberCounts.size() < K) {
        		right++;
        		if(right > A.length - 1) {
        			break;
        		}
        		newNumber = A[right];
        		numberCounts.merge(newNumber, 1, Integer::sum);
        	} else {
        		goodSubarray++;
        		left++;
        		newNumber = A[left - 1];
        		numberCounts.compute(newNumber, (k,v) -> {
        			if(v.intValue() > 1) {
        				return Integer.sum(v, -1);
        			} else {
        				return null;
        			}
        		});
        		
        	}
        	
        }
        
        return goodSubarray;
    	
    }
	
	
}
