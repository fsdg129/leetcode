package list;

public class ReverseLinkedList206 {

	private String name = "206. Reverse Linked List";
	private String url = "https://leetcode.com/problems/reverse-linked-list/";
	
    public static ListNode reverseList(ListNode head) {
    	
    	if(head == null)
    		return head;
    	
    	ListNode pre = null;
    	ListNode current = head;
    	ListNode child;
    	
    	while(true) {
    		if(current == null)
    			break;
    		child = current.next;
    		current.next = pre;
    		pre = current;
    		current = child;
    	}
    	
        return pre;
    }
	
	
    public static ListNode reverseListRecursion(ListNode head) {
        
    	if(head == null || head.next == null) {
    		return head;
    	}
    	
    	ListNode first = reverseListRecursion(head.next);
    	head.next.next = head;
    	head.next = null;
    	
    	return first;
    }
    
    public static ListNode reverseListIterative(ListNode head) {
        
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
