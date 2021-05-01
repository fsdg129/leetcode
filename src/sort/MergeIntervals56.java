package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {

	private String name = "56. Merge Intervals";
	private String url = "https://leetcode.com/problems/merge-intervals/";
	
    public int[][] merge(int[][] intervals) {
    	
    	if(intervals.length <= 1)
    		return intervals;
    	
    	Interval[] intervalArray = new Interval[intervals.length];
        for(int i=0; i<intervals.length; i++) {
        	intervalArray[i] = new Interval(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(intervalArray);
        
        List<Interval> intervalList = new ArrayList<>();
        Interval pre = intervalArray[0], current;
        int i=1;
        while(i < intervalArray.length) {
        	current = intervalArray[i];
        	if(pre.end < current.start) {
        		intervalList.add(pre);
        		pre = current;
        	} else {
        		pre.combine(current);
        	}
        	i++;
        }
        intervalList.add(pre);
        
        int[][] result = new int[intervalList.size()][2];
        for(i=0; i<intervalList.size(); i++) {
        	Interval interval = intervalList.get(i);
        	result[i][0] = interval.start;
        	result[i][1] = interval.end;
        }
        
        return result;
    }
    
    private static class Interval implements Comparable<Interval> {
    	public int start;
    	public int end;
    	
    	
    	
		/**
		 * @param start
		 * @param end
		 */
		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public void combine(Interval i) {
			this.end = Math.max(this.end, i.end);
		}
		
		@Override
		public int compareTo(Interval o) {
			// TODO Auto-generated method stub
			if(this.start != o.start)
				return Integer.compare(start, o.start);
			return Integer.compare(end, o.end);
		}
    	
    }
	
}
