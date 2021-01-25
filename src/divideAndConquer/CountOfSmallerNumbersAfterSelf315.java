package divideAndConquer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountOfSmallerNumbersAfterSelf315 {

	private String name = "315. Count of Smaller Numbers After Self";
	private String url = "https://leetcode.com/problems/count-of-smaller-numbers-after-self/";
	
    public List<Integer> countSmaller(int[] nums) {
        
    	if(nums.length == 0) {
    		return List.of();
    	}
    	if(nums.length == 1) {
    		return List.of(0);
    	}
    	
    	int[] counts = new int[nums.length];
    	Arrays.fill(counts, 0);
    	
    	Node[] nodeArray = new Node[nums.length];
    	Node[] nodeArrayCopy = new Node[nums.length];
    	for(int i=0; i<nums.length; i++) {
    		nodeArray[i] = new Node(nums[i], i);
    		nodeArrayCopy[i] = nodeArray[i];
    	}
    	mergeSort(nodeArrayCopy, 0, nodeArray.length, nodeArray, counts);
    	    	
    	return Arrays.stream(counts).boxed().collect(Collectors.toList());
    }
    
    private static void mergeSort(Node[] source, int start, int end, Node[] target, int[] counts) {
    	
    	if(end - start == 1) {
    		return;
    	}
    	
    	int mid = (start + end) / 2;
    	mergeSort(target, start, mid, source, counts);
    	mergeSort(target, mid, end, source, counts);
    	
    	merge(source, start, mid, end, target, counts);
    	
    	return;
    }
    
    private static void merge(Node[] source, int start, int mid, int end, Node[] target, int[] counts) {
    	
    	int i = start;
    	int j = mid;
    	int k = start;
    	
    	while(k < end) {
    		if(i >= mid || (j < end && source[j].compareTo(source[i]) < 0) ) {
    			target[k] = source[j];
    			if(j < k) {
    				counts[target[k].index] += k -j;
    			}
    			j++;
    		} else {
    			target[k] = source[i];
    			if(i < k) {
    				counts[target[k].index] += k -i;
    			}
    			i++;
    		} 
    		k++;
    	}
    	
    	return;
    }
    
    private final class Node implements Comparable<Node>{
    	
    	public int val;
    	public int index;
    	
		/**
		 * @param val
		 * @param index
		 */
		public Node(int val, int index) {
			super();
			this.val = val;
			this.index = index;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.val, o.val);
		}	
		
    }
}
