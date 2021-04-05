package math;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords273 {

	private String name = "273. Integer to English Words";
	private String url = "https://leetcode.com/problems/integer-to-english-words/";
	
	private static Map<Integer, String> oneName;
	static {
		oneName = new HashMap<>();
		oneName.put(1, "One");
		oneName.put(2, "Two");
		oneName.put(3, "Three");
		oneName.put(4, "Four");
		oneName.put(5, "Five");
		oneName.put(6, "Six");
		oneName.put(7, "Seven");
		oneName.put(8, "Eight");
		oneName.put(9, "Nine");		
	}
	
	private static Map<Integer, String> belowTwentyName;
	static {
		belowTwentyName = new HashMap<>();
		belowTwentyName.put(10, "Ten");
		belowTwentyName.put(11, "Eleven");
		belowTwentyName.put(12, "Twelve");
		belowTwentyName.put(13, "Thirteen");
		belowTwentyName.put(14, "Fourteen");
		belowTwentyName.put(15, "Fifteen");
		belowTwentyName.put(16, "Sixteen");
		belowTwentyName.put(17, "Seventeen");
		belowTwentyName.put(18, "Eighteen");
		belowTwentyName.put(19, "Nineteen");		
	}
	
	private static Map<Integer, String> tenthName;
	static {
		tenthName = new HashMap<>();
		tenthName.put(2, "Twenty");
		tenthName.put(3, "Thirty");
		tenthName.put(4, "Forty");
		tenthName.put(5, "Fifty");
		tenthName.put(6, "Sixty");
		tenthName.put(7, "Seventy");
		tenthName.put(8, "Eighty");
		tenthName.put(9, "Ninety");		
	}
	
    public String numberToWords(int num) {
    	
    	if(num == 0)
    		return "Zero";
        
    	int billion = 1_000_000_000;
    	int million = 1_000_000;
    	int thousand = 1_000;    	
    	
    	int current  = num;
    	int billionNum = current / billion;
    	
    	current = current - billionNum * billion;
    	int millionNum = current / million;
    	
    	current = current - millionNum * million;
    	int thousandNum = current / thousand;
    	
    	int remainNum = num % thousand;
    	
    	StringBuilder sb = new StringBuilder();
    	if(billionNum > 0)
    		sb.append(samllNumberToWord(billionNum) + " Billion ");
    	if(millionNum > 0)
    		sb.append(samllNumberToWord(millionNum) + " Million ");
    	if(thousandNum > 0)
    		sb.append(samllNumberToWord(thousandNum) + " Thousand ");
    	if(remainNum > 0)
    		sb.append(samllNumberToWord(remainNum));    	
    	
    	return sb.toString().trim();
    }
    
    private static String samllNumberToWord(int num) {
    	
    	int hundredNum = num / 100;
    	int tenNum = (num - hundredNum * 100) / 10;
    	int remain = num % 10;
    	
    	StringBuilder sb = new StringBuilder();
    	if(hundredNum > 0)
    		sb.append(oneName.get(hundredNum) + " Hundred ");
    	if(tenNum == 1) {
    		sb.append(belowTwentyName.get(num % 100));
    		return sb.toString();
    	}
    	if(tenNum > 1)
    		sb.append(tenthName.get(tenNum) + " ");
    	if(remain > 0)
    		sb.append(oneName.get(remain));
    	
    	return sb.toString().trim();
    }
}
