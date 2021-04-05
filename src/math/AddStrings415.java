package math;

import java.util.Arrays;

public class AddStrings415 {

	private String name = "415. Add Strings";
	private String url = "https://leetcode.com/problems/add-strings/";
	
    public String addStrings(String num1, String num2) {
        
    	int a, b, sum, carry = 0;
    	
    	String[] result = new String[Math.max(num1.length(), num2.length()) + 1];
    	Arrays.fill(result, "0");
    	
    	int i = num1.length() - 1;
    	int j = num2.length() - 1;
    	int k = result.length - 1;
    	
    	while(k >= 0) {
    		if(i >= 0) {
    			a = Character.getNumericValue(num1.charAt(i));
    			i--;
    		} else {
    			a = 0;
    		}
    		if(j >= 0) {
    			b = Character.getNumericValue(num2.charAt(j));
    			j--;
    		} else {
    			b = 0;
    		}
    		
    		sum = (a + b + carry) % 10;
    		carry = (a + b + carry) / 10;
    		
    		result[k] = String.valueOf(sum);
    		k--;	
    	}
    	
    	StringBuilder sb = new StringBuilder(result[0].equals("0") ? "" : "1");
    	for(k=1; k<result.length; k++) {
    		sb.append(result[k]);
    	}
    	
    	return sb.toString();
    	
    }
}
