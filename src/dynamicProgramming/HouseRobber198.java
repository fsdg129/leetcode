package dynamicProgramming;

public class HouseRobber198 {

	private String name = "198. House Robber";
	private String url = "https://leetcode.com/problems/house-robber/";
	
    public int rob(int[] nums) {
        
    	if(nums.length == 0) {
    		return 0;
    	}
    	
    	int[] rob = new int[nums.length];
    	rob[0] = nums[0];
    	
    	int[] absent = new int[nums.length];
    	absent[0] = 0;
    	
    	for(int i=1; i<nums.length; i++) {
    		rob[i] = absent[i-1] + nums[i];
    		absent[i] = Math.max(rob[i-1], absent[i-1]);
    	}
    	
    	return Math.max(rob[nums.length - 1], absent[nums.length - 1]);
    	
    }
}
