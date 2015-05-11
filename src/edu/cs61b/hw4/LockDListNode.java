/**
 *  LockableDListNode.java 
 */

package edu.cs61b.hw4;

/**
 * A LockDListNode is a node in a LockDList (lockable doubly-linked list).
 */
class LockDListNode extends DListNode {
	protected boolean isLocked;
	
	public LockDListNode() {
		super();
		this.isLocked = false;
	}

	public LockDListNode(Object item, DListNode prev, DListNode next) {
		super(item, prev, next);
		this.isLocked = false;
	}

	public LockDListNode(Object item) {
		super(item);
		this.isLocked = false;
	}
}
