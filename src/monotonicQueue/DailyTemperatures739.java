package monotonicQueue;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures739 {

	private String name = "739. Daily Temperatures";
	private String url = "https://leetcode.com/problems/daily-temperatures/";
	
    public int[] dailyTemperatures(int[] temperatures) {
    	int[] delay = new int[temperatures.length];
    	
        Deque<Integer> deque = new LinkedList<>();
        int current;
        for(int i=0; i<temperatures.length; i++) {        	
        	while(!deque.isEmpty()) {
        		current = deque.peekLast();
        		if(temperatures[i] <= temperatures[current]) {
        			break;
        		}
        		deque.pollLast();
        		delay[current] = i - current;
        	}
        	deque.addLast(i);
        }
        while(!deque.isEmpty()) {
        	delay[deque.pollLast()] = 0;
        }
        
        return delay;
    }
    
	public int[] dailyTemperaturesDM(int[] temperatures) {
		if(temperatures.length == 1)
			return new int[] {0};
		//The index of the first number which is bigger than the current number
        int[] right = new int[temperatures.length];
        right[temperatures.length - 1] = temperatures.length;
        
        int current;
        for(int i=temperatures.length - 2; i>=0; i--) {
        	current  = i + 1;
        	while(current < temperatures.length) {
        		if(temperatures[current] > temperatures[i]) {
        			break;
        		} else {
        			current = right[current];
        		}
        	}
        	right[i] = current;
        }
        
        for(int i=0; i<temperatures.length; i++) {
        	right[i] = right[i] == temperatures.length? 0 : right[i] - i;
        }
        
        return right;
    }
}
