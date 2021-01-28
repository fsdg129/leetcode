package twoPointers;

public class ValidPalindrome125 {

	private String name = "125. Valid Palindrome";
	private String url = "https://leetcode.com/problems/valid-palindrome/";
	
    public boolean isPalindrome(String s) {
    	
    	if(s.isEmpty()) {
    		return true;
    	}
    	
        char[] sequence = s.toCharArray();
        int i = 0;
        int j = sequence.length - 1;
        
        while(j > i) {
        	
        	if(!isLetter(sequence[i])) {
        		i++;
        		continue;
        	}
        	if(!isLetter(sequence[j])) {
        		j--;
        		continue;
        	}
        	if(isEqualed(sequence[i], sequence[j])) {
        		i++;
        		j--;
        	} else {
        		return false;
        	}
        	
        }        
        
        return true;
    }
    
    private static boolean isLetter(char c) {
    	
    	if( (c >= 'a' && c <='z') || (c >= 'A' && c <='Z') || (c >= '0' && c <='9') ) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    private static boolean isEqualed(char a, char b) {
    	
    	if(a == b) {
    		return true;
    	}
    	if(a <= '9' || b <= '9') {
    		return false;
    	}
    	if(Math.abs(a - b) == 32) {
    		return true;
    	}
    	return false;
    }
}
