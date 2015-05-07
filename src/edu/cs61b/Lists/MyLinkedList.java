/**
 * 
 */
package edu.cs61b.Lists;

/**
 * @author arpitm
 * 
 *         Recursive DataType.
 *
 */
public class MyLinkedList {

	static class MyIntNode {
		public int data;
		public MyIntNode next;

		public MyIntNode(int value) {
			this(value, null);
		}

		public MyIntNode(int value, MyIntNode nextNode) {
			this.data = value;
			this.next = nextNode;
		}

		public void insertAfter(int i) {
			this.next = new MyIntNode(i, this.next);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyIntNode n1 = new MyIntNode(1);
		MyIntNode n2 = new MyIntNode(2);
		MyIntNode n3 = new MyIntNode(3);
		MyIntNode n4 = new MyIntNode(4);
		MyIntNode n6 = new MyIntNode(6);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n6;

		printLinkedList(n1);

		n4.insertAfter(5);
		System.out.println();
		printLinkedList(n1);
		
		n1.insertAfter(2);
		System.out.println();
		printLinkedList(n1);
		
		// Insert a new item at the start of the list.
		n1 = new MyIntNode(11, n1);
		System.out.println();
		printLinkedList(n1);

		// MyNode n1 = new MyNode(1, new MyNode(2, new MyNode(3, new MyNode(4,
		// new MyNode(6)))));
	}

	private static void printLinkedList(MyIntNode headNode) {
		MyIntNode curNode = headNode;

		while (curNode.next != null) {
			System.out.print(curNode.data + " --> ");
			curNode = curNode.next;
		}
		
		System.out.print(curNode.data);
	}

}
