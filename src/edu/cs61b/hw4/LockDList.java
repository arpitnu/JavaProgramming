/**
 * 
 */
package edu.cs61b.hw4;

/**
 * @author arpitm
 *
 */
class LockDList extends DList {

	/**
	 * Default LockDList() constructor.
	 */
	public LockDList() {
		super();
	}

	/**
	 * newNode() calls the DListNode constructor. Use this class to allocate new
	 * LockDListNodes rather than calling the LockDListNode constructor
	 * directly. That way, only this method needs to be overridden if a subclass
	 * of DList wants to use a different kind of node.
	 * 
	 * @param item
	 *            the item to store in the node.
	 * @param prev
	 *            the node previous to this node.
	 * @param next
	 *            the node following this node.
	 */
	@Override
	protected DListNode newNode(Object item, DListNode prev, DListNode next) {
		return new LockDListNode(item, prev, next);
	}

	/**
	 * Function locks the node in the DList.
	 * 
	 * @param node
	 *            the node that needs to be locked
	 */
	public void lockNode(DListNode node) {
		((LockDListNode) node).isLocked = true;
	}

	@Override
	public String toString() {
		String result = "[  ";
		DListNode current = this.head.next;
		while (current != this.head) {
			result = result + current.item + " "
					+ ((LockDListNode) current).isLocked + "  ";
			current = current.next;
		}
		return result + "]";
	}

	/**
	 * main() calls the test functions
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		test1();
	}

	/**
	 * tests1() method tests the lockNode() function.
	 */
	private static void test1() {
		LockDList ldl = new LockDList();
		DListNode ldln1 = new LockDListNode(1);
		DListNode ldln2 = new LockDListNode(2);
		DListNode ldln3 = new LockDListNode(3);
		DListNode ldln4 = new LockDListNode(4);
		DListNode ldln5 = new LockDListNode(5);

		// sentinel
		ldl.head.next = ldln1;
		ldl.head.prev = ldln5;

		// node 1
		ldln1.next = ldln2;
		ldln1.prev = ldl.head;

		// node 2
		ldln2.next = ldln3;
		ldln2.prev = ldln1;

		// node 3
		ldln3.next = ldln4;
		ldln3.prev = ldln2;

		// node 4
		ldln4.next = ldln5;
		ldln4.prev = ldln3;

		// node 5
		ldln5.next = ldl.head;
		ldln5.prev = ldln4;

		ldl.size = 5;

		ldl.lockNode(ldln3);
		ldl.lockNode(ldln5);

		System.out.println();
		System.out.println("Here is a list after construction: "
				+ ldl.toString());
		DListTestHelper.verify(
				ldl.toString().equals(
						"[  1 false  2 false  3 true  4 false  5 true  ]"),
				"toString on newly constructed list failed");
		System.out
				.println("isEmpty() should be false. It is: " + ldl.isEmpty());
		DListTestHelper.verify(ldl.isEmpty() == false,
				"isEmpty() on newly constructed list failed");
	}

}
