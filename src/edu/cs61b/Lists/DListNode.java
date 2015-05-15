/**
 * 
 */
package edu.cs61b.Lists;

/**
 * @author arpitm
 *
 */
class DListNode {
	Object item;
	DListNode next;
	DListNode previous;
	
	public DListNode(Object newItem, DListNode nextNode, DListNode prevNode) {
		this.item = newItem;
		this.next = nextNode;
		this.previous = prevNode;
	}
}
