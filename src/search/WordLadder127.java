package search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder127 {

	private String name = "127. Word Ladder";
	private String url = "https://leetcode.com/problems/word-ladder/";
	
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
    	Queue<String> queue = new LinkedList<>();
    	Map<String, Integer> markedString = new HashMap<>();
    	
    	queue.add(beginWord);
    	markedString.put(beginWord, 1);
    	
    	String current;
    	while(queue.isEmpty() == false) {
    		
    		current = queue.poll();
    		for(String word : wordList) {
        		if(!markedString.containsKey(word) && oneWordDifferent(current, word)) {

        	    	queue.add(word);
        	    	markedString.put(word, Integer.sum(markedString.get(current), 1));    
            		if(word.equals(endWord)) {
            			return markedString.get(word);
            		}
        		}
    		}
    	}
    	
    	
    	return 0;
    	
    }
    
    private static boolean oneWordDifferent(String first, String second) {
    	
    	int diff = 0;
    	for(int i=0; i<first.length(); i++) {
    		
    		if(first.charAt(i) != second.charAt(i)) {
    			diff++;
    		}
    		if(diff > 1) {
    			return false;
    		}
    	}
    	
    	return true;
    }
	
	
}
