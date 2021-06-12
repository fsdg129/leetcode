package prefixTree;

import java.util.Arrays;

public class Trie {
	
	private Node root = new Node();

    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        insertHelper(0, word, root);
        
        return;
    }
    
    private void insertHelper(int index, String word, Node node) {
    	int charIndex = getCharIndex(index, word);
    	if(node.nodes[charIndex] == null)
    		node.nodes[charIndex] = new Node();
    	if(index == word.length() - 1) {
    		node.isEnd[charIndex] = true;
    		return;
    	}
    	insertHelper(index + 1, word, node.nodes[charIndex]);
    	
    	return;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchHelper(0, word, root, true);
    }
    
    private boolean searchHelper(int index, String word, Node node, boolean checkEnd) {
    	int charIndex = getCharIndex(index, word);
    	if(node.nodes[charIndex] == null)
    		return false;
    	if(index == word.length() - 1) {
    		if(checkEnd)
    			return node.isEnd[charIndex];
    		else 
    			return true;
    	}
    		
    	
    	return searchHelper(index + 1, word, node.nodes[charIndex], checkEnd);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	return searchHelper(0, prefix, root, false);
    }
    
    private static class Node {
    	
    	public Node[] nodes = new Node[26];
    	public boolean[] isEnd = new boolean[26];
    	
    	public Node() {
    		Arrays.fill(isEnd, false);
    	}
    	
    }
    
    private int getCharIndex(int index, String word) {
    	return word.charAt(index) - 'a';
    }
}
;