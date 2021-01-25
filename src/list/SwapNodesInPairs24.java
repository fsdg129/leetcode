package list;

public class SwapNodesInPairs24 {

	private String name = "24. Swap Nodes in Pairs";
	private String url = "https://leetcode.com/problems/swap-nodes-in-pairs/";
	
    public ListNode swapPairs(ListNode head) {
        
    	ListNode root = new ListNode(0, head);
    	ListNode current = root.next;
    	ListNode parent = root;
    	while(current != null) {
    		
    		parent = swap(current, parent);
    		if(parent == null) {
    			break;
    		}
    		current = parent.next;
    	}
    	
    	return root.next;
    	
    }
    
    private static ListNode swap(ListNode head, ListNode parent) {
    	
    	//No need to check head != null because of the statement of the while loop
    	if(head.next == null) {   		
    		return null;
    	}
    	
    	ListNode first = head;
    	ListNode second = head.next;
    	
    	first.next = second.next;
    	second.next = first;
    	
    	//No need to check parent != null because of the statement of the while loop
    	parent.next = second;    	 	
    	
    	return first;
    	
    }
}
