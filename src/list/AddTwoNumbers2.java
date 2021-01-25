package list;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers2 {
	
	private String name = "2. Add Two Numbers";
	private String url = "https://leetcode.com/problems/add-two-numbers/";
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	int value1, value2, sum;
    	
    	ListNode currentNode1 = l1;
    	ListNode currentNode2 = l2;
    	int add = 0;
    	
    	ListNode root = new ListNode(0);
    	ListNode result = root;
    	
    	while(currentNode1 != null || currentNode2 != null || add != 0) {
    		
    		if(currentNode1 == null) {
    			value1 = 0;
    		} else {
    			value1 = currentNode1.val;
    			currentNode1 = currentNode1.next;
    		}
    		
    		if(currentNode2 == null) {
    			value2 = 0;
    		} else {
    			value2 = currentNode2.val;
    			currentNode2 = currentNode2.next;
    		}
    		
    		sum = value1 + value2 + add;
    		result.next = new ListNode(sum % 10);
    		result = result.next;
    		add = sum < 10 ? 0 : 1;
    	}
    	
    	return root.next;
    }

}
