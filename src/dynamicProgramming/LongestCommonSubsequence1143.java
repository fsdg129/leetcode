package dynamicProgramming;

public class LongestCommonSubsequence1143 {

	private String name = "1143. Longest Common Subsequence";
	private String url = "https://leetcode.com/problems/longest-common-subsequence/";
	
    public int longestCommonSubsequence(String text1, String text2) {
    	
        int[][] comSeqLen = new int[text1.length() + 1][text2.length() + 1];
        int diff;
        for(int i=0; i <= text1.length(); i++) {
        	for(int j=0; j <= text2.length(); j++) {
            	if(i == 0 || j == 0) {
            		comSeqLen[i][j] = 0;
            	} else {
            		diff = text1.charAt(i - 1) == text2.charAt(j - 1) ? 1 : 0;
            		comSeqLen[i][j] = Math.max(comSeqLen[i - 1][j], comSeqLen[i][j - 1]);
            		comSeqLen[i][j] = Math.max(comSeqLen[i][j], comSeqLen[i - 1][j - 1] + diff);
            	}
        	}
        }
        
        return comSeqLen[text1.length()][text2.length()];
        
    }
    
    
}
