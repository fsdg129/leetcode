package disjointSet;

import java.util.Arrays;

public class ConnectingCitiesWithMinimumCost1135 {

	private String name = "1135. Connecting Cities With Minimum Cost";
	private String url = "https://leetcode.com/problems/connecting-cities-with-minimum-cost/";
	
    public int minimumCost(int N, int[][] connections) {
        
    	Node[] nodes = new Node[N + 1];
    	for(int i = 1; i <= N; i++) {   		
    		nodes[i] = new Node();
    	}
    	
    	Edge[] edges = new Edge[connections.length];
    	int[] connection;
    	for(int i = 0; i < connections.length; i++) {
    		connection = connections[i];
    		edges[i] = new Edge(nodes[connection[0]], nodes[connection[1]], connection[2]);   		
    	}
    	
    	Arrays.sort(edges, (o1, o2) -> Integer.compare(o1.distance, o2.distance));
    	
    	int minCost = 0;   	
    	for(Edge edge : edges) {
    		if(Node.find(edge.from) != Node.find(edge.to)) {
    			Node.union(edge.from, edge.to);
    			minCost += edge.distance;
    		}
    	}
    	
    	for(int i = 1; i < N; i++) {
    		if(Node.find(nodes[i]) != Node.find(nodes[i+1])) {
    			return -1;
    		}
    	}
    	
    	return minCost;
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
    		if(rx.rank < ry.rank) {
    			small = rx;
    			large = ry;
    		} else {
    			small = ry;
    			large = rx;
    		}
    		
    		small.parent = large;
    		
    		return;
    	}
    }
    
    private static class Edge {
    	
    	public Node from;
    	public Node to;
    	public int distance;
    	
    	public Edge(Node from, Node to, int distance) {
    		super();
    		this.from = from;
    		this.to = to;
    		this.distance = distance;
    	}
    	
    }
}
