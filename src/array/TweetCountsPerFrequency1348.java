package array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TweetCountsPerFrequency1348 {

	private String name = "1348. Tweet Counts Per Frequency";
	private String url = "https://leetcode.com/problems/tweet-counts-per-frequency/";
	
	public static class TweetCounts {

		private Map<Integer, Map<String, Integer>> minuteMap = new HashMap<>();
		private Map<Integer, Map<String, Integer>> hourMap = new HashMap<>();
		private Map<Integer, Map<String, Integer>> dayMap = new HashMap<>();
		
	    public TweetCounts() {
	        
	    }
	    
	    public void recordTweet(String tweetName, int time) {
	        this.recordTweetMinute(tweetName, time);
	        this.recordTweetHour(tweetName, time);
	        this.recordTweetDay(tweetName, time);
	        
	        return;
	    }
	    
	    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
	        
	    }
	    
	    private void recordTweetMinute(String tweetName, int time) {
	    	recordTweetInChunk(tweetName, minuteKey(time), this.minuteMap);
	    	
	    	return;
	    }
	    
	    private void recordTweetHour(String tweetName, int time) {
	    	recordTweetInChunk(tweetName, hourKey(time), this.hourMap);
	    	
	    	return;
	    }
	    
	    private void recordTweetDay(String tweetName, int time) {
	    	recordTweetInChunk(tweetName, dayKey(time), this.dayMap);
	    	
	    	return;
	    }
	    
	    private static void recordTweetInChunk(String tweetName, int key, Map<Integer, Map<String, Integer>> totalMap) {
	    	Map<String, Integer> chunkMap;
	    	if(totalMap.containsKey(key)) {
	    		chunkMap = totalMap.get(key);
	    	} else {
	    		chunkMap = new HashMap<>();
	    		totalMap.put(key, chunkMap);
	    	}
	    	int count = chunkMap.getOrDefault(tweetName, 0);
	    	count++;
	    	chunkMap.put(tweetName, count);
	    	
	    	return;
	    }
	    
	    private static int minuteKey(int time) {
	    	return time / 60;
	    }
	    private static int hourKey(int time) {
	    	return time / 3600;
	    }
	    private static int dayKey(int time) {
	    	return time / 86400;
	    }
	    
	}
}
