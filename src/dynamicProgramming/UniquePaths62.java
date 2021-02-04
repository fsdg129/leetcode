package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths62 {

	private String name = "62. Unique Paths";
	private String url = "https://leetcode.com/problems/unique-paths/";
	
    public int uniquePaths(int m, int n) {
        
    	Map<Point, Integer> pathNumber = new HashMap<>();
    	
    	int path;
    	for(int i = 1; i <= m; i++) {
    		for(int j = 1; j <= n; j++) {
    			if(i == 1 || j == 1) {
    				pathNumber.put(new Point(i, j), 1);
    				continue;
    			}
    			path = Integer.sum(pathNumber.get(new Point(i - 1, j)), 
    					pathNumber.get(new Point(i, j-1)));
    			pathNumber.put(new Point(i, j), path);
    		}
    	}
    	
    	return pathNumber.get(new Point(m, n)).intValue();
    	
    }
    
    private static class Point {
    	
    	public int m;
    	public int n;
		/**
		 * @param m
		 * @param n
		 */
		public Point(int m, int n) {
			super();
			if(m < n) {
				this.m = m;
				this.n = n;
			} else {
				this.m = n;
				this.n = m;
			}
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + m;
			result = prime * result + n;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (m != other.m)
				return false;
			if (n != other.n)
				return false;
			return true;
		}
		
		
    	
    }

    
    
}
