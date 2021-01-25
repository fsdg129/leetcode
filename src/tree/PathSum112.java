package tree;

public class PathSum112 {

	private String name = "112. Path Sum";
	private String url = "https://leetcode.com/problems/path-sum/";
	
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
    	if(root == null) {
    		return false;
    	}
    	
    	return this.hasPathSumHelper(root, targetSum);
    	
    }
    
    private boolean hasPathSumHelper(TreeNode root, int targetSum) {
    	
    	if(root.left == null && root.right == null) {
    		if(targetSum == root.val) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	
    	int remaining = targetSum - root.val;
    	if(root.left != null && this.hasPathSum(root.left, remaining)) {
    		return true;
    	} else if(root.right != null && this.hasPathSum(root.right, remaining)) {
    		return true;
    	} else {
    		return false;
    	}
    	
    }
	
}
