/**
 *  DList.java
 */

package edu.cs61b.hw4;

/*
 * A DList is a mutable doubly-linked list ADT. Its implementation is
 * circularly-linked and employs a sentinel (dummy) node at the head of the
 * list.
 * 
 * DList invariants: 
 * 1) head != null. 
 * 2) For any DListNode x in a DList, x.next != null. 
 * 3) For any DListNode x in a DList, x.prev != null. 
 * 4) For any DListNode x in a DList, if x.next == y, then y.prev == x. 
 * 5) For any DListNode x in a DList, if x.prev == y, then y.next == x. 
 * 6) size is the number of DListNodes, NOT COUNTING the sentinel, 
 *    that can be accessed from the sentinel (head) by a sequence of 
 *    "next" references.
 */

class DList {

	/**
	 * head references the sentinel node. size is the number of items in the
	 * list. (The sentinel node does not store an item.)
	 */

	protected DListNode head;
	protected int size;

	/**
	 * newNode() calls the DListNode constructor. Use this class to allocate new
	 * DListNodes rather than calling the DListNode constructor directly. That
	 * way, only this method needs to be overridden if a subclass of DList wants
	 * to use a different kind of node.
	 * 
	 * @param item
	 *            the item to store in the node.
	 * @param prev
	 *            the node previous to this node.
	 * @param next
	 *            the node following this node.
	 */
	protected DListNode newNode(Object item, DListNode prev, DListNode next) {
		return new DListNode(item, prev, next);
	}

	/**
	 * DList() constructor for an empty DList.
	 */
	public DList() {
		this.head = new DListNode();
		this.head.item = null;
		this.head.next = this.head;
		this.head.prev = this.head;
		this.size = 0;
	}

	/**
	 * isEmpty() returns true if this DList is empty, false otherwise.
	 * 
	 * @return true if this DList is empty, false otherwise. Performance: runs
	 *         in O(1) time.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * length() returns the length of this DList.
	 * 
	 * @return the length of this DList. Performance: runs in O(1) time.
	 */
	public int length() {
		return size;
	}

	/**
	 * insertFront() inserts an item at the front of this DList.
	 * 
	 * @param item
	 *            is the item to be inserted. Performance: runs in O(1) time.
	 */
	public void insertFront(Object item) {
		DListNode newNode = newNode(item, this.head, this.head.next);
		this.head.next.prev = newNode;
		this.head.next = newNode;
		this.size++;
	}

	/**
	 * insertBack() inserts an item at the back of this DList.
	 * 
	 * @param item
	 *            is the item to be inserted. Performance: runs in O(1) time.
	 */
	public void insertBack(Object item) {
		DListNode newNode = newNode(item, this.head.prev, this.head);
		this.head.prev.next = newNode;
		this.head.prev = newNode;
		this.size++;
	}

	/**
	 * front() returns the node at the front of this DList. If the DList is
	 * empty, return null.
	 *
	 * Do NOT return the sentinel under any circumstances!
	 *
	 * @return the node at the front of this DList. Performance: runs in O(1)
	 *         time.
	 */
	public DListNode front() {
		return this.head.next;
	}

	/**
	 * back() returns the node at the back of this DList. If the DList is empty,
	 * return null.
	 *
	 * Do NOT return the sentinel under any circumstances!
	 *
	 * @return the node at the back of this DList. Performance: runs in O(1)
	 *         time.
	 */
	public DListNode back() {
		return this.head.prev;
	}

	/**
	 * next() returns the node following "node" in this DList. If "node" is
	 * null, or "node" is the last node in this DList, return null.
	 *
	 * Do NOT return the sentinel under any circumstances!
	 *
	 * @param node
	 *            the node whose successor is sought.
	 * @return the node following "node". Performance: runs in O(1) time.
	 */
	public DListNode next(DListNode node) {
		if (node == null) {
			return null;
		} else if (this.head.prev == node) {
			return null;
		} else {
			return node.next;
			// DListNode currNode = this.head.next;
			//
			// while (currNode.next != this.head) {
			// if (currNode == node) {
			// return currNode.next;
			// } else {
			// currNode = currNode.next;
			// }
			// }
			//
			// return null;
		}
	}

