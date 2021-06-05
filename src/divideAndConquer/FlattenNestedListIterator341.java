package divideAndConquer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator341 {

	public static class NestedIterator implements Iterator<Integer> {

		private Iterator<Integer> iterator;
	    public NestedIterator(List<NestedInteger> nestedList) {
	        this.iterator = flatternNestedList(nestedList).iterator();
	    }
	    
	    private static List<Integer> flatternNestedList(List<NestedInteger> nestedList) {
	    	List<Integer> result = new ArrayList<>();
	    	flatternNestedListHelper(nestedList, result);
	    	return result;
	    }
	    
	    private static void flatternNestedListHelper(List<NestedInteger> nestedList, List<Integer> result) {
	    	
	    	for(NestedInteger nest : nestedList) {
	    		if(nest.isInteger()) {
	    			result.add(nest.getInteger());
	    			continue;
	    		}
	    		flatternNestedListHelper(nest.getList(), result);
	    	}
	    	return;
	    }


	    @Override
	    public Integer next() {
	        return iterator.next();
	    }

	    @Override
	    public boolean hasNext() {
	        return iterator.hasNext();
	    }
	}
	

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public interface NestedInteger {
		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return empty list if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

}
