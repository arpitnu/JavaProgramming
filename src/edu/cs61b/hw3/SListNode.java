/**
 * SListNode.java
 */
package edu.cs61b.hw3;

/**
 * SListNode is a class used internally by the SList class. An SList object is a
 * singly-linked list, and an SListNode is a node of a singly-linked list. Each
 * SListNode has two references: one to an object, and one to the next node in
 * the list.
 *
 * @author arpitm
 */

class SListNode {
	Object item;
	SListNode next;

	/**
	 * SListNode() (with one parameter) constructs a list node referencing the
	 * item "obj".
	 */
	public SListNode(Object newItem) {
		this.item = newItem;
		this.next = null;
	}

	/**
	 * SListNode() (with two parameters) constructs a list node referencing the
	 * item "obj", whose next list node is to be "next".
	 */
	public SListNode(Object newItem, SListNode nextNode) {
		this.item = newItem;
		this.next = nextNode;
	}

}
