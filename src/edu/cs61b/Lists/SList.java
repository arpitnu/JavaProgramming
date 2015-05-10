/**
 * 
 */
package edu.cs61b.Lists;

/*
 * @author arpitm
 * 
 * The SList Abstract data type.
 * 
 * This data type can enforce 2 invariants:
 * 1. "size" is always correct. i.e, we want the 'size' field 
 *    in the class to correctly represent the number of nodes.
 * 2. An SList is never circularly linked.
 * 
 * Both the above goals are accomplished because only SList methods
 * can change the list. SList ensures this by:
 * 1. The fields of SList (head & size) are 'private'.
 * 2. No method of SList returns an SListNode.
 *
 */
public class SList {
	private SListNode head;
	private int size;

	public SList() {
		this.head = null;
		this.size = 0;
	}

	public void insertFront(Object item) {
		this.head = new SListNode(item, this.head);
		this.size++;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public SListNode getHead() {
		return head;
	}

	public void setHead(SListNode head) {
		this.head = head;
	}

}
