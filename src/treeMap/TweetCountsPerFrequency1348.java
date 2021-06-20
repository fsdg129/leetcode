package treeMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TweetCountsPerFrequency1348 {

	private String name = "1348. Tweet Counts Per Frequency";
	private String url = "https://leetcode.com/problems/tweet-counts-per-frequency/";
	
	public static class TweetCounts {

		private Map<String, TreeMap<Integer, Integer>> minuteMap = new HashMap<>();
		
		private List<Integer> tweetCounts;
		private int counter;
		private int current;
		
	    public TweetCounts() {
	        
	    }
	    
	    public void recordTweet(String tweetName, int time) {
	    	if(!minuteMap.containsKey(tweetName)) {
	    		minuteMap.put(tweetName, new TreeMap<>());
	    	}
	    	if(minuteMap.get(tweetName).containsKey(time)) {
	    		int number = minuteMap.get(tweetName).get(time);
	    		number++;
	    		minuteMap.get(tweetName).put(time, number);
	    	} else {
	    		minuteMap.get(tweetName).put(time, 1);
	    	}
	        
	        return;
	    }
	    
	    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
	    	tweetCounts = new ArrayList<>();
	    	counter = 0;
	    	
	        current = startTime;
	        int slice = covertFreq(freq);
	        Iterator<Map.Entry<Integer, Integer>> iterator = minuteMap.get(tweetName)
	        		.subMap(startTime, true, endTime, true).entrySet().iterator();
	           	        
	        Map.Entry<Integer, Integer> eventTime;
	        while(iterator.hasNext()) {
	        	eventTime = iterator.next();
	        	while(eventTime.getKey() >= current + slice) {
	        		moveOneSlice(slice);
	        	}
	        	counter += eventTime.getValue();
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
