package search;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {

	private String name = "46. Permutations";
	private String url = "https://leetcode.com/problems/permutations/";
	
    public List<List<Integer>> permute(int[] nums) {
        
    	List<List<Integer>> prePermutation = List.of(List.of());
    	for(int number : nums) {
    		prePermutation = this.addOneNumber(prePermutation, number);
    	}
    	return prePermutation;
    }
    
    private List<List<Integer>> addOneNumber(List<List<Integer>> prePermutation, int number){
    	
    	if(prePermutation.size() == 0) {
    		return List.of(List.of(number));
    	}
    	List<List<Integer>> newPermutation = new ArrayList<>();
    	for(List<Integer> numberCombination : prePermutation) {   		
    		for(int i = 0; i<=numberCombination.size(); i++) {    			
    			newPermutation.add(this.insertOneNumber(numberCombination, i, number));    			
    		}
    	}
    	
    	return newPermutation;
    }
    
    private List<Integer> insertOneNumber(List<Integer> numberCombination, int index, int number){
    	
    	List<Integer> newNumberCombination = new ArrayList<>(numberCombination.size() + 1);
    	for(int j=0; j<numberCombination.size(); j++) {
    		
    		if(index == j) {
    			newNumberCombination.add(number);
    		}
    		newNumberCombination.add(numberCombination.get(j));
    	}
    	if(index == numberCombination.size()) {
    		newNumberCombination.add(number);
    	}
    	
    	return newNumberCombination;
    }
	
	
}
