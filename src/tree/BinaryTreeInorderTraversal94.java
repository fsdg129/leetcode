package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {

	private String name = "94. Binary Tree Inorder Traversal";
	private String url = "https://leetcode.com/problems/binary-tree-inorder-traversal/";
	
    public List<Integer> inorderTraversal(TreeNode root) {
        
    	List<Integer> result = new ArrayList<>();
    	this.traverse(root, result);
    	
    	return result;
    }
    
    private void traverse(TreeNode root, List<Integer> list) {
    	
    	if(root == null) {
    		return;
    	}
    	this.traverse(root.left, list);
    	
    	list.add(root.val);
    	
    	this.traverse(root.right, list);
    	
    }
    
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        
    	List<Integer> result = new ArrayList<>();
    	Deque<TreeNode> stack = new LinkedList<>();
    	TreeNode current = root;
    	while(current != null || !stack.isEmpty() ) {
    		
    		while(current != null) {
    			stack.push(current);
    			current = current.left;
    		}
    		current = stack.poll();
    		result.add(current.val);
    		current = current.right;
    	}
    	
    	return result;
    }
}
