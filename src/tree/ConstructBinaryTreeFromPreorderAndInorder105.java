package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ConstructBinaryTreeFromPreorderAndInorder105 {

	private String name = "105. Construct Binary Tree from Preorder and Inorder Traversal";
	private String url = "https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/";
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		List<Integer> result;
		result = preorderIterative(root);
		output("preorder iterative", result);
		result = inorderIterative(root);
		output("inorder iterative", result);
		result = postorderIterative(root);
		output("postorder iterative", result);
		
		result = new ArrayList<>();
		result.clear();
		preorderRecursive(root, result);
		output("preorder recursive", result);
		result.clear();
		inorderRecursive(root, result);
		output("inorder recursive", result);
		result.clear();
		postorderRecursive(root, result);
		output("postorder recursive", result);
		
		return;
	}
	
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
    	if(preorder.length <= 0 || preorder.length != inorder.length) {
    		return null;
    	}
    	
    	TreeNode pseudoRoot = new TreeNode(0);
    	buildTreeHelper(pseudoRoot, true, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    	
    	return pseudoRoot.left;
    }
    
    private static void buildTreeHelper(TreeNode parent, boolean isLeft, 
    		int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
    	
    	if(pl > pr)
    		return;
    	
    	int rootValue = preorder[pl];
    	TreeNode root = new TreeNode(rootValue);
    	
    	if(isLeft) {
    		parent.left = root;
    	} else {
    		parent.right = root;
    	}
    	
    	int rootIndex = 0;
    	for(int i = il; i <= ir; i++) {
    		if(inorder[i] == rootValue) {
    			rootIndex = i;
    			break;
    		}
    	}
    	
    	int preSplitIndex = pl + rootIndex - il;
    	
    	buildTreeHelper(root, true, preorder, pl + 1, preSplitIndex, inorder, il, rootIndex - 1);
    	buildTreeHelper(root, false, preorder, preSplitIndex + 1, pr, inorder, rootIndex + 1, ir);
    	
    }
    
    private static void output(String orderType, List<Integer> result) {
    	
    	System.out.println(orderType + ": " + result.toString());
    	
    }
    
    private static void preorderRecursive(TreeNode root, List<Integer> result) {
    	
    	if(root == null)
    		return;
    	
    	result.add(root.val);
    	preorderRecursive(root.left, result);
    	preorderRecursive(root.right, result);
    	
    	return;
    }
    
    private static List<Integer> preorderIterative(TreeNode root) {
    	
    	if(root == null)
    		return List.of();
    	
    	List<Integer> result = new ArrayList<>();
    	Deque<TreeNode> stack = new LinkedList<>();
    	stack.push(root);
    	
    	TreeNode current;
    	while(!stack.isEmpty()) {
    		current = stack.pop();
    		result.add(current.val);
    		
    		if(current.right != null)
    			stack.push(current.right);
    		if(current.left != null)
    			stack.push(current.left);

    	}
    	
    	return result;
    }
    
    private static void inorderRecursive(TreeNode root, List<Integer> result) {
    	
    	if(root == null)
    		return;
    	   	
    	inorderRecursive(root.left, result);
    	result.add(root.val);
    	inorderRecursive(root.right, result);
    	
    	return;
    }
    
    private static List<Integer> inorderIterative(TreeNode root) {
    	
    	if(root == null)
    		return List.of();
    	
    	List<Integer> result = new ArrayList<>();
    	Deque<MarkedTreeNode> stack = new LinkedList<>();
    	stack.push(new MarkedTreeNode(root));
    	
    	MarkedTreeNode current;
    	while(!stack.isEmpty()) {
    		
    		current = stack.pop();  
    		if(current.marked) {
    			result.add(current.node.val);
    			continue;
    		}
		
    		current.marked = true;    		
    		if(current.node.right != null)
    			stack.push(new MarkedTreeNode(current.node.right));
    		stack.push(current);
    		if(current.node.left != null)
    			stack.push(new MarkedTreeNode(current.node.left));

    	}
    	
    	return result;
    }
    
    private static void postorderRecursive(TreeNode root, List<Integer> result) {
    	
    	if(root == null)
    		return;
    	   	
    	postorderRecursive(root.left, result);    	
    	postorderRecursive(root.right, result);
    	result.add(root.val);
    	
    	return;
    }
    
    private static List<Integer> postorderIterative(TreeNode root) {
    	
    	if(root == null)
    		return List.of();
    	
    	List<Integer> result = new ArrayList<>();
    	Deque<MarkedTreeNode> stack = new LinkedList<>();
    	stack.push(new MarkedTreeNode(root));
    	
    	MarkedTreeNode current;
    	while(!stack.isEmpty()) {
    		
    		current = stack.pop();  
    		if(current.marked) {
    			result.add(current.node.val);
    			continue;
    		}
		
    		current.marked = true; 
    		stack.push(current);
    		if(current.node.right != null)
    			stack.push(new MarkedTreeNode(current.node.right));
    		if(current.node.left != null)
    			stack.push(new MarkedTreeNode(current.node.left));
    		

    	}
    	
    	return result;
    }
    
    
    
    private static class MarkedTreeNode {
    	
    	public TreeNode node;
    	public boolean marked = false;
    	
    	public MarkedTreeNode(TreeNode node) {
    		this.node = node;
    	}
    }
}
