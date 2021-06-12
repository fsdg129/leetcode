package search;

public class ThreeSumClosest16 {

	private String name = "16. 3Sum Closest";
	private String url = "https://leetcode.com/problems/3sum-closest/";
	
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3)
        	return 0;
        Record record = new Record(target);
        sumHelper(0, 0, 0, nums, record);
        
        return record.closetSum;
    }
    
    private void sumHelper(int index, int counter, int sum, int[] nums, Record record) {
    	if(counter == 3) {
    		record.checkCloset(sum);
    		return;
    	}
    	if(index >= nums.length)
    		return;
    	sumHelper(index + 1, counter, sum, nums, record);
    	sumHelper(index + 1, counter + 1, sum + nums[index], nums, record);
    	
    	return;
    }
    
    private static class Record {
    	public int target;
    	public int closetSum;
    	
    	public Record(int target) {
    		super();
    		this.target = target;
    	}
    	
    	public void checkCloset(int sum) {
    		if(Math.abs(sum - target) < Math.abs(this.closetSum - target))
    			this.closetSum = sum;
    	}
    }
}
