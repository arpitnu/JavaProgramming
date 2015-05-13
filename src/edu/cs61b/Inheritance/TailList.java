/**
 * 
 */
package edu.cs61b.Inheritance;

/**
 * @author arpitm
 *
 */
class TailList extends SList {
	
	protected SListNode tail;
	
	/**
	 * Default TailList() constructor
	 */
	public TailList() {
		// Constructs an SList, i.e, set head = null and size = 0.
		super();
		this.tail = null;
	}
	
	@Override
	public void insertFront(Object obj) {
		super.insertFront(obj);
		
		if(this.size == 1) {
			this.tail = this.head;
		}
	}
		
	@Override
	public void insertEnd(Object obj) {
		if (this.head == null) {
			
		}
		if(this.tail != null) {
			SListNode tailNode = new SListNode(obj);
			tailNode.next = this.tail.next;
			this.tail.next = tailNode;
			this.tail = tailNode;
			this.size++;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testEmpty();
//		testAfterInsertFront();
//		testAfterInsertEnd();
//		testAfterSquish();
//		testAfterTwin();
	}
	
	/**
	 * testEmpty() tests toString(), isEmpty(), length(), insertFront(), and
	 * insertEnd() on an empty list. Prints summary information of the tests and
	 * halts the program if errors are detected.
	 **/

	private static void testEmpty() {
		TailList lst1 = new TailList();
		TailList lst2 = new TailList();
		System.out.println();
		System.out.println("Here is a list after construction: "
				+ lst1.toString());
		SListTestHelper.verify(lst1.toString().equals("[  ]"),
				"toString on newly constructed list failed");
		System.out
				.println("isEmpty() should be true. It is: " + lst1.isEmpty());
		SListTestHelper.verify(lst1.isEmpty() == true,
				"isEmpty() on newly constructed list failed");

		System.out.println("length() should be 0. It is: " + lst1.length());
		SListTestHelper.verify(lst1.length() == 0,
				"length on newly constructed list failed");
		lst1.insertFront(new Integer(3));
		System.out
				.println("Here is a list after insertFront(3) to an empty list: "
						+ lst1.toString());
		SListTestHelper.verify(lst1.toString().equals("[  3  ]"),
				"InsertFront on empty list failed");
		lst1.insertEnd(new Integer(5));
		System.out
				.println("Here is a list after insertEnd(5) on an empty list: "
						+ lst1.toString());
		SListTestHelper.verify(lst1.toString().equals("[  3  5  ]"),
				"insertEnd on empty list failed");
	}

	/**
	 * testAfterInsertFront() tests toString(), isEmpty(), length(),
	 * insertFront(), and insertEnd() after insertFront(). Prints summary
	 * information of the tests and halts the program if errors are detected.
	 **/

	private static void testAfterInsertFront() {
		SList lst1 = new SList();
		lst1.insertFront(new Integer(3));
		lst1.insertFront(new Integer(2));
		lst1.insertFront(new Integer(1));
		System.out.println();
		System.out.println("Here is a list after insertFront 3, 2, 1: "
				+ lst1.toString());
		SListTestHelper.verify(lst1.toString().equals("[  1  2  3  ]"),
				"InsertFronts on non-empty list failed");
		System.out.println("isEmpty() should be false. It is: "
				+ lst1.isEmpty());
		SListTestHelper.verify(lst1.isEmpty() == false,
				"isEmpty() after insertFront failed");
		System.out.println("length() should be 3. It is: " + lst1.length());
		SListTestHelper.verify(lst1.length() == 3,
				"length() after insertFront failed");
		lst1.insertEnd(new Integer(4));
		System.out.println("Here is the same list after insertEnd(4): "
				+ lst1.toString());
		SListTestHelper.verify(lst1.toString().equals("[  1  2  3  4  ]"),
				"insertEnd on non-empty list failed");
	}

	/**
	 * testAfterInsertEnd() tests toString(), isEmpty(), length(),
	 * insertFront(), and insertEnd() after insertEnd(). Prints summary
	 * information of the tests and halts the program if errors are detected.
	 **/

	private static void testAfterInsertEnd() {
		SList lst1 = new SList();
		lst1.insertEnd(new Integer(6));
		lst1.insertEnd(new Integer(7));
		System.out.println();
		System.out.println("Here is a list after insertEnd 6, 7: "
				+ lst1.toString());
		System.out.println("isEmpty() should be false. It is: "
				+ lst1.isEmpty());
		SListTestHelper.verify(lst1.isEmpty() == false,
				"isEmpty() after insertEnd failed");
		System.out.println("length() should be 2. It is: " + lst1.length());
		SListTestHelper.verify(lst1.length() == 2, "length() after insertEndfailed");
		lst1.insertFront(new Integer(5));
		System.out.println("Here is the same list after insertFront(5): "
				+ lst1.toString());
		SListTestHelper.verify(lst1.toString().equals("[  5  6  7  ]"),
				"insertFront after insertEnd failed");
	}

	private static void testAfterTwin() {
		SList lst1 = new SList();
		lst1.insertEnd(new Integer(0));
		lst1.insertEnd(new Integer(1));
		lst1.insertEnd(new Integer(2));
		lst1.insertEnd(new Integer(3));
		System.out.println();
		System.out.println("Here is a list after insertEnd : "
				+ lst1.toString());
		System.out.println("isEmpty() should be false. It is: "
				+ lst1.isEmpty());
		SListTestHelper.verify(lst1.isEmpty() == false,
				"isEmpty() after insertEnd failed");
		System.out.println("length() should be 4. It is: " + lst1.length());
		SListTestHelper.verify(lst1.length() == 4, "length() after insertEndfailed");
		lst1.twin();
		System.out.println("Here is the same list after twin(): "
				+ lst1.toString());
		SListTestHelper.verify(lst1.toString()
				.equals("[  0  0  1  1  2  2  3  3  ]"), "twin() failed");
	}

	private static void testAfterSquish() {
		SList lst1 = new SList();
		lst1.insertEnd(new Integer(0));
		lst1.insertEnd(new Integer(0));
		lst1.insertEnd(new Integer(0));
		lst1.insertEnd(new Integer(0));
		lst1.insertEnd(new Integer(1));
		lst1.insertEnd(new Integer(1));
		lst1.insertEnd(new Integer(2));
		lst1.insertEnd(new Integer(3));
		lst1.insertEnd(new Integer(3));
		lst1.insertEnd(new Integer(3));
		lst1.insertEnd(new Integer(4));
		lst1.insertEnd(new Integer(0));
		lst1.insertEnd(new Integer(5));
		lst1.insertEnd(new Integer(5));
		System.out.println();
		System.out.println("Here is a list after insertEnd : "
				+ lst1.toString());
		System.out.println("isEmpty() should be false. It is: "
				+ lst1.isEmpty());
		SListTestHelper.verify(lst1.isEmpty() == false,
				"isEmpty() after insertEnd failed");
		System.out.println("length() should be 14. It is: " + lst1.length());
		SListTestHelper
				.verify(lst1.length() == 14, "length() after insertEndfailed");
		lst1.squish();
		System.out.println("Here is the same list after squish(): "
				+ lst1.toString());
		SListTestHelper.verify(lst1.toString().equals("[  0  1  2  3  4  0  5  ]"),
				"squish() failed");
	}

	/*
	 * Get methods for private fields of SList class.
	 */
	public SListNode getHead() {
		return super.getHead();
	}
	
	public SListNode getTail() {
		return this.tail;
	}

	public int getSize() {
		return super.getSize();
	}

}
