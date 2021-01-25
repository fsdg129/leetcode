package search;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LetterCombinations17 {

	private String name = "17. Letter Combinations of a Phone Number";
	private String url = "https://leetcode.com/problems/letter-combinations-of-a-phone-number/";
	
	private static Map<String, Set<String>> digitMap = digitMap();	
	private static Map<String, Set<String>> digitMap(){
		
		return Map.of("2", Set.of("a", "b", "c"),
				"3", Set.of("d", "e", "f"),
				"4", Set.of("g", "h", "i"),
				"5", Set.of("j", "k", "l"),
				"6", Set.of("m", "n", "o"),
				"7", Set.of("p", "q", "r", "s"),
				"8", Set.of("t", "u", "v"),
				"9", Set.of("w", "x", "y", "z")
				);
	}
	
    public List<String> letterCombinations(String digits) {
        
    	int i = 0;
    	Set<String> letterCombinations = Set.of();
    	
    	while(i < digits.length()) {
    		String digit = String.valueOf(digits.charAt(i));
    		letterCombinations = letterIterator(digit, letterCombinations);
    		i++;
    	}
    	
    	return 	letterCombinations.stream().collect(Collectors.toList());
    }
    
    private static Set<String> letterIterator(String digit, Set<String> letterCombinations){
    	
    	if(letterCombinations.size() == 0) {
    		return digitMap.get(digit);
    	}
    	Set<String> result = new HashSet<>();
    	for(String previousCombination : letterCombinations) {
    		for(String newLetter : digitMap.get(digit)) {
    			result.add(previousCombination + newLetter);
    		}
    	}
    	
    	return result;
    	
    }
}