	/**
	 * prev() returns the node prior to "node" in this DList. If "node" is null,
	 * or "node" is the first node in this DList, return null.
	 *
	 * Do NOT return the sentinel under any circumstances!
	 *
	 * @param node
	 *            the node whose predecessor is sought.
	 * @return the node prior to "node". Performance: runs in O(1) time.
	 */
	public DListNode prev(DListNode node) {
		if (node == null) {
			return null;
		} else if (this.head == node.next) {
			return null;
		} else {
			return node.prev;
			// DListNode currNode = this.head.prev;
			//
			// while (currNode.prev != this.head) {
			// if (currNode == node) {
			// return currNode.prev;
			// } else {
			// currNode = currNode.prev;
			// }
			// }
			//
			// return null;
		}
	}

	/**
	 * insertAfter() inserts an item in this DList immediately following "node".
	 * If "node" is null, do nothing.
	 * 
	 * @param item
	 *            the item to be inserted.
	 * @param node
	 *            the node to insert the item after. Performance: runs in O(1)
	 *            time.
	 */
	public void insertAfter(Object item, DListNode node) {
		if (node == null) {
			return;
		}

		DListNode newNode = newNode(item, node, node.next);
		node.next.prev = newNode;
		node.next = newNode;
		this.size++;

	}

	/**
	 * insertBefore() inserts an item in this DList immediately before "node".
	 * If "node" is null, do nothing.
	 * 
	 * @param item
	 *            the item to be inserted.
	 * @param node
	 *            the node to insert the item before. Performance: runs in O(1)
	 *            time.
	 */
	public void insertBefore(Object item, DListNode node) {
		if (node == null) {
			return;
		}

		DListNode newNode = newNode(item, node.prev, node);
		node.prev.next = newNode;
		node.prev = newNode;
		this.size++;
	}

	/**
	 * remove() removes "node" from this DList. If "node" is null, do nothing.
	 * Performance: runs in O(1) time.
	 */
	public void remove(DListNode node) {
		if (node == null) {
			return;
		}

		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.next = null;
		node.prev = null;
		this.size--;
	}

	/**
	 * nthNode() returns the node at the specified position. If position < 1 or
	 * position > this.length(), null is returned. Otherwise, the item at
	 * position "position" is returned. The list does not change.
	 * 
	 * @param position
	 *            the desired position, from 1 to length(), in the list.
	 * @return the item at the given position in the list.
	 **/
	public DListNode nthNode(int n) {
		if ((n < 1) && (n > this.size)) {
			return null;
		} else {
			DListNode current = this.head.next;
			while (n > 1) {
				current = current.next;
				if (current == null) {
					return null;
				}
				n--;
			}

			return current;
		}
	}

	/**
	 * toString() returns a String representation of this DList.
	 *
	 * DO NOT CHANGE THIS METHOD.
	 *
	 * @return a String representation of this DList. Performance: runs in O(n)
	 *         time, where n is the length of the list.
	 */
	public String toString() {
		String result = "[  ";
		DListNode current = this.head.next;
		while (current != this.head) {
			result = result + current.item + "  ";
			current = current.next;
		}
		return result + "]";
	}

