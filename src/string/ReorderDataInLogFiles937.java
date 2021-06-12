package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderDataInLogFiles937 {

	private String name = "937. Reorder Data in Log Files";
	private String url = "https://leetcode.com/problems/reorder-data-in-log-files/";
	
    public String[] reorderLogFiles(String[] logs) {
    	List<String> digitLogs = new ArrayList<>();
    	List<Log> letterLogs = new ArrayList<>();
    	
        for(String log : logs) {
        	Log logRecord = new Log(log);
        	if(logRecord.isDigitLog) 
        		digitLogs.add(log);
        	else
        		letterLogs.add(logRecord);
        }
        Collections.sort(letterLogs);
        
        String[] orderedLogs = new String[logs.length];
        int i=0;
        for(Log letterLog : letterLogs) {
        	orderedLogs[i] = letterLog.log;
        	i++;
        }
        for(String digitLog : digitLogs) {
        	orderedLogs[i] = digitLog;
        	i++;
        }
        
        return orderedLogs;
    }
    
    private static class Log implements Comparable<Log>{
    	public String log;
    	public boolean isDigitLog = false;
    	public String identifier = "";
    	public String content = "";
    	
    	public Log(String log) {
    		super();
    		this.log = log;
    		int spaceIndex = log.indexOf(' ');
    		for(int i=spaceIndex + 1; i<log.length(); i++) {
    			if(Character.isDigit(log.charAt(i))) {
    				isDigitLog = true;
    				return;
    			}
    		}
    		identifier = log.substring(0, spaceIndex);
    		content = log.substring(spaceIndex + 1, log.length());
    	}
    	
    	public int compareTo(Log other) {
    		int result = this.content.compareTo(other.content);
    		if(result != 0)
    			return result;
    		return this.identifier.compareTo(other.identifier);
    	}
    }
}
