package array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeleteAndEarn740 {

	private String name = "289. Game of Life";
	private String url = "https://leetcode.com/problems/game-of-life/";
	
    public int deleteAndEarn(int[] nums) {
    	
    	if(nums.length == 0)
    		return 0;
    	
        Map<Integer, Integer> counter = new HashMap<>();
        
        int times;
        for(int num : nums) {
        	times = counter.getOrDefault(num, 0);
        	times++;
        	counter.put(num, times);
        }
        
        List<Integer> sortedNums = counter.keySet().stream().sorted().collect(Collectors.toList());
        
        int start = -1, earn = 0;
        int pre = 0;
        for(Integer i : sortedNums) {
        	if(start == -1) {
        		start = i;
        		pre = start;
        		continue;
        	}
        	if(i.intValue() - pre == 1) {
        		pre = i;
        		continue;
        	}
        	earn += maxInPartition(start, pre, counter);
        	start = i;
        }
        earn += maxInPartition(start, pre, counter);
        
        return earn;
    }
    
    private int maxInPartition(int start, int end, Map<Integer, Integer> counter) {
    	
    	if(start == end)
    		return counter.get(start);
    	
    	int maxOdd = 0;
    	for(int i=start; i<=end; i=i+2) {
    		maxOdd += counter.get(i);
    	}
    	int maxEven = 0;
    	for(int i=start + 1; i<=end; i=i+2) {
    		maxEven += counter.get(i);
    	}
    	
    	return Math.max(maxOdd, maxEven);
    }
}
