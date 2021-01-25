package list;

public class InsertionSortList147 {

	private String name = "147. Insertion Sort List";
	private String url = "https://leetcode.com/problems/insertion-sort-list/";
	
    public ListNode insertionSortList(ListNode head) {
        
    	if(head == null) {
    		return head;
    	}
    	
    	head.next = insertionSortList(head.next);
    	ListNode root = head.next;
    	if(root == null || root.val >= head.val) {
    		return head;
    	}
    	
    	ListNode current = root;
    	while(current.next != null && current.next.val < head.val) {    		
    		current = current.next;
    	}
    	
    	head.next = current.next;
    	current.next = head;
    	
    	return root;
    }
    
    public ListNode insertionSortListIterative(ListNode head) {
    	
    	if(head == null) {
    		return null;
    	}
    	
    	ListNode root = new ListNode(0, head);
    	
    	ListNode current = head.next;
    	ListNode previous = head;
    	ListNode iterator;
    	
    	while(current != null) {
    		
    		if(previous.val <= current.val) {
    			previous = current;
    			current = current.next;
    			continue;
    		}
    		
    		iterator = root;
    		while(iterator.next.val < current.val ) {
    			iterator = iterator.next;
    		}
    		
    		previous.next = current.next;
    		current.next = iterator.next;
    		iterator.next = current;   		
    		current = previous.next;		
    		
    	}
    	
    	return root.next;

    }
	
	
}
