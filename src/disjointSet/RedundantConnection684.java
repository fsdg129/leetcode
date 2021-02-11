package disjointSet;

public class RedundantConnection684 {

	private String name = "684. Redundant Connection";
	private String url = "https://leetcode.com/problems/redundant-connection/";
	
    public int[] findRedundantConnection(int[][] edges) {
        
    	int nodeNumber = edges.length;
    	Node[] nodes = new Node[nodeNumber + 1];
    	for(int i=1; i<=nodeNumber; i++) {
    		nodes[i] = new Node();
    	}
    	
    	for(int[] edge : edges) {
    		Node first = nodes[edge[0]];
    		Node second = nodes[edge[1]];
    		
    		if(Node.find(first) != Node.find(second)) {
    			Node.union(first, second);
    		} else {
    			return edge;
    		}
    	}
    	
    	return new int[0];
    }
    
    private static class Node {
    	
    	public Node parent = this;
    	
    	public int rank = 0;
    	
    	public static Node find(Node x) {
    		
    		if(x.parent == x) {
    			return x;
    		}
    		x.parent = find(x.parent);
    		return x.parent;
    	}
    	
    	public static void union(Node x, Node y) {
    		
    		Node rx = find(x);
    		Node ry = find(y);
    		
    		if(rx == ry) {
    			return;
    		}
    		
    		if(rx.rank == ry.rank) {
    			rx.parent = ry;
    			ry.rank++;
    			
    			return;
    		}
    		
    		Node small, large;
    		if(rx.rank >= ry.rank) {
    			small = ry;
    			large = rx;
    		} else {
    			small = rx;
    			large = ry;
    		}
    		
    		small.parent = large;
    		
    		return;
    	}
    }
}
