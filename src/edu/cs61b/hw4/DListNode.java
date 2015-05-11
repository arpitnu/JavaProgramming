/**
 *  DListNode.java 
 */

package edu.cs61b.hw4;

/**
 * A DListNode is a node in a DList (doubly-linked list).
 */

class DListNode {

	/**
	 * item references the item stored in the current node. prev references the
	 * previous node in the DList. next references the next node in the DList.
	 *
	 */

	public Object item;
	protected DListNode prev;
	protected DListNode next;

	/**
	 * DListNode() default constructor.
	 */
	public DListNode() {
		this.item = null;
		this.prev = null;
		this.next = null;
	}

	/**
	 * DListNode() constructor.
	 * 
	 * @param i
	 *            the item to store in the node.
	 * @param p
	 *            the node previous to this node.
	 * @param n
	 *            the node following this node.
	 */
	DListNode(Object i, DListNode p, DListNode n) {
		this.item = i;
		this.prev = p;
		this.next = n;
	}

	/**
	 * DListNode() constructor.
	 * 
	 * @param i
	 *            the item to store in the node.
	 */
	DListNode(Object i) {
		this.item = i;
		this.prev = null;
		this.next = null;
	}
}
