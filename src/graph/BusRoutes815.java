package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes815 {

	private String name = "815. Bus Routes";
	private String url = "https://leetcode.com/problems/bus-routes/";
	
	public static void main(String[] args) {
		int[][] routes = { {1,2,7}, {3,6,7} };
		System.out.println(numBusesToDestination(routes, 1, 6));
		
		return;
	}
	
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        
    	if (source == target) return 0;
    	
    	Map<Integer, Node> nodes = new HashMap<>();
    	
    	for(int i=0; i<routes.length; i++) {
    		int[] busRoute = routes[i];
    		for(int node : busRoute) {
    			if(!nodes.containsKey(node)) {
    				nodes.put(node, new Node(node));
    			} 
    			nodes.get(node).buses.add(i);
    		}
    	}
    	
    	if(nodes.get(source) == null || nodes.get(target) == null) {
    		return -1;
    	}
    	
    	int distance = 0;
    	int visitNodes = 1;
    	Queue<Node> queue = new LinkedList<>();
    	Set<Integer> visitBuses = new HashSet<>();
    	queue.add(nodes.get(source));
    	
    	while(!queue.isEmpty()) {
    		
    		int counter = 0;
    		for(int i=0; i<visitNodes; i++) {
    			Node root = queue.remove();
    			if(root.distance >= 0 && distance >= root.distance ) {
    				continue;
    			}
				root.distance = distance;
				//System.out.printf("The value of node %d is %d\n", root.name, root.distance);
				if(root.name == target) {
					return root.distance;
				}
				for(Integer bus : root.buses) {
					int[] busRoute = routes[bus];
					if(visitBuses.contains(bus))
						continue;
					for(int node : busRoute) {
						queue.add(nodes.get(node));
						counter++;
					}
					visitBuses.add(bus);
				}    				
    		}
    		distance++;
    		visitNodes = counter;
    	}    	    	
    	
    	return -1;
    }
    
    public static class Node {
    	public int name;
    	public List<Integer> buses = new ArrayList<>();
    	public int distance = -1;   
    	
    	public Node(int name) {
    		super();
    		this.name = name;
    	}
    }
}
