package tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class SerializeAndDeserializeBinaryTree297Test {

	@Test
	void testVoid() {
		TreeNode root = null;
		SerializeAndDeserializeBinaryTree297 serializer = new SerializeAndDeserializeBinaryTree297();
		String result = serializer.serialize(root);
		assertEquals("x,x", result);
	}
	
	@Test
	void testSingleNode() {
		TreeNode root = new TreeNode(5);
		SerializeAndDeserializeBinaryTree297 serializer = new SerializeAndDeserializeBinaryTree297();
		String result = serializer.serialize(root);
		assertEquals("x,5", result);
	}
	
	@Test
	void testThreeNodes() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		SerializeAndDeserializeBinaryTree297 serializer = new SerializeAndDeserializeBinaryTree297();
		String result = serializer.serialize(root);
		assertEquals("x,5,3,7", result);
	}
	
	
	@Test
	void testDeserializeNone() {
		String result = "x,x";
		SerializeAndDeserializeBinaryTree297 serializer = new SerializeAndDeserializeBinaryTree297();
		TreeNode node = serializer.deserialize(result);
		assertNull(node);
	}
	
	@Test
	void testDeserializeOneNode() {
		String result = "x,3";
		SerializeAndDeserializeBinaryTree297 serializer = new SerializeAndDeserializeBinaryTree297();
		TreeNode node = serializer.deserialize(result);
		assertEquals(3, node.val);
	}
	
	@Test
	void testDeserializeTwoNodes() {
		String result = "x,3,x,-5";
		SerializeAndDeserializeBinaryTree297 serializer = new SerializeAndDeserializeBinaryTree297();
		TreeNode node = serializer.deserialize(result);
		assertEquals(3, node.val);
		assertEquals(-5, node.right.val);
	}
	
	@Test
	void testThreeNodes2() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		SerializeAndDeserializeBinaryTree297.Codec serializer = new SerializeAndDeserializeBinaryTree297.Codec();
		String result = serializer.serialize(root);
		System.out.println(result);
		//assertEquals("x,5,3,7", result);
	}
	
	@Test
	void testDeserializeThreeNodes2() {
		String result = "|5|3|n|n|7|n|n";
		SerializeAndDeserializeBinaryTree297.Codec serializer = new SerializeAndDeserializeBinaryTree297.Codec();
		TreeNode node = serializer.deserialize(result);
		assertEquals(5, node.val);
		assertEquals(7, node.right.val);
	}

}
