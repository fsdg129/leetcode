package list;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache146 {

	private String name = "146. LRU Cache";
	private String url = "https://leetcode.com/problems/lru-cache/";
	
	public static void main(String[] args) {
		
		LRUCache cache = new LRUCache(3);
		cache.put(1, 1);
		System.out.println(cache.toString());
		cache.put(2, 2);
		System.out.println(cache.toString());
		cache.put(3, 3);
		System.out.println(cache.toString());
		cache.put(4, 4);
		System.out.println(cache.toString());
		cache.get(4);
		System.out.println(cache.toString());
		cache.get(3);
		System.out.println(cache.toString());
		cache.get(2);
		System.out.println(cache.toString());
		cache.get(1);
		System.out.println(cache.toString());
		cache.put(5, 5);
		System.out.println(cache.toString());
		cache.get(1);
		System.out.println(cache.toString());
		cache.get(2);
		System.out.println(cache.toString());
		cache.get(3);
		System.out.println(cache.toString());
		cache.get(4);
		System.out.println(cache.toString());
		cache.get(5);
		System.out.println(cache.toString());		
		
	}
	
	public static class LRUCache2 extends LinkedHashMap<Integer, Integer> {
		
		private int capacity;
		
	    public LRUCache2(int capacity) {
	    	super(capacity, 0.75F, true);
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        return super.getOrDefault(key, -1);
	    }
	    
	    public void put(int key, int value) {
	        super.put(key, value);
	    }
	    
	    @Override
	    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
	        return super.size() > this.capacity; 
	    }
	}
	
	public static class LRUCache {
		
		private Map<Integer, Node> mapper;
		private Node root = new Node();
		private Node tail = null;
		private int size = 0;
		private final int capacity;
		
	    public LRUCache(int capacity) {
	        super();
	        this.mapper = new HashMap<>();
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	    	Node current;
	        if(this.mapper.containsKey(key)) {
	        	current = this.mapper.get(key);
	        	this.moveToHead(current);
	        	return current.val;
	        } else {
	        	return -1;
	        }
	    }
	    
	    public void put(int key, int value) {
	    	Node current;
	        if(this.mapper.containsKey(key)) {
	        	current = this.mapper.get(key);
	        	current.val = value;
	        	this.moveToHead(current);
	        } else {
	        	current = new Node(key, value);
	        	this.mapper.put(key, current);
	        	this.insertAfterRoot(current);
	        	this.size++;
	        	if(this.tail == null) {
	        		tail = current;
	        	}
	        	if(this.size > this.capacity) {
	        		Node last = this.tail;
	        		this.mapper.remove(last.key);
	        		this.shrinkTail();	        			        		
	        		this.size--;
	        	}
	        }	        
	        
	        return;
	    }
	    
	    @Override
	    public String toString() {
	    	StringBuilder sb = new StringBuilder();
	    	Node current = this.root.next;
	    	while(current != null) {
	    		sb.append(current.val);
	    		if(current.prev.next != current) {
	    			sb.append("(false)");
	    			sb.append(current.prev.val);
	    		}
	    		sb.append("->");
	    		
	    		current = current.next;
	    	}
	    	sb.append("null");
	    	
	    	return sb.toString();
	    }
	    
	    private void shrinkTail() {
	    	this.tail = this.tail.prev;
    		this.tail.next = null;
	    }
	    
	    private static void linkConcatenate(Node pre, Node current) {
	    	pre.next = current;
	    	if(current != null)
	    		current.prev = pre;
	    	
	    	return;
	    }
	    
	    private void moveToHead(Node current) {
	    	if(current.prev == this.root) {
	    		return;
	    	}
	    	if(this.tail == current) {
	    		this.shrinkTail();
	    	}
	    	//Fill the gap after the current node was taking out of the linkedlist
	    	linkConcatenate(current.prev, current.next);
	    	this.insertAfterRoot(current);
	    	
	    	return;
	    }	    
	    
	    //Move the isolated node to the head of the linkedlist
	    private void insertAfterRoot(Node current) {
	    	Node originalFirstNode = this.root.next;
	    	linkConcatenate(root, current);
	    	linkConcatenate(current, originalFirstNode);
	    	
	    	return;
	    }
	    
	    private static class Node {
	    	public int key = 0;
	    	public int val = 0;	    	
	    	public Node prev = null;
	    	public Node next = null;
	    	
	    	public Node(){
	    		super();
	    	}
	    	
	    	public Node(int key, int val) {
	    		this();
	    		this.key = key;
	    		this.val = val;
	    	}
	    }
	}
	
}
