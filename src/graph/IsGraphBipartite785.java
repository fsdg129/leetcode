package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite785 {

	private String name = "785. Is Graph Bipartite?";
	private String url = "https://leetcode.com/problems/is-graph-bipartite/";
	
    public boolean isBipartite(int[][] graph) {        
    	
    	int[] nodeMark = new int[graph.length];
    	Arrays.fill(nodeMark, -1);
    	Queue<Integer> queue = new LinkedList<>(); 
    	int rootNode = 0;

    	while(true) {	    	
	    	while(true) {
		    	if(rootNode >= nodeMark.length)
		    		return true;
		    	if(nodeMark[rootNode] == -1)
		    		break;
		    	else
		    		rootNode++;
	    	}
	    	
	    	nodeMark[rootNode] = 1;
	    	queue.add(rootNode);
	    	while(!queue.isEmpty()) {
	    		int current = queue.remove();
	    		int[] linkedNodes = graph[current];
	    		int mark = nodeMark[current] == 1? 0 : 1;
	    		for(int node : linkedNodes) {
	    			if(nodeMark[node] == -1) {
	    				nodeMark[node] = mark;
	    				queue.add(node);
	    			} else if(nodeMark[node] == mark) {
	    				continue;
	    			} else {
	    				return false;
	    			}    				
	    		}    		
	    	}
    	}
    	
    }
    
}
