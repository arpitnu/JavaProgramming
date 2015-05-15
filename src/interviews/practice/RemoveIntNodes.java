/**
 * 
 */
package interviews.practice;

/**
 * @author arpitm
 * 
 *         Given the head node of a singly linked list, where each node contains
 *         a single random character, write an efficient program to remove all
 *         nodes with a numeric character. Assume you have a node data structure
 *         provided for you.
 * 
 *         Example: If you have a linked list “a -> 1 -> b -> 2 -> c” you would
 *         end up with “a -> b -> c”
 *
 */
public class RemoveIntNodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Construct an SList
		SList myList = new SList();
		myList.insertFront('a');
		myList.insertFront('b');
		myList.insertFront('1');
		myList.insertFront('v');
		myList.insertFront('9');
		myList.insertFront('i');
		myList.insertFront('5');
		myList.insertFront('h');
		myList.insertFront('l');
		myList.insertFront('0');
		myList.insertFront('1');
		myList.insertFront('8');
		myList.insertFront('7');

		System.out.println("Input List: " + myList.toString());
		removeIntNodes(myList);
		System.out.println("Updated list: " + myList.toString());
	}

	private static void removeIntNodes(SList myList) {
		// Check if list is empty
		if (myList.size == 0) {
			return;
		}

		while ((myList.head != null) && (isCharNode(myList.head))) {
			myList.head = myList.head.next;
		}

		if (myList.head == null) {
			return;
		}

		SListNode cur = myList.head;

		while (cur.next != null) {
			if (isCharNode(cur.next)) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
	}

	private static boolean isCharNode(SListNode node) {
		return (((char) node.item >= 48) && ((char) node.item <= 57));
	}

	static class SList {
		public SListNode head;
		public int size;

		public SList() {
			this.head = null;
			this.size = 0;
		}

		public void insertFront(Object item) {
			this.head = new SListNode(item, this.head);
			this.size++;
		}

		public String toString() {
			Object obj;
			String result = "[  ";

			SListNode cur = this.head;

			while (cur != null) {
				obj = cur.item;
				result = result + obj.toString() + "  ";
				cur = cur.next;
			}
			result = result + "]";
			return result;
		}
	}

	static class SListNode {
		public Object item;
		public SListNode next;

		public SListNode(Object newItem) {
			this.item = newItem;
			this.next = null;
		}

		public SListNode(Object newItem, SListNode nextNode) {
			this.item = newItem;
			this.next = nextNode;
		}
	}

}
