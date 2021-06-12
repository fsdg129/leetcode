package array;

import java.util.Deque;
import java.util.LinkedList;

public class DesignHitCounter362 {

	private String name = "362. Design Hit Counter";
	private String url = "https://leetcode.com/problems/design-hit-counter/";
	
	public static class HitCounter {

		private Deque<Integer> deque = new LinkedList<>();
	    /** Initialize your data structure here. */
	    public HitCounter() {
	        
	    }
	    
	    /** Record a hit.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public void hit(int timestamp) {
	        while(!deque.isEmpty() && timestamp - deque.peekFirst().intValue() > 300) {
	        	deque.pollFirst();
	        }
	        deque.addLast(timestamp);
	    }
	    
	    /** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public int getHits(int timestamp) {
	        return deque.size();
	    }
	}
}
