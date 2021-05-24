package list;

public class ReverseNodesInKGroup25 {

	private String name = "124. Binary Tree Maximum Path Sum";
	private String url = "https://leetcode.com/problems/binary-tree-maximum-path-sum/";
	
    public static ListNode reverseKGroup(ListNode head, int k) {
        
    	//preFirst -> first -> ... -> last -> postLast
    	ListNode first = head, last, current, postLast;
    	ListNode root = null, preFirst = null;
    	
    	while(first != null) {
	    	current = first;
	    	//Check if there are k listnodes left
	    	for(int i=1; i<k; i++) {
	    		if(current == null) {
	    			break;
	    		}
	    		current = current.next;
	    	}
	    	last = current;
	    	
	    	//There is no enough nodes, and the remaining nodes needn't to be reversed
	    	if(last == null) {
	    		break;
	    	}
	    	
	    	//Reverse this part of list and concatenate the gap in two ends
	    	postLast = last.next;
	    	reverse(first, last);
	    	first.next = postLast;
	    	if(preFirst != null)
	    		preFirst.next = last;
	    	
	    	//Update preFist and first for next iteration
	    	preFirst = first;
	    	first = postLast;
	    	
	    	//If this is the first group to be reversed, store the new head
	    	if(root == null)
	    		root = last;
    	}
    	
    	return root;
    }
    
    private static void reverse(ListNode first, ListNode last) {
    	ListNode current = first;
    	ListNode next;
    	ListNode newHead = null;
    	while(true) {
    		next = current.next;
    		current.next = newHead;
    		newHead = current;
    		if(current == last)
    			break;
    		current = next;
    	}
    	
    	return;
    }
}
