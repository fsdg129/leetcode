package dynamicProgramming;

public class EditDistance72 {

	private String name = "72. Edit Distance";
	private String url = "https://leetcode.com/problems/edit-distance/";
	
    public int minDistance(String word1, String word2) {
        
    	if(word1.length() == 0 || word2.length() == 0) {
    		return Math.abs(word1.length() - word2.length());
    	}
    	
    	int[][] minDist = new int[word1.length()][word2.length()];
    	int diff;
    	for(int i = 0; i < word1.length(); i++) {
    		for(int j = 0; j < word2.length(); j++) {
    			diff = word1.charAt(i) == word2.charAt(j) ? 0 : 1;
    			if(i == 0 && j == 0) {
    				minDist[i][j] = diff;
    			} else if(i == 0){
    				minDist[i][j] = Math.min(j + diff, minDist[i][j - 1] + 1);
    			} else if(j == 0){
    				minDist[i][j] = Math.min(i + diff, minDist[i - 1][j] + 1);
    			} else {
    				minDist[i][j] = Math.min(minDist[i][j - 1] + 1, minDist[i - 1][j] + 1);
    				minDist[i][j] = Math.min(minDist[i][j], minDist[i - 1][j - 1] + diff);
    			}
    		}
    	}
    	
    	return minDist[word1.length() - 1][word2.length() - 1];
    }
}
