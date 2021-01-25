package tree;

public class SameTree100 {

	private String name = "100. Same Tree";
	private String url = "https://leetcode.com/problems/same-tree/";
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
    	if(p == null ) {
    		if(q == null) {
    			return true;
    		} else {
    			return false;
    		}    		
    	}
    	if(q == null) {
    		return false;
    	}
    	if(p.val == q.val) {   		
    		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    	} else {
    		return false;
    	}
    	
    }
}
