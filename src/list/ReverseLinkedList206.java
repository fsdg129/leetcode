package list;

public class ReverseLinkedList206 {

	private String name = "206. Reverse Linked List";
	private String url = "https://leetcode.com/problems/reverse-linked-list/";
	
    public ListNode reverseList(ListNode head) {
        
    	if(head == null || head.next == null) {
    		return head;
    	}
    	
    	ListNode first = this.reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
    	
    	return first;
    }
    
    public ListNode reverseListIterative(ListNode head) {
        
    	if(head == null) {
    		return null;
    	}
    	
    	ListNode parent = null;
    	ListNode current = head;
    	ListNode second, third;
    	
    	while(true) {
    		
    		second = current.next;
    		current.next = parent;
    		
    		if(second == null) {
    			return current;
    		}
    		third = second.next;
    		second.next = current;   		    		
    		
    		if(third == null) {
    			return second;
    		}    		
    		parent = second;
    		current = third;
    	}
    	
    }
	
	
}
