package tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor236 {
	
	private String name = "236. Lowest Common Ancestor of a Binary Tree";
	private String url = "https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/";
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    	if(root == null) {
    		return null;
    	}
    	
    	Map<TreeNode, TreeNode> parentMapper = new HashMap<>();
    	Deque<TreeNode> stack = new LinkedList<>();
    	
    	stack.push(root);
    	TreeNode currentNode;
    	while(!stack.isEmpty()) {
    		currentNode = stack.pop();
    		if(currentNode.left != null) {
    			parentMapper.put(currentNode.left, currentNode);
    			stack.push(currentNode.left);
    		}
    		if(currentNode.right != null) {
    			parentMapper.put(currentNode.right, currentNode);
    			stack.push(currentNode.right);
    		}
    		if(parentMapper.containsKey(p) && parentMapper.containsKey(q)) {
    			break;
    		}
    	}
    	
    	Set<TreeNode> setOfP = new HashSet<>();
    	currentNode = p;
    	while(currentNode != null) {
    		setOfP.add(currentNode);
    		currentNode = parentMapper.get(currentNode);
    	}
    	
    	currentNode = q;
    	while(currentNode != null) {
    		if(setOfP.contains(currentNode)) {
    			return currentNode;
    		}
    		currentNode = parentMapper.get(currentNode);
    	}
    	
    	return null;
    	
    }
}
