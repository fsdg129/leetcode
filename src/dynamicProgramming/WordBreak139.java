package dynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {

	private String name = "139. Word Break";
	private String url = "https://leetcode.com/problems/word-break/";
	
    public boolean wordBreak(String s, List<String> wordDict) {
        
    	Set<String> resultSet = new HashSet<>();
    	
    	return wordBreakHelper(s, wordDict, resultSet);
    }
    
    private static boolean wordBreakHelper(String s, List<String> wordDict, Set<String> resultSet) {
        
    	if(s.equals("")) {
    		return true;
    	}
    	if(resultSet.contains(s)) {
    		return false;
    	}
    	
    	String newString;
    	for(String word : wordDict) {
    		if(s.endsWith(word)) {
    			newString = s.substring(0, s.length() - word.length());
    			if(wordBreakHelper(newString, wordDict, resultSet)) {
    				return true;
    			}
    		}
    	}
    	
    	resultSet.add(s);
    	
    	return false;
    }
}
