/**
 * 
 */
package edu.cs61b.hw3;

/**
 * @author arpitm
 * 
 *         Program reverses an SList
 *
 */
public class ReverseSList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Define an SList
		SList sl = new SList();
		sl.insertEnd(1);
		sl.insertEnd(2);
		sl.insertEnd(3);
		sl.insertEnd(4);
		sl.insertEnd(5);
		sl.insertEnd(6);
		sl.insertEnd(7);
		printreversedList(sl);
	}

	private static void printreversedList(SList sl) {
		System.out.println();
		System.out.print("Input SList: " + sl.toString());
		SList reversedSl = reverseSList(sl);
		System.out.println();
		System.out.print("Reversed List: " + reversedSl.toString());
	}

	/**
	 * This implementation obviously uses the insertFront() method already
	 * defined in SList. This is not the best solution to reverse a list. Check
	 * the reverse() function implementation in SList class for in place
	 * reversal of an SList.
	 * 
	 * @param sl
	 * @return
	 */
	private static SList reverseSList(SList sl) {
		if ((sl == null) || sl.isEmpty()) {
			return null;
		}

		SList newList = new SList();
		SListNode currSlNode = sl.getHead();

		while (currSlNode.next != null) {
			newList.insertFront(currSlNode.item);
			currSlNode = currSlNode.next;
		}

		return newList;
	}

}
