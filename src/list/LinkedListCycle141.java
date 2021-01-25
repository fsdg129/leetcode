package list;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle141 {

	private String name = "141. Linked List Cycle";
	private String url = "https://leetcode.com/problems/linked-list-cycle/";
	
    public boolean hasCycle(ListNode head) {
        
    	Set<ListNode> nodeSet = new HashSet<>();
    	
    	ListNode current = head;
    	
    	while(current != null) {
    		
    		if(nodeSet.contains(current)) {
    			return true;
    		}
    		nodeSet.add(current);
    		current = current.next;
    	}
    	
    	return false;
    }
    
    public boolean hasCycleConstantSpace(ListNode head) {
        
    	if(head == null) {
    		return false;
    	}
    	
    	ListNode fast = head.next;
    	ListNode slow = head;
    	
    	while(fast != null) {
    		
    		if(slow == fast) {
    			return true;
    		}
    		slow = slow.next;
    		
    		if(fast.next == null) {
    			return false;
    		} else {
    			fast = fast.next.next;
    		}
    	}    	
    	
    	return false;
    }
}
