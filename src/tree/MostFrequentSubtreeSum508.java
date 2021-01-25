package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MostFrequentSubtreeSum508 {
	
	private String name = "508. Most Frequent Subtree Sum";
	private String url = "https://leetcode.com/problems/most-frequent-subtree-sum/";
	
	private Map<Integer, Integer> sumTimes;
	
    public int[] findFrequentTreeSum(TreeNode root) {
        
    	if(root == null) {
    		int[] sumArray = new int[0];
    		return sumArray;
    	}
    	
    	this.sumTimes = new HashMap<>();
    	this.sumTree(root);
    	
    	List<Integer> maxSum = new ArrayList<>();
    	int maxTimes = 0;
    	for(Map.Entry<Integer, Integer> entry : this.sumTimes.entrySet()) {
    		if(entry.getValue() > maxTimes) {
    			maxTimes = entry.getValue();
    			maxSum.clear();
    			maxSum.add(entry.getKey());
    		} else if(entry.getValue() == maxTimes) {
    			maxSum.add(entry.getKey());
    		} else {
    			;
    		}
    	}
    	
    	return maxSum.stream().mapToInt(n -> n.intValue()).toArray();
    	
    	
    	
    }
    
    private int sumTree(TreeNode root) {
    	
    	int left = root.left == null ? 0 : this.sumTree(root.left);
    	int right = root.right == null ? 0 : this.sumTree(root.right);
    	
    	int sum = left + root.val + right;
    	this.sumTimes.merge(sum, 1, Math::addExact);
    	return sum;
    	
    }
}
