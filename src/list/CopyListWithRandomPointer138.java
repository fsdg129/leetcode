package list;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer138 {

	private String name = "937. Reorder Data in Log Files";
	private String url = "https://leetcode.com/problems/reorder-data-in-log-files/";
	
    public Node copyRandomList(Node head) {
    	
    	if(head == null)
    		return null;
        
    	Node cur = head, newCur, newPre = null;
    	Map<Node, Node> mapper = new HashMap<>();
    	while(cur != null) {
    		newCur = new Node(cur.val);
    		mapper.put(cur, newCur);
    		if(newPre != null)
    			newPre.next = newCur;
    		
    		cur = cur.next;
    		newPre = newCur;
    	}
    	
    	cur = head;
    	while(cur != null) {
    		if(cur.random != null)
    			mapper.get(cur).random = mapper.get(cur.random);
    	}
    	
    	return mapper.get(head);
    }
    
    public static class Node {
        int val;
        Node next = null;
        Node random = null;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
