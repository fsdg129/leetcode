package dynamicProgramming;

public class DistinctSubsequences115 {

	private String name = "115. Distinct Subsequences";
	private String url = "https://leetcode.com/problems/distinct-subsequences/submissions/";
	
    public static int numDistinct(String text, String pattern) {
        if(pattern.length() < 1 || text.length() < pattern.length()){
            return 0;
        }
        //System.out.println("Hello World!");
        int[][] counter = new int[text.length()+1][pattern.length()+1];
        counter[0][0] = 1;
        for(int j=1; j<=pattern.length(); j++){
            counter[0][j] = 0;
        }
        //System.out.println("Hello World!");
        for(int i=1; i<=text.length(); i++){
            counter[i][0] = 1;
            for(int j=1; j<=pattern.length(); j++){
                counter[i][j] = counter[i-1][j];
                if(text.charAt(i-1) == pattern.charAt(j-1)){
                    counter[i][j] = counter[i][j] + counter[i-1][j-1];
                }
            }
        }

        return counter[text.length()][pattern.length()];
    }
}
