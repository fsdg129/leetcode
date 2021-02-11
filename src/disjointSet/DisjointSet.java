package disjointSet;

public class DisjointSet {

	public static void makeSet(Node x) {
		
		x.parent = x;
		x.rank = 0;
		
		return;
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
