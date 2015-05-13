/* InvalidNodeException.java */

package edu.cs61b.hw5;

/**
 * Implements an Exception that signals an attempt to use an invalid ListNode.
 */

class InvalidNodeException extends Exception {
	protected InvalidNodeException() {
		super();
	}

	protected InvalidNodeException(String s) {
		super(s);
	}
}
