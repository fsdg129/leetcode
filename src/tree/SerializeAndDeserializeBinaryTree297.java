package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SerializeAndDeserializeBinaryTree297 {

	private String name = "297. Serialize and Deserialize Binary Tree";
	private String url = "https://leetcode.com/problems/serialize-and-deserialize-binary-tree/";
	
	private Map<Integer, Integer> treeMap = new HashMap<>();
	private Deque<TreeNodeWithIndex> stack = new LinkedList<>();
	
	public final String seperator = ",";
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	
    	if(root == null) {
    		return "x" + this.seperator + "x";
    	}
    	
        this.treeMap.clear();
        this.stack.clear();
        
        this.stack.add(new TreeNodeWithIndex(1, root));
        
        int nodeNumber = 0;
        TreeNodeWithIndex currentNode;
        while(!this.stack.isEmpty()) {
        	
        	currentNode = this.stack.pop();
        	this.treeMap.put(currentNode.getIndex(), currentNode.getTreeNode().val);
        	nodeNumber = Math.max(currentNode.getIndex(), nodeNumber);
        	
        	if(currentNode.getTreeNode().left != null) {
        		this.stack.add(new TreeNodeWithIndex(currentNode.getIndex()*2, currentNode.getTreeNode().left));
        	}
        	if(currentNode.getTreeNode().right != null) {
        		this.stack.add(new TreeNodeWithIndex(currentNode.getIndex()*2 + 1, currentNode.getTreeNode().right));
        	}
        	
        }
        
       
        StringBuilder sb = new StringBuilder("x");
        for(int i = 1; i <= nodeNumber; i++) {
        	if(this.treeMap.containsKey(i)) {
        		sb.append(this.seperator + this.treeMap.get(i).toString());
        	} else {
        		sb.append(this.seperator + "x");
        	}
        }
        
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    	
    	String[] valueArray = data.split(this.seperator);
    	List<TreeNode> treeNodeList = new ArrayList<>(valueArray.length);
    	
    	String value;
    	TreeNode currentNode;
    	for(int i = 0; i<valueArray.length; i++) {
    		
    		value = valueArray[i];
    		if(value.equals("x")) {
    			treeNodeList.add(null);
    			continue;
    		}
    		
			currentNode = new TreeNode(Integer.valueOf(value));  
			treeNodeList.add(currentNode);
    			
			if(i <= 1) {
				continue;
			}
			if(i % 2 == 0) {
				treeNodeList.get(i/2).left = currentNode;
			} else {
				treeNodeList.get((i-1)/2).right = currentNode;
			}			
    		
    	}
    	
    	return treeNodeList.get(1);
    }
    
    public class TreeNodeWithIndex {
    	
    	private int index;
    	private TreeNode treeNode;
		/**
		 * @param index
		 * @param treeNode
		 */
		public TreeNodeWithIndex(int index, TreeNode treeNode) {
			super();
			this.index = index;
			this.treeNode = treeNode;
		}
		/**
		 * @return the index
		 */
		public int getIndex() {
			return index;
		}
		/**
		 * @param index the index to set
		 */
		public void setIndex(int index) {
			this.index = index;
		}
		/**
		 * @return the treeNode
		 */
		public TreeNode getTreeNode() {
			return treeNode;
		}
		/**
		 * @param treeNode the treeNode to set
		 */
		public void setTreeNode(TreeNode treeNode) {
			this.treeNode = treeNode;
		}
    	
    	
    }
}
