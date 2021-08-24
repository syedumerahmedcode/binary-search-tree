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
		public Node(Node left, Node right, T element) {
			this.left=left;
			this.right=right;
			this.data=element;
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
	
	/**
	 * Adds an element to this binary tree.
	 * @param element The element to add.
	 * @return True if we successfully perfomr an insertion.
	 */
	public boolean add(T element) {
		// Check if the element already exists in the binary tree.
		// if it does, ignore adding it.
		if(true/*contains(element)*/) {
			return false;
		}
		//Otherwise add element to the binary tree.
		else {
			root=add(root, element);
			nodeCount++;
			return true;
		}		
	}
	
	// Privately method to recursively add a value in the binary tree.
	private Node add(Node node, T element) {
		// Base case: Found a leaft node
		if(node==null) {
			node=new Node(null, null, element);
		}else {
			// Place lower element values in the left sub-tree
			if(element.compareTo(node.data)<0) {
				node.left=add(node.left, element);
			}else {
				node.right=add(node.right, element);
			}
		}
		return node;
	}
	
	
	
	
}
