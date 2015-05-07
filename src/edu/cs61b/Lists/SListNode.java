/**
 * 
 */
package edu.cs61b.Lists;

/**
 * @author arpitm
 * 
 * Singly LinkedList Node
 *
 */
public class SListNode {
	public Object item;
	public SListNode next;
	
	public SListNode() {
		
	}
	
	public SListNode(Object newItem, SListNode nextNode) {
		this.item = newItem;
		this.next = nextNode;
	}

}
