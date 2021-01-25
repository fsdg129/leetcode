package divideAndConquer;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

	private String name = "169. Majority Element";
	private String url = "https://leetcode.com/problems/majority-element/";
	
    public int majorityElement(int[] nums) {
        
    	Map<Integer, Integer> counter = new HashMap<>();
    	
    	int threshold = nums.length / 2;
    	
    	int times;
    	for(int value : nums) {
    		times = counter.merge(value, 1, Math::addExact);
    		if(times > threshold) {
    			return value;
    		}
    	}
    	
    	return nums[0];
    }
}
