package main.binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>> {

	// Tracks the number of nodes in this BST
	private int nodeCount=0;
	
	// This BST is a rooted tree so we keep track of the root node.
	private Node root=null;
	
	// Internal node class containing 
	// node references and the actual node data
	private class Node{
		T data;
		Node left, right;
		public Node(Node left, Node right, T data) {
			this.left=left;
			this.right=right;
			this.data=data;
		}
	}
	
	// Get the number of nodes in this BST
	public int size() {
		return nodeCount;
	}
	
	// Check if the Binary tree is empty
	public Boolean isEmpty() {
		return size()==0;
	}
	
	
}
