package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree637 {

	private String name = "637. Average of Levels in Binary Tree";
	private String url = "https://leetcode.com/problems/average-of-levels-in-binary-tree/";
	
    public List<Double> averageOfLevels(TreeNode root) {
        
    	if(root == null) {
    		return List.of(0.0);
    	}
    	
    	List<Double> result = new ArrayList<>();
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	
    	long sum;
    	int numberOfNodes;
    	TreeNode current;
    	while(!queue.isEmpty()) {
    		numberOfNodes = queue.size();
    		sum = 0;
    		for(int i=0; i<numberOfNodes; i++) {
    			current = queue.poll();
    			sum += current.val;
    			if(current.left != null) {
    				queue.add(current.left);
    			}
    			if(current.right != null) {
    				queue.add(current.right);
    			}    			
    		}
    		result.add((double) sum / numberOfNodes);
    	}
    	
    	return result;
    }
}
