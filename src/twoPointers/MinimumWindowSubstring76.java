package twoPointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {

	private String name = "76. Minimum Window Substring";
	private String url = "https://leetcode.com/problems/minimum-window-substring/";
	
    public String minWindow(String s, String t) {
        
    	Map<Character, Integer> searchCharacter = new HashMap<>();
    	Map<Character, Integer> needCharacter = new HashMap<>();
    	for(char c : t.toCharArray()) {   		
    		searchCharacter.put(c, 0);
    		needCharacter.merge(c, 1, Integer::sum);
    	}
    	
    	int foundCharacters = 0;
    	int left = 0;
    	int right = -1;
    	char newChar;
    	int minLeft=0, minRight=s.length();
    	
    	while(true) {
    		
    		if(foundCharacters < searchCharacter.size()) {
    			right++;
    			if(right > s.length() - 1) {
    				break;
    			}
    			newChar = s.charAt(right);
    			if(searchCharacter.containsKey(newChar)) {
    				if(searchCharacter.get(newChar).intValue() == needCharacter.get(newChar).intValue() - 1) {
    					foundCharacters++;
    				}
    				searchCharacter.compute(newChar, (k, v) -> Integer.sum(v, 1));	
    			}
    		} else {
    			if(right - left < minRight - minLeft) {
    				minLeft = left;
    				minRight = right;
    			}
    			left++;
    			newChar = s.charAt(left-1);
    			if(searchCharacter.containsKey(newChar)) {
    				searchCharacter.compute(newChar, (k, v) -> Integer.sum(v, -1));
    				if(searchCharacter.get(newChar).intValue() < needCharacter.get(newChar).intValue()) {
    					foundCharacters--;
    				}
    			}
    		}
    	}
    	
    	if(minRight >= s.length()) {
    		return "";
    	} else {
    		return s.substring(minLeft, minRight+1);
    	}
    	  	
    }
}
