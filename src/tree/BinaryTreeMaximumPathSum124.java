package tree;

public class BinaryTreeMaximumPathSum124 {

	private String name = "124. Binary Tree Maximum Path Sum";
	private String url = "https://leetcode.com/problems/binary-tree-maximum-path-sum/";
	
    public static int maxPathSum(TreeNode root) {
        
    	return maxPathSumHelper(root).maxPathSum;
    }
    
    private static Record maxPathSumHelper(TreeNode root) {
    	if(root == null)
    		return new Record(Integer.MIN_VALUE, Integer.MIN_VALUE);
    	
    	Record leftRecord = maxPathSumHelper(root.left);
    	Record rightRecord = maxPathSumHelper(root.right);
    	
    	int maxPathSum = root.val;
    	if(leftRecord.maxSinglePathSum > 0)
    		maxPathSum += leftRecord.maxSinglePathSum;
    	if(rightRecord.maxSinglePathSum > 0)
    		maxPathSum += rightRecord.maxSinglePathSum;
    	
    	maxPathSum = Math.max(maxPathSum, Math.max(leftRecord.maxPathSum, rightRecord.maxPathSum));
    	
    	int maxSinglePathSum = Math.max(0, Math.max(leftRecord.maxSinglePathSum, rightRecord.maxSinglePathSum));
    	maxSinglePathSum += root.val;
    	
        return new Record(maxPathSum, maxSinglePathSum);
    }
    
    private static class Record {
    	public int maxPathSum;
    	public int maxSinglePathSum;
    	
		/**
		 * @param maxPathSum
		 * @param maxSinglePathSum
		 */
		public Record(int maxPathSum, int maxSinglePathSum) {
			super();
			this.maxPathSum = maxPathSum;
			this.maxSinglePathSum = maxSinglePathSum;
		}

    }
    
    public static int maxPathSumArray(TreeNode root) {
        
    	return maxPathSumHelperArray(root)[0];
    }
    
    private static int[] maxPathSumHelperArray(TreeNode root) {
    	if(root == null)
    		return new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
    	
    	int[] leftRecord = maxPathSumHelperArray(root.left);
    	int[] rightRecord = maxPathSumHelperArray(root.right);
    	
    	int maxPathSum = root.val;
    	if(leftRecord[1] > 0)
    		maxPathSum += leftRecord[1];
    	if(rightRecord[1] > 0)
    		maxPathSum += rightRecord[1];
    	
    	maxPathSum = Math.max(maxPathSum, Math.max(leftRecord[0], rightRecord[0]));
    	
    	int maxSinglePathSum = Math.max(0, Math.max(leftRecord[1], rightRecord[1]));
    	maxSinglePathSum += root.val;
    	
        return new int[] {maxPathSum, maxSinglePathSum};
    }
}
