package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {

	private String name = "102. Binary Tree Level Order Traversal";
	private String url = "https://leetcode.com/problems/binary-tree-level-order-traversal/";
	
    public List<List<Integer>> levelOrder(TreeNode root) {
        
    	List<List<Integer>> result = new ArrayList<>();
    	
    	if(root != null) {
    		Queue<TreeNode> currentLevel = new LinkedList<>();
    		currentLevel.add(root);
    		while(!currentLevel.isEmpty()) {
    			currentLevel = this.processEachLevel(currentLevel, result);
    		}   		
    	}
    	
    	return result;    	
    }
    
    private Queue<TreeNode> processEachLevel(Queue<TreeNode> currentLevel, List<List<Integer>> result) {
        
    	Queue<TreeNode> nextLevel = new LinkedList<>();
    	List<Integer> levelResult = new ArrayList<>();
    	
    	TreeNode currentNode;
    	while(!currentLevel.isEmpty()) {
    		currentNode = currentLevel.remove();
    		levelResult.add(currentNode.val);
    		if(currentNode.left != null) {
    			nextLevel.add(currentNode.left);
    		}
    		if(currentNode.right != null) {
    			nextLevel.add(currentNode.right);
    		}
    	}
    	
    	result.add(levelResult);
    	
    	return nextLevel;
    }
    
    public List<List<Integer>> levelOrderIterate(TreeNode root) {
        
    	List<List<Integer>> result = new ArrayList<>();
    	
    	if(root != null) {
    		Queue<TreeNode> currentLevel = new LinkedList<>();
    		currentLevel.add(root);
    		while(!currentLevel.isEmpty()) {
    			List<Integer> levelResult = new ArrayList<>();
    			int size = currentLevel.size();
    			
    	    	TreeNode currentNode;
    	    	int i = 0;
    	    	while(i<size) {
    	    		currentNode = currentLevel.remove();
    	    		levelResult.add(currentNode.val);
    	    		if(currentNode.left != null) {
    	    			currentLevel.add(currentNode.left);
    	    		}
    	    		if(currentNode.right != null) {
    	    			currentLevel.add(currentNode.right);
    	    		}
    	    		i++;
    	    	}
    	    	result.add(levelResult);
    		}   		
    	}
    	
    	return result;    	
    }
}
