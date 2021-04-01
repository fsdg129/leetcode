package list;

public class ReverseLinkedListII92 {

	private String name = "92. Reverse Linked List II";
	private String url = "https://leetcode.com/problems/reverse-linked-list-ii/";
	
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        
    	if(head == null)
    		return head;
    	
    	//Set the dummy node as the head of the list node, which doesn't need to change its position
    	ListNode fake = new ListNode(0);
    	fake.next = head;   	
    	
    	//Root node is the last node which doesn't need to change its place
    	//If left = 1; the root node is the fake dummy node.
    	int index = 0;
    	ListNode root = fake;
    	while(index < left - 1) {
    		if(root == null)
    			return head;
    		root = root.next;
    		index++;
    	}
    	
    	//The first node which needs to change its place
    	ListNode start = root.next;
    	
    	//The process of swapping
    	ListNode parent = null;
    	ListNode current = start;
    	ListNode child;
    	int swap = 0;
    	int swapTotal = right - left + 1;
    	while(swap < swapTotal) {
    		if(current == null)
    			break;
    		child = current.next;
    		current.next = parent;
    		parent = current;
    		current = child;
    		swap++;
    	}
    	
    	//Set the pointer of the root node to the new head
    	root.next = parent;
    	//Set the pointer of the start node to the remaining list
    	start.next = current;
    	
    	return fake.next;
    }
}
