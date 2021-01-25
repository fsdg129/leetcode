package search;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParentheses22 {

	private String name = "22. Generate Parentheses";
	private String url = "https://leetcode.com/problems/generate-parentheses/";
	
	// if n = 4, there are four positions to insert ) (_(_(_(_ 
	//In the ith position, we could insert at most i )
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
    
    private static int sumList(List<Integer> position) {
    	
    	return position.stream().mapToInt(n -> n).sum();
    }
}
