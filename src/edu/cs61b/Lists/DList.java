/**
 * 
 */
package edu.cs61b.Lists;

/*
 * @author arpitm
 * 
 * The Doubly Linked List abstract data type.
 * 
 * This implementation of DList contains a Sentinal. A Sentinal node is 
 * one that does not represent an item. 
 * 
 * Sentinel Node:
 * item --> null
 * next --> first DListNode
 * previous --> last DListNode
 * 
 * The 'previous' of the head node points to the Sentinel
 * The 'next' of the tail node points to the Sentinel
 * 
 * Invariants (with Sentinel node):
 * 1. For any DList d, d.head != null
 * 2. For any DListNode dn, dn.previous != null & dn.next != null
 * 3. For any DListNode dn1, if dn1.next = dn2, then dn2.previous = dn1 and vice-versa
 * 4. The size field is # the number of DListNodes, NOT COUNTING the sentinel, accessible from
 *    sentinel by a sequence of "next"s.
 * 5. The sentinel never stores an item.
 * 
 *
 */
public class DList {
	private DListNode head;
	private DListNode sentinel;
	private long size;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public DListNode getHead() {
		return head;
	}

	public long getSize() {
		return size;
	}

}
