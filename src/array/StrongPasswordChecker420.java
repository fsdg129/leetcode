package array;

public class StrongPasswordChecker420 {

	private String name = "289. Game of Life";
	private String url = "https://leetcode.com/problems/game-of-life/";
	
    public static int strongPasswordChecker(String password) {
        int step = 0, repeat = 0;
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        char[] charSeq = password.toCharArray();
        char pre, c;
        for(int i=0; i<charSeq.length; i++) {
        	c= charSeq[i];
        	if(Character.isLowerCase(c)) {
        		hasLower = true;
        	} else if(Character.isUpperCase(c)) {
        		hasUpper = true;
        	} else if(Character.isDigit(c)) {
        		hasDigit = true;
        	} 
        }
        
    }
}
