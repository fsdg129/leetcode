package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlienDictionary269 {

	private String name = "269. Alien Dictionary";
	private String url = "https://leetcode.com/problems/alien-dictionary/";
	
    public static String alienOrder(String[] words) {
        if(words.length == 0)
        	return "";
        if(words.length == 1)
        	return words[0];
        
        //The values are before key lexicographically
        Map<Character, Set<Character>> orderMap = new HashMap<>();
        for(int i=0; i<words.length - 1; i++) {
        	if(!compareOrder(words[i], words[i + 1], orderMap))
        		return "";
        }
        
        Set<Character> chars = new HashSet<>();
        for(String word : words) {
        	for(char c : word.toCharArray())
        		chars.add(c);
        }
        int wholeLength = chars.size();
        
        StringBuilder sb = new StringBuilder();
        Set<Character> visitedChars = new HashSet<>();
        int size = 0;
        Character c;
        Iterator<Character> iterator;
        while(true) {
        	size = visitedChars.size();
        	iterator = chars.iterator();
            while(iterator.hasNext()) {
            	c = iterator.next();
            	boolean noBeforeChars = true;
            	if(orderMap.containsKey(c)) {
            		for(Character beforeChar : orderMap.get(c)) {
            			if(visitedChars.contains(beforeChar) == false) {
            				noBeforeChars = false;
            				break;
            			}
            		}
            	}
            	if(noBeforeChars) {
        			visitedChars.add(c);
        			sb.append(c);
        			iterator.remove();
        		}
            }
            if(sb.length() == wholeLength)
            	return sb.toString();
            if(size == visitedChars.size())
            	return "";
        }

    }
    
    private static boolean compareOrder(String before, String after, Map<Character, Set<Character>> orderMap) {
    	char a, b;
    	for(int i=0; i<Math.min(before.length(), after.length()); i++) {
    		a = before.charAt(i);
    		b = after.charAt(i);
    		if(a != b) {
    			if(!orderMap.containsKey(b))
    				orderMap.put(b, new HashSet<>());
    			orderMap.get(b).add(a);
    			return true;
    		}
    	}
    	
    	if(before.length() > after.length())
    		return false;
    	
    	return true;
    }
	
}
