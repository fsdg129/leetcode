package array;

public class StrongPasswordChecker420 {

	private String name = "420. Strong Password Checker";
	private String url = "https://leetcode.com/problems/strong-password-checker/";
	
    public static int strongPasswordChecker(String password) {
        int repeat = 0, needChars = 0, lengthVariance = 0;
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        char[] charSeq = password.toCharArray();
        char pre = '\0', c, count = 0;
        
        for(int i=0; i<charSeq.length; i++) {
        	c= charSeq[i];
        	if(Character.isLowerCase(c)) {
        		hasLower = true;
        	} else if(Character.isUpperCase(c)) {
        		hasUpper = true;
        	} else if(Character.isDigit(c)) {
        		hasDigit = true;
        	} 
        	if(pre != '\0' && c == pre) {
        		count++;
        	} else {
        		repeat += Math.max(0, count - 2);
        		count = 1;
        		pre = c;
        	}
        }
        repeat += Math.max(0, count - 2);
        
        if(!hasLower)
        	needChars++;
        if(!hasUpper)
        	needChars++;
        if(!hasDigit)
        	needChars++;
        
        if(password.length() < 6) {
        	lengthVariance = 6 - password.length();
        } else if(password.length() > 20) {
        	lengthVariance = password.length() - 20;
        } else {
        	lengthVariance = 0;
        }
        
        return Math.max(lengthVariance, Math.max(needChars, repeat));
    }
}
