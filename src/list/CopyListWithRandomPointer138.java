package list;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer138 {

	private String name = "138. Copy List with Random Pointer";
	private String url = "https://leetcode.com/problems/copy-list-with-random-pointer/";
	
    public static Node copyRandomList(Node head) {
    	
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
    		cur = cur.next;
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
