package tree;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers129 {
	
	private String name = "129. Sum Root to Leaf Numbers";
	private String url = "https://leetcode.com/problems/sum-root-to-leaf-numbers/";
	
    public int sumNumbers(TreeNode root) {
        
    	if(root == null) {
    		return 0;
    	}
    	
    	List<Integer> numberList = new ArrayList<>();
    	this.sumNumbersHelper(root, 0, numberList);
    	return numberList.stream().reduce(0, Integer::sum);
    	
    }
    
    private void sumNumbersHelper(TreeNode root, int number, List<Integer> numberList) {
    	
    	int sum = 10*number + root.val;
    	if(root.left == null && root.right == null) {
    		numberList.add(sum);
    		return;
    	}
    	
    	if(root.left != null) {
    		this.sumNumbersHelper(root.left, sum, numberList);
    	} 
    	if(root.right != null) {
    		this.sumNumbersHelper(root.right, sum, numberList);
    	} 
    	
    	return;
    	
    }
    
    public int sumNumbers2(TreeNode root) {
        
    	if(root == null) {
    		return 0;
    	}
    	
    	Accumulator sum = new Accumulator();
    	this.sumNumbersHelper2(root, 0, sum);
    	return sum.sum;
    	
    }
    
    private void sumNumbersHelper2(TreeNode root, int number, Accumulator sum) {
    	
    	int newNumber = 10*number + root.val;
    	if(root.left == null && root.right == null) {
    		sum.sum += newNumber;
    		return;
    	}
    	
    	if(root.left != null) {
    		this.sumNumbersHelper2(root.left, newNumber, sum);
    	} 
    	if(root.right != null) {
    		this.sumNumbersHelper2(root.right, newNumber, sum);
    	} 
    	
    	return;
    	
    }
    
    private class Accumulator {
    	
    	public int sum = 0;
    }
}
