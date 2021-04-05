package binarySearchTree;

public class RecoverBinarySearchTree99 {

	private String name = "99. Recover Binary Search Tree";
	private String url = "https://leetcode.com/problems/recover-binary-search-tree/";
	
    public void recoverTree(TreeNode root) {
        
    	Record r = new Record();
    	validate(root, r);
    	swap(r.faultNode1, r.faultNode2);
    	
    	return;
    }
    
    private static void validate(TreeNode root, Record r) {
    	
    	if(r.isFinished)
    		return;
    	
    	if(root == null)
    		return;
    	
    	validate(root.left, r);
    	if(r.isFinished)
    		return;
    	
    	if(r.current != null && r.current.val > root.val) {
    		r.check(root);
    	} 
		r.current = root;
    	
    	validate(root.right, r);    
    	
    	return;
    }    
    
    private static void swap(TreeNode a, TreeNode b) {
    	
    	int tmp = a.val;
    	a.val = b.val;
    	b.val = tmp;
    	
    	return;
    }
    
    private static class Record {
    	
    	public TreeNode faultNode1;
    	public TreeNode faultNode2;
    	public boolean isFinished = false;
    	
    	public TreeNode current = null;
    	
    	public void check(TreeNode root) {
    		faultNode2 = root;
    		if(faultNode1 == null) {
    			faultNode1 = current;    			
    		} else {
    			isFinished = true;
    		}
    	}
    	
    }
}
