package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TweetCountsPerFrequency1348 {

	private String name = "1348. Tweet Counts Per Frequency";
	private String url = "https://leetcode.com/problems/tweet-counts-per-frequency/";
	
	public static class TweetCounts {

		private Map<String, TreeSet<Integer>> minuteMap = new HashMap<>();
		
		private List<Integer> tweetCounts = new ArrayList<>();
		private int counter = 0;
		private int current;
		
	    public TweetCounts() {
	        
	    }
	    
	    public void recordTweet(String tweetName, int time) {
	    	if(!minuteMap.containsKey(tweetName)) {
	    		minuteMap.put(tweetName, new TreeSet<>());
	    	}
	    	minuteMap.get(tweetName).add(time);
	        
	        return;
	    }
	    
	    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
	        current = startTime;
	        int slice = covertFreq(freq);
	        NavigableSet<Integer> timestamps = minuteMap.get(tweetName).subSet(startTime, true, endTime, true);
	        Iterator<Integer> iterator = timestamps.iterator();
	           	        
	        int eventTime;
	        while(iterator.hasNext()) {
	        	eventTime = iterator.next();
	        	while(eventTime >= current + slice) {
	        		moveOneSlice(slice);
	        	}
	        	counter++;
	        }
	        moveOneSlice(slice);
	        
	        while(current <= endTime) {
	        	tweetCounts.add(0);
	        	current += slice;
	        }
	        
	        return tweetCounts;
	    }
	    
	    private void moveOneSlice(int slice) {
    		tweetCounts.add(counter);
    		counter = 0;
    		current += slice;
	    }
	    
	    private static int covertFreq(String freq) {
	    	if(freq.equals("minute"))
	    		return 60;
	    	else if(freq.equals("hour"))
	    		return 3600;
	    	else 
	    		return 86400;
	    }
	    
	}
}
