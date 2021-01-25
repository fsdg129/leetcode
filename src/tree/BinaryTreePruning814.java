package tree;

public class BinaryTreePruning814 {
	
	private String name = "814. Binary Tree Pruning";
	private String url = "https://leetcode.com/problems/binary-tree-pruning/";
	
    public TreeNode pruneTree(TreeNode root) {
        
    	if(root == null) {
    		return null;
    	}
    	
    	root.left = this.pruneTree(root.left);
    	root.right = this.pruneTree(root.right);
    	
    	if(root.val == 0 && root.left == null && root.right == null) {
    		return null;
    	} else {
    		return root;
    	}
    	
    }
}
