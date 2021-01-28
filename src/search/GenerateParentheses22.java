package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParentheses22 {

	private String name = "22. Generate Parentheses";
	private String url = "https://leetcode.com/problems/generate-parentheses/";
	
	// if n = 4, there are four positions to insert ) (_(_(_(_ 
	//In the ith position, we could insert at most i )
	//BFS
    public List<String> generateParenthesis(int n) {
        
    	if(n == 1) {
    		return List.of("()");
    	}
    	
    	LinkedList<List<Integer>> positions = new LinkedList<>();
    	for(int index=1; index<n; index++) {
    		generatePositions(index, positions);
    	}
    	
    	return positions.stream()
    			.map(position -> {
    				int sum = sumList(position);
    				position.add(n - sum);
    				return position;
    			})
    			.map(position -> stringGenerator(position))
    			.collect(Collectors.toList());
    }
    
    private static void generatePositions(int index, LinkedList<List<Integer>> positions) {
    	
    	if(index == 1) {
    		positions.add(new LinkedList<>(List.of(0)));
    		positions.add(new LinkedList<>(List.of(1)));
    		
    		return;
    	}
    	
    	int size = positions.size();
    	List<Integer> position;
    	LinkedList<Integer> newPosition;
    	for(int j=0; j<size; j++) {
    		position = positions.removeLast();
    		int sum = sumList(position);    		
    		for(int k=0; k<=index-sum; k++) {
    			newPosition = new LinkedList<>(position);
    			newPosition.add(k);
    			positions.addFirst(newPosition);
    		};    		
    	}
    	
    	return;
    }
    
    private static String stringGenerator(List<Integer> position) {
    	
    	StringBuilder sb = new StringBuilder();
    	for(Integer number : position) {
    		sb.append("(" + ")".repeat(number));
    	}
    	
    	return sb.toString();
    }
    
    public List<String> generateParenthesisDFS(int n) {
        
    	List<String> result = new LinkedList<>();
    	List<Integer> position = new LinkedList<>();
    	generateNextPosition(position, n, result);
    	
    	return result;
    	
    }
    
    private static void generateNextPosition(List<Integer> position, int n, List<String> result) {
    	
    	if(position.size() == n-1) {    		
        	StringBuilder sb = new StringBuilder();
        	for(Integer number : position) {
        		sb.append("(" + ")".repeat(number));
        	}
        	int remainRight = n - sumList(position);  
        	sb.append("(" + ")".repeat(remainRight));
        	result.add(sb.toString());
        	
        	return;
    	}
    	
    	int index = position.size() + 1;
		int sum = sumList(position);   
		LinkedList<Integer> newPosition;
		for(int k=0; k<=index-sum; k++) {
			
			if(k == index-sum) {
				position.add(k);
				generateNextPosition(position, n, result);
				continue;
			}
			newPosition = new LinkedList<>(position);
			newPosition.add(k);
			generateNextPosition(newPosition, n, result);
		};  
    }
    
    private static int sumList(List<Integer> position) {
    	
    	return position.size() == 0? 0 : position.stream().mapToInt(n -> n).sum();
    }
    
   public List<String> generateParenthesisDFS2(int n) {
        
    	List<String> result = new LinkedList<>();
    	generateNextString("", 0, 0, n, result);
    	
    	return result;
    	
    }
    
    private static void generateNextString(String current, int left, int right, int n, List<String> result) {
    	
    	if(left == n - 1) {
    		result.add(current + "("+ ")".repeat(left + 1 - right));
    		
    		return;
    	}
    	
    	for(int k=0; k<=left - right + 1; k++) {
    		generateNextString(current + "(" + ")".repeat(k), left+1, right+k, n, result);
    	}
    	
    	return;
    	
    }
}
