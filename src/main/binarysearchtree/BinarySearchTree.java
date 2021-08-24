package main.binarysearchtree;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> {

	// Tracks the number of nodes in this BST
	private int nodeCount = 0;

	// This BST is a rooted tree so we keep track of the root node.
	private Node root = null;

	// Internal node class containing
	// node references and the actual node data
	private class Node {
		T data;
		Node left, right;

		public Node(Node left, Node right, T element) {
			this.left = left;
			this.right = right;
			this.data = element;
		}
	}

	// Get the number of nodes in this BST
	public int size() {
		return nodeCount;
	}

	// Check if the Binary tree is empty
	public Boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Adds an element to this binary tree.
	 * 
	 * @param element The element to add.
	 * @return True if we successfully perfomr an insertion.
	 */
	public boolean add(T element) {
		// Check if the element already exists in the binary tree.
		// if it does, ignore adding it.
		if (contains(element) ) {
			return false;
		}
		// Otherwise add element to the binary tree.
		else {
			root = add(root, element);
			nodeCount++;
			return true;
		}
	}

	// Privately method to recursively add a value in the binary tree.
	private Node add(Node node, T element) {
		// Base case: Found a leaf node
		if (node == null) {
			node = new Node(null, null, element);
		} else {
			// Place lower element values in the left sub-tree
			if (element.compareTo(node.data) < 0) {
				node.left = add(node.left, element);
			} else {
				node.right = add(node.right, element);
			}
		}
		return node;
	}

	// Removes a value from the binary tree if it exists.
	public boolean remove(T element) {
		// Make sure that the node we want to remove actually exists in the binary tree
		// before removing it.
		if (contains(element) ) {
			root = remove(root, element);
			nodeCount--;
			return true;
		} else {
			return false;
		}
	}

	private Node remove(Node node, T element) {
		// Base case check
		if (node == null) {
			return null;
		}
		// determine in which direction do we need to go
		int comp = element.compareTo(node.data);

		// Dig into left subtree. The node we are looking for is less than the current
		// node value.
		if (comp < 0) {
			node.left = remove(node.left, element);
		}
		// Dig into right sub-tree. The node we are looking for is greater than the
		// current node value.
		else if (comp > 0) {
			node.right = remove(node.right, element);
		} else {
			// We found the node that we want to remove
			// This is the case with a right sub tree or no subtree at all. In this
			// situation, just swap the node we wish to remove with its right child.
			if (node.left == null) {
				Node rightChild = node.right;
				node.data = null;
				node = null;
				return rightChild;
			} else if (node.right == null) {
				// This is the case with a left sub tree or no subtree at all. In this
				// situation, just swap the node we wish to remove with its left child.
				Node leftChild = node.left;
				node.data = null;
				node = null;
				return leftChild;

			} else {
				// The case when both nodes exists of the sub tree
				// When removing a node from a binary tree with two links the successor of the
				// node being removed can either be the largest value in the left subtree or the
				// smallest value in the right subtree. In this implementation, I have decided
				// to find the smallest value in the right subtree which can be found by
				// travesing as far left as possible in the right subtree.

				// Find the leftmostNode in the right sub tree.
				Node tmp = digLeft(node.right);

				// Swap the data
				node.data = tmp.data;

				// Go into the right sub-tree and remove the leftmost node we found and swap
				// data with. This prevents us from having two nodes in our tree with the same
				// value.
				node.right = remove(node.right, tmp.data);
			}

		}
		return node;
	}

	// Helper method to find the left most node
	private Node digLeft(Node node) {
		Node current = node;
		while (current.left != null)
			current = current.left;
		return current;
	}

	// Helper method to find the right most node
	private Node digRight(Node node) {
		Node current = node;
		while (current.right != null)
			current = current.right;
		return current;
	}
	
	// Returns true if the element exists in the tree
	public boolean contains(T element) {
		return contains(root, element);
	}
	
	// private recursive method to find an elemnt in a tree
	private boolean contains(Node node, T element) {
		//Base cae: element is null
		if(node==null) {
			return false;
		}
		int comp=element.compareTo(node.data);
		
		// Dig into left sub tree as the value of the element we are looking for is smaller than the current element
		if(comp<0) {
			return contains(node.left,element);
		}else if(comp>0) {
			// Dig into right sub tree as the value of the element we are looking for is greater than the current element
			return contains(node.right, element);
		}else {
			// We found the element we are looking for.
			return true;
		}		
	}
	
	//Computes the height of the tree, O(n)
	public int height() {
		return height(root);
	}
	
	// Recursive helper method to calculate the height of the tree.
	private int height(Node node) {
		if(node==null) {
			return 0;
		}else {
			return Math.max(height(node.left), height(node.right))+1;
		}
	}
	
	// This method returns an iterator for a given TreetraversalOrder
	// There are 4 ways to traverse a tree:
	// preorder, inorder, post order and level order
	public Iterator<T> traverse(TreeTraversalOrder order){
		switch(order) {
			case PRE_ORDER: return preOrderTraversal();
			case IN_ORDER: return inOrderTraversal();
			case POST_ORDER: return postOrderTraversal();
			case LEVEL_ORDER: return levelOrderTraversal();
			default: return null;
		}
	}

	private Iterator<T> levelOrderTraversal() {
		// TODO Auto-generated method stub
		return null;
	}

	private Iterator<T> postOrderTraversal() {
		// TODO Auto-generated method stub
		return null;
	}

	private Iterator<T> inOrderTraversal() {
		// TODO Auto-generated method stub
		return null;
	}

	private Iterator<T> preOrderTraversal() {
		// TODO Auto-generated method stub
		return null;
	}

}
