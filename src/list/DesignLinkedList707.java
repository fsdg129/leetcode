package list;

public class DesignLinkedList707 {
	
	private ListNode root;
	private ListNode tail;
	private int size;
	
    /** Initialize your data structure here. */
    public DesignLinkedList707() {
        this.root = new ListNode(0);
        this.tail = root;
        this.size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        ListNode parent = this.getNode(index);
        if(parent == null || parent.next == null) {
        	return -1;
        } else {
        	return parent.next.val;
        }

    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        
    	this.addAtIndex(0, val);
    	
    	return;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        
    	this.tail.next = new ListNode(val);
    	this.tail = this.tail.next;
    	this.size++;
    	
    	return;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
    	if(index == this.size) {
    		this.addAtTail(val);
    		return;
    	} 
    	if(index > this.size || index < 0) {
    		return;
    	} 
    	ListNode parent = this.getNode(index);
    	ListNode newNode = new ListNode(val, parent.next);
    	parent.next = newNode;
    	this.size++;
    	
    	return;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        
    	ListNode parent = this.getNode(index);
    	if(parent == null) {
    		return;
    	}
    	parent.next = parent.next.next;
    	
    	if(index == this.size - 1) {
    		this.tail = parent;
    	}
    	this.size--;
    	
    	return;
    	
    }
    
    /** Get the parent node of the index-th node in the linked list. If the index is invalid, return null. */
    private ListNode getNode(int index) {
        if(index + 1 > this.size || index < 0) {
        	return null;
        }
        int counter = index;
        ListNode currentNode = root;
        
        while(counter > 0) {
        	currentNode = currentNode.next;
        	counter--;
        }
        
        return currentNode;
    }
}
