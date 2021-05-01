package sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TopKFrequentElements347 {

	private String name = "347. Top K Frequent Elements";
	private String url = "https://leetcode.com/problems/top-k-frequent-elements/";
	
    public int[] topKFrequent(int[] nums, int k) {
        
    	Map<Integer, Integer> map = new HashMap<>();
    	int counter;
    	for(int num : nums) {
    		if(map.containsKey(num)) {
    			counter = map.get(num);
    			map.put(num, counter + 1);
    		} else {
    			map.put(num, 1);
    		}
    	}
    	
    	TreeSet<Record> boundedTreeSet = new TreeSet<>();
    	for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		Record r = new Record(entry.getKey(), entry.getValue());
    		boundedTreeSet.add(r);
    		if(boundedTreeSet.size() > k)
    			boundedTreeSet.pollLast();
    	}
    	
    	int[] result = new int[k];
    	for(int i=0; i<k; i++) {
    		result[i] = boundedTreeSet.pollFirst().element;
    	}
    	
    	return result;
    }
    
    private static class Record implements Comparable<Record> {
    	public int element;
    	public int counter;
		/**
		 * @param element
		 * @param counter
		 */
		public Record(int element, int counter) {
			super();
			this.element = element;
			this.counter = counter;
		}
		@Override
		public int compareTo(Record o) {
			// TODO Auto-generated method stub
			if(this.counter > o.counter)
				return -1;
			else if(this.counter < o.counter)
				return 1;
			else 
				return Integer.compare(this.element, o.element);
		}
    }
    
    
	
}
