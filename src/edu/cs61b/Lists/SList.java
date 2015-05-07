/**
 * 
 */
package edu.cs61b.Lists;

/**
 * @author arpitm
 * 
 * The SList class.
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
