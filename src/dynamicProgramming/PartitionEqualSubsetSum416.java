package dynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum416 {

	private String name = "416. Partition Equal Subset Sum";
	private String url = "https://leetcode.com/problems/partition-equal-subset-sum/";
	
    public boolean canPartition(int[] nums) {
    	
    	if(nums.length == 0) {
    		return true;
    	}    	
    	int sum = Arrays.stream(nums).sum();    	
    	if(sum % 2 != 0) {
    		return false;
    	}
    	
    	int target = sum / 2;    	
    	//Use 1, 2, ..., j numbers, could we fill a buscket of with target weight?
    	//Every number could be used 0 or 1 time
        boolean[][] isFull = new boolean[nums.length + 1][target + 1];
        for(int i = 0; i <= nums.length; i++) {
        	for(int j = 0; j <= target; j++) {
        		if(j == 0) {
        			isFull[i][j] = true;
        		} else if(i == 0) {
        			isFull[i][j] = false;
        		} else {
        			if(nums[i - 1] > j) {
        				isFull[i][j] = isFull[i - 1][j];
        			} else {
        				isFull[i][j] = isFull[i - 1][j] || isFull[i - 1][j - nums[i - 1]];
        			}
        		}
        	}
        }
        
        
        return isFull[nums.length][target];
    }
	
	
    public boolean canPartitionDFS(int[] nums) {
        
    	if(nums.length == 0) {
    		return true;
    	}
    	
    	int sum = Arrays.stream(nums).sum();
    	if(sum % 2 != 0) {
    		return false;
    	}
    	
    	Set<PartitionRecord> failureResult = new HashSet<>();
    	
    	return partitionHelper(0, 0, nums, sum / 2, failureResult);
    	
    	
    }
    
    private static boolean partitionHelper(int index, int currentSum, 
    		int[] nums, int sum, Set<PartitionRecord> failureResult) {
    	
    	if(currentSum == sum) {
    		return true;
    	}
    	
    	PartitionRecord record = new PartitionRecord(currentSum, index);
    	if(index >= nums.length) {
    		failureResult.add(record);
    		return false;
    	}
    	
    	if(failureResult.contains(record)) {
    		return false;
    	}
    	
    	return partitionHelper(index + 1, currentSum, nums, sum, failureResult) ||
    	partitionHelper(index + 1, currentSum + nums[index], nums, sum, failureResult);
    	
    }
    
    private static class PartitionRecord {
    	
    	public int currentSum;    	
    	public int index;
    	
    	public PartitionRecord(int currentSum, int index) {
    		this.currentSum = currentSum;
    		this.index = index;
    	}
    	
    	@Override
    	public boolean equals(Object obj) {
    		if(this == obj)
    			return true;
    		if(obj == null)
    			return false;
    		if(this.getClass() != obj.getClass())
    			return false;
    		PartitionRecord record = (PartitionRecord) obj;
    		if(this.currentSum != record.currentSum)
    			return false;
    		if(this.index != record.index)
    			return false;
    		return true;
    	}
    	
    	@Override
    	public int hashCode() {
    		
    		final int prime = 31;
    		int result = 1;
    		result = result * prime + this.currentSum;
    		result = result * prime + this.index;
    		
    		return result;
    	}
    	
    }
}
