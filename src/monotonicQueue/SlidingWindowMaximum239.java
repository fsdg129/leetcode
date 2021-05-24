package monotonicQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeSet;

public class SlidingWindowMaximum239 {
	
	private String name = "239. Sliding Window Maximum";
	private String url = "https://leetcode.com/problems/sliding-window-maximum/";
	
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k >= nums.length) {
        	int max = Arrays.stream(nums).max().orElseThrow();
        	return new int[] { max };
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] maxInWindow = new int[nums.length - k + 1];
        
        int current;
        for(int i=0; i<nums.length; i++) {
        	while(!deque.isEmpty()) {
        		current = deque.peekLast();
        		if(nums[i] < nums[current])
        			break;
        		deque.pollLast();
        	}
        	if(i >= k && !deque.isEmpty()) {
        		current = deque.peekFirst();
        		if(current < i - k + 1)
        			deque.pollFirst();
        	}
        	deque.addLast(i);
        	if(i >= k - 1) {
        		maxInWindow[i - k + 1] = nums[deque.peekFirst()];
        	}
        }
        
        return maxInWindow;
    }

	public int[] maxSlidingWindowTreeSet(int[] nums, int k) {
        if(k >= nums.length) {
        	int max = Arrays.stream(nums).max().orElseThrow();
        	return new int[] { max };
        }
        
        Record[] records = new Record[nums.length];
        for(int i=0; i<records.length; i++) {
        	records[i] = new Record(nums[i], i);
        }
        
        int[] maxInWindow = new int[nums.length - k + 1];
        TreeSet<Record> sortedNums = new TreeSet<>();
        for(int i=0; i<k; i++) {
        	sortedNums.add(records[i]);
        }
        maxInWindow[0] = sortedNums.last().value;
        for(int i=k; i<nums.length; i++) {
        	sortedNums.remove(records[i-k]);
        	sortedNums.add(records[i]);
        	maxInWindow[i-k+1] = sortedNums.last().value;
        }
        
        return maxInWindow;
    }
	
	private static class Record implements Comparable<Record>{
		public int value;
		public int index;
		
		/**
		 * @param value
		 * @param index
		 */
		public Record(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Record o) {
			// TODO Auto-generated method stub
			if(this.value != o.value)
				return Integer.compare(value, o.value);
			return Integer.compare(index, o.index);
		}
		
	}
}
