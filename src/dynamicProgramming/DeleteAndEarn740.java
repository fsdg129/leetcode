package dynamicProgramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeleteAndEarn740 {

	private String name = "740. Delete and Earn";
	private String url = "https://leetcode.com/problems/delete-and-earn/";
	
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
        
        int avoid = 0, earn = 0, originalAvoid, pre = -1;
        for(Integer i : sortedNums) {
        	if(pre == -1) {
        		pre = i;
                earn = counter.get(i) * i;
                continue;
        	}
            originalAvoid = avoid;
            avoid = Math.max(avoid, earn);
        	if(i - pre != 1) {
        		earn = avoid + counter.get(i) * i;
        	} else {
                earn = originalAvoid + counter.get(i) * i;
            }
            pre = i;
        }

        
        return Math.max(earn, avoid);

    }
    
}
