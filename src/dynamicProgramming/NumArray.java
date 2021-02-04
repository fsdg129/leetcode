package dynamicProgramming;

class NumArray {

	private String name = "303. Range Sum Query - Immutable";
	private String url = "https://leetcode.com/problems/range-sum-query-immutable/";
	
	private int[] sumResult;
	
    public NumArray(int[] nums) {
        this.sumResult = new int[nums.length];
        if(nums.length == 0) {
        	return;
        }
        this.sumResult[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
        	this.sumResult[i] = this.sumResult[i-1] + nums[i];
        }   
    }
    
    public int sumRange(int i, int j) {
    	if(i == 0) {
    		return this.sumResult[j];
    	}
        return this.sumResult[j] - this.sumResult[i - 1];
    }
}
