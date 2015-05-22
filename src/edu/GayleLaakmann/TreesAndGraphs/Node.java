/**
 * 
 */
package edu.GayleLaakmann.TreesAndGraphs;

/**
 * @author arpitm
 *
 */
class Node {
	Object item;
	Node left;
	Node right;

	public Node() {
		this.item = this.left = this.right = null;
	}

	public Node(Object newItem) {
		this.item = newItem;
		this.left = this.right = null;
	}

	public Node(Object newItem, Node leftNode, Node rightNode) {
		this.item = newItem;
		this.left = leftNode;
		this.right = rightNode;
	}

}
