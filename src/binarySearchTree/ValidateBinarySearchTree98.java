package binarySearchTree;

public class ValidateBinarySearchTree98 {

	private String name = "98. Validate Binary Search Tree";
	private String url = "https://leetcode.com/problems/validate-binary-search-tree/";
	
	public static boolean isValidBST(TreeNode root) {
        
		if(root == null)
			return true;
		int[] result = validate(root);
		
		return result[0] == 1;
    }

	private static int[] validate(TreeNode root) {
		
		boolean hasLeft = true, hasRight = true;
		int leftMax=root.val, rightMin=root.val;
		int leftMin=root.val, rightMax=root.val;
		
		if(root.left == null)
			hasLeft = false;
		else {
			int[] left = validate(root.left);
			if(left[0] == 0) {
				return new int[] {0, 0, 0};
			}
			leftMax = left[2];
			leftMin = left[1];
		}
		
		if(root.right == null)
			hasRight = false;
		else {
			int[] right = validate(root.right);
			if(right[0] == 0) {
				return new int[] {0, 0, 0};
			}
			rightMin = right[1];
			rightMax = right[2];
		}
		
		if(hasLeft && root.val <= leftMax)
			return new int[] {0, 0, 0};
		if(hasRight && root.val >= rightMin)
			return new int[] {0, 0, 0};
		
		return new int[] {1, leftMin, rightMax};
		
	}
}