	/**
	 * main() function calls different test functions.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		tests1();
		tests2();
		tests3();
	}

	/**
	 * tests3() function tests the next(), prev and remove() methods of DList.
	 */
	private static void tests3() {
		DList dl = new DList();
		DListNode dln1 = new DListNode(1);
		DListNode dln2 = new DListNode(2);
		DListNode dln3 = new DListNode(3);
		DListNode dln4 = new DListNode(4);
		DListNode dln5 = new DListNode(5);

		// sentinel
		dl.head.next = dln1;
		dl.head.prev = dln5;

		// node 1
		dln1.next = dln2;
		dln1.prev = dl.head;

		// node 2
		dln2.next = dln3;
		dln2.prev = dln1;

		// node 3
		dln3.next = dln4;
		dln3.prev = dln2;

		// node 4
		dln4.next = dln5;
		dln4.prev = dln3;

		// node 5
		dln5.next = dl.head;
		dln5.prev = dln4;

		dl.size = 5;

		System.out.println();
		System.out.println("Here is a list after construction: "
				+ dl.toString());
		DListTestHelper.verify(dl.toString().equals("[  1  2  3  4  5  ]"),
				"toString on newly constructed list failed");
		System.out.println("isEmpty() should be false. It is: " + dl.isEmpty());
		DListTestHelper.verify(dl.isEmpty() == false,
				"isEmpty() on newly constructed list failed");

		// next()
		if (dl.next(dln1) == dln2) {
			System.out
					.println("next() works fine. Returns dln2 as next node of dln1");
		} else {
			DListTestHelper.verify(dl.next(dln1) == dln2,
					"next() does not return the correct node from the list.");
		}

		if (dl.next(dln5) == null) {
			System.out.println("next() works fine. Returns null for dln5");
		} else {
			DListTestHelper.verify(dl.next(dln1) == dln2,
					"next() does not return the correct node from the list.");
		}

		// prev
		if (dl.prev(dln5) == dln4) {
			System.out
					.println("prev() works fine. Returns dln4 as next node of dln5");
		} else {
			DListTestHelper.verify(dl.next(dln1) == dln2,
					"prev() does not return the correct node from the list.");
		}

		if (dl.prev(dln1) == null) {
			System.out.println("prev() works fine. Returns null for dln1");
		} else {
			DListTestHelper.verify(dl.next(dln1) == dln2,
					"prev() does not return the correct node from the list.");
		}

		// remove()
		dl.remove(dln1);
		System.out.println("Here is a list after remove(dln1): "
				+ dl.toString());
		DListTestHelper.verify(dl.toString().equals("[  2  3  4  5  ]"),
				"InsertFront on empty list failed");
		dl.remove(dln5);
		System.out.println("Here is a list after remove(dln5): "
				+ dl.toString());
		DListTestHelper.verify(dl.toString().equals("[  2  3  4  ]"),
				"InsertFront on empty list failed");
		dl.remove(dln3);
		System.out.println("Here is a list after remove(dln3): "
				+ dl.toString());
		DListTestHelper.verify(dl.toString().equals("[  2  4  ]"),
				"InsertFront on empty list failed");
	}

	/**
	 * tests2() method tests the length(), front() and back() methods of DList
	 */
	private static void tests2() {
		DList dl = new DList();
		dl.insertFront(0);
		dl.insertBack(1);
		dl.insertBack(2);
		dl.insertBack(3);
		dl.insertBack(4);
		System.out.println();
		System.out.println("Here is a list after construction: "
				+ dl.toString());
		DListTestHelper.verify(dl.toString().equals("[  0  1  2  3  4  ]"),
				"toString on newly constructed list failed");
		System.out.println("isEmpty() should be false. It is: " + dl.isEmpty());
		DListTestHelper.verify(dl.isEmpty() == false,
				"isEmpty() on newly constructed list failed");
		System.out.println("length of the list should be 5. It is "
				+ dl.length());
		DListTestHelper.verify(dl.length() == 5,
				"length() returns wrong length of the list.");
		if (dl.front() == dl.head.next) {
			System.out
					.println("The front() function returns the first node in the list correctly.");
		} else {
			System.out
					.println("The front() function returns the first node in the list incorrectly.");
		}

		if (dl.back() == dl.head.prev) {
			System.out
					.println("The back() function returns the last node in the list correctly.");
		} else {
			System.out
					.println("The back() function returns the last node in the list incorrectly.");
		}

	}

	/**
	 * Function tests DList creation, isEmpty(), toString(), insertFront(),
	 * insertBack() functions
	 */
	private static void tests1() {
		DList dl = new DList();
		System.out.println();
		System.out.println("Here is a list after construction: "
				+ dl.toString());
		DListTestHelper.verify(dl.toString().equals("[  ]"),
				"toString on newly constructed list failed");
		System.out.println("isEmpty() should be true. It is: " + dl.isEmpty());
		DListTestHelper.verify(dl.isEmpty() == true,
				"isEmpty() on newly constructed list failed");
		dl.insertFront(new Integer(3));
		System.out
				.println("Here is a list after insertFront(3) to an empty list: "
						+ dl.toString());
		DListTestHelper.verify(dl.toString().equals("[  3  ]"),
				"InsertFront on empty list failed");
		dl.insertFront(new Integer(5));
		System.out
				.println("Here is a list after insertFront(5) to an empty list: "
						+ dl.toString());
		DListTestHelper.verify(dl.toString().equals("[  5  3  ]"),
				"InsertFront on empty list failed");
		dl.insertBack(new Integer(7));
		System.out
				.println("Here is a list after insertBack(7) to an empty list: "
						+ dl.toString());
		DListTestHelper.verify(dl.toString().equals("[  5  3  7  ]"),
				"InsertFront on empty list failed");
	}
}
