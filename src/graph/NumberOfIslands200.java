package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfIslands200 {

    public int numIslands(char[][] grid) {
        
    	Map<Integer, Node> islands = new HashMap<>();
    	
    	int width = grid[0].length;
    	for(int i=0; i<grid.length; i++) {
    		for(int j=0; j<width; j++) {
    			if(grid[i][j] == '1') {
    				Node node = new Node();
    				islands.put(compress(i, j, width), node);
    				if(i > 0 && grid[i-1][j] == '1') {
    					union(node, islands.get(compress(i-1, j, width)));
    				}
    				if(j > 0 && grid[i][j-1] == '1') {
    					union(node, islands.get(compress(i, j-1, width)));
    				}
    			}
    		}
    	}
    	
    	Set<Node> roots = new HashSet<>();
    	for(Map.Entry<Integer, Node> entry : islands.entrySet()) {
    		roots.add( find(entry.getValue()) );
    	}
    	
    	return roots.size();
    }
    
    private static int compress(int i, int j, int width) {
    	return i * width + j;
    }
    
	
	public static Node find(Node x) {
		
		if(x.parent != x) {
			x.parent = find(x.parent);
			return x.parent;
		} else {
			return x;
		}
	}
	
	public static void union(Node x, Node y) {
		
		Node rootX = find(x);
		Node rootY = find(y);
		
		if(rootX == rootY) {
			return;
		}
		
		if(rootX.rank == rootY.rank) {
			
			rootX.parent = rootY;
			rootY.rank++;
			
			return;
		}
		
		Node small, large;
		if(rootX.rank > rootY.rank) {
			small = rootY;
			large = rootX;
		} else {
			small = rootX;
			large = rootY;
		}
		
		small.parent = large;
		return;
	}
	
	private static class Node {
		
		public Node parent = this;
		
		public int rank = 0;
	}
    
}
