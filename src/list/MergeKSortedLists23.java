package list;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists23 {

	private String name = "23. Merge k Sorted Lists";
	private String url = "https://leetcode.com/problems/merge-k-sorted-lists/";
	
    public ListNode mergeKLists(ListNode[] lists) {
        
    	Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.val, o2.val);
			}
    		
    	});
    	
    	ListNode head = new ListNode(0);
    	for(ListNode node : lists) {
    		if(node != null)
    			queue.add(node);
    	}
    	
    	ListNode pre = head;
    	ListNode current;
    	while(!queue.isEmpty()) {
    		current = queue.poll();
    		pre.next = current;
    		if(current.next != null)
    			queue.add(current.next);
    		pre = current;
    	}
    	
    	return head.next;
    }
	
}
