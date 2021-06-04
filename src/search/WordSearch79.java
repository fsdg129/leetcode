package search;

import java.util.HashSet;
import java.util.Set;

public class WordSearch79 {

	private String name = "79. Word Search";
	private String url = "https://leetcode.com/problems/word-search/";
	
    public static boolean exist(char[][] board, String word) {
    	char[] chars = word.toCharArray();
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board.length; j++) {
        		if(check(0, i, j, chars, Set.of(), board))
        			return true;
        	}
        }
        
        return false;
    }
    
    private static boolean check(int index, int rowIndex, int colIndex, char[] chars, Set<Integer> visitedPoint, char[][] board) {
    	if(index >= chars.length)
    		return false;
    	if(rowIndex < 0 || rowIndex >= board.length || colIndex < 0 || colIndex >= board[0].length)
    		return false;
    	if(board[rowIndex][colIndex] != chars[index]) 
    		return false;
    	int position = compress(rowIndex, colIndex, board);
    	if(visitedPoint.contains(position))
    		return false;
    	if(index == chars.length - 1) {
    		return true;
    	} else {
    		Set<Integer> newVisitedPoint = new HashSet<>(visitedPoint);
    		newVisitedPoint.add(position);
    		return check(index + 1, rowIndex - 1, colIndex, chars, newVisitedPoint, board) ||
    				check(index + 1, rowIndex + 1, colIndex, chars, newVisitedPoint, board) ||
    				check(index + 1, rowIndex, colIndex - 1, chars, newVisitedPoint, board) ||
    				check(index + 1, rowIndex, colIndex + 1, chars, newVisitedPoint, board);
    	}
    }
    
    private static int compress(int rowIndex, int colIndex, char[][] board) {
    	return rowIndex * board[0].length + colIndex;
    }
}
