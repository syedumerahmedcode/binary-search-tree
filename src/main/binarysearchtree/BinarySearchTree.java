package main.binarysearchtree;

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
		if (true/* contains(element) */) {
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
		// Make sure that the node we want to remove actually exists in the binary tree before removing it.
		if(true/*contains(element)*/) {
			root=add(root, element);
			nodeCount--;
			return true;
		}else {
			return false;
		}
	}
	
	private Node remove(Node node, T element) {
		// Base case check
		if(node==null) {
			return null;
		}
		// determine in which direction do we need to go
		int comp=element.compareTo(node.data);
		
		// Dig into left subtree. The node we are looking for is less than the current node value.
		if(comp<0) {
			node.left=remove(node.left, element);
		}
		// Dig into right sub-tree. The node we are looking for is greater than the current node value.
		else if(comp>0) {
			node.right=remove(node.right, element);
		}
		else {
			// We found the node that we want to remove
			// This is the case with a right sub tree or no subtree at all. In this situation, just swap the node we wish to remove with its right child.
			if(node.left==null) {
				Node rightChild=node.right;
				node.data=null;
				node=null;
				return rightChild;
			}else if(node.right==null) {
				// This is the case with a left sub tree or no subtree at all. In this situation, just swap the node we wish to remove with its left child.
				Node leftChild=node.left;
				node.data=null;
				node=null;
				return leftChild;
				
			}else {
				// The case when both nodes exists of the sub tree
				// When removing a node from a binary tree with two links the successor of the node being removed can either be the largest value in the left subtree or the smallest value in the right subtree. In this implementation, I have decided to find the smallest value in the right subtree which can be found by travesing as far left as possible in the right subtree.
				
				// Find the leftmostNode in the right sub tree.
				Node tmp=null;//digLeft(node.right);
				
				// Swap the data
				node.data=tmp.data;
				
				// Go into the right sub-tree and remove the leftmost node we found and swap data with. This prevents us from having two nodes in our tree with the same value.
				node.right=remove(node.right, tmp.data);
			}
			
		}
		return node;
	}
	
	

}
