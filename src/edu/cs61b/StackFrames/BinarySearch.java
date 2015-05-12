/**
 * 
 */
package edu.cs61b.StackFrames;

/**
 * @author arpitm
 *
 *         Program uses recursion to implement Binary Search algorithm. This
 *         program also demonstrates stack frames along with recursion.
 * 
 *         ln(n) recursive binarySearch calls to pare down the possibilities to
 *         one. That is why we say, binary search algorithm takes logarithmic
 *         time in n.
 */
class BinarySearch {

	public static final int FAILURE = -1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { -3, -2, -2, -2, -2, -1, 0, 0, 0, 0, 0, 1, 1, 2, 3, 4, 5 };

		int findMe = -3;
		int findMeIndex = binarySearch(array, 0, array.length - 1, findMe);
		System.out.println(findMeIndex == -1 ? "Item not present in array"
				: "Index of " + findMe + ": " + findMeIndex);
		System.out.println();

		findMe = -2;
		findMeIndex = binarySearch(array, 0, array.length - 1, findMe);
		System.out.println(findMeIndex == -1 ? "Item " + findMe
				+ " not present in array" : "Index of " + findMe + ": "
				+ findMeIndex);
		System.out.println();

		findMe = -1;
		findMeIndex = binarySearch(array, 0, array.length - 1, findMe);
		System.out.println(findMeIndex == -1 ? "Item " + findMe
				+ " not present in array" : "Index of " + findMe + ": "
				+ findMeIndex);
		System.out.println();

		findMe = 0;
		findMeIndex = binarySearch(array, 0, array.length - 1, findMe);
		System.out.println(findMeIndex == -1 ? "Item " + findMe
				+ " not present in array" : "Index of " + findMe + ": "
				+ findMeIndex);
		System.out.println();

		findMe = 1;
		findMeIndex = binarySearch(array, 0, array.length - 1, findMe);
		System.out.println(findMeIndex == -1 ? "Item not present in array"
				: "Index of " + findMe + ": " + findMeIndex);
		System.out.println();

		findMe = 2;
		findMeIndex = binarySearch(array, 0, array.length - 1, findMe);
		System.out.println(findMeIndex == -1 ? "Item " + findMe
				+ " not present in array" : "Index of " + findMe + ": "
				+ findMeIndex);
		System.out.println();

		findMe = 3;
		findMeIndex = binarySearch(array, 0, array.length - 1, findMe);
		System.out.println(findMeIndex == -1 ? "Item not present in array"
				: "Index of " + findMe + ": " + findMeIndex);
		System.out.println();

		findMe = 4;
		findMeIndex = binarySearch(array, 0, array.length - 1, findMe);
		System.out.println(findMeIndex == -1 ? "Item " + findMe
				+ " not present in array" : "Index of " + findMe + ": "
				+ findMeIndex);
		System.out.println();

		findMe = 5;
		findMeIndex = binarySearch(array, 0, array.length - 1, findMe);
		System.out.println(findMeIndex == -1 ? "Item " + findMe
				+ " not present in array" : "Index of " + findMe + ": "
				+ findMeIndex);
		System.out.println();

		findMe = 6;
		findMeIndex = binarySearch(array, 0, array.length - 1, findMe);
		System.out.println(findMeIndex == -1 ? "Item " + findMe
				+ " not present in array" : "Index of " + findMe + ": "
				+ findMeIndex);
		System.out.println();
	}

	private static int binarySearch(int[] array, int left, int right, int findMe) {
		if (left > right) {
			return FAILURE;
		}

		int mid = (left + right) / 2;
		if (findMe == array[mid]) {
			return mid;
		} else if (findMe < array[mid]) {
			return binarySearch(array, left, mid - 1, findMe);
		} else {
			return binarySearch(array, mid + 1, right, findMe);
		}
	}

}
