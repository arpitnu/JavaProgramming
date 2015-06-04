/**
 * 
 */
package interviews.practice;

import edu.playground.DSPrinter;

/**
 * @author arpitm
 * 
 *         Program finds the first index of an integer in a sorted array of
 *         integers allowing duplicates.
 * 
 *         Approach: Binary Search But traditional binary search only returns
 *         the index when a number is found
 * 
 *         So once the number is found, continue to shrink the focused
 *         sub-array, until we find a sub-array which starts with the input key.
 *
 */
public class FindFirstIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ints1 = {};
		printIndexOfN(ints1, 1);

		int[] ints2 = { 1 };
		printIndexOfN(ints2, 1);

		int[] ints3 = { 1, 2, 2, 2, 3, 3, 3, 3, 7, 7, 7, 7, 8 };
		printIndexOfN(ints3, 1);
		printIndexOfN(ints3, 2);
		printIndexOfN(ints3, 3);
		printIndexOfN(ints3, 4);
		printIndexOfN(ints3, 7);
		printIndexOfN(ints3, 8);
		printIndexOfN(ints3, 11);
	}

	private static void printIndexOfN(int[] ints, int n) {
		if (ints.length == 0) {
			System.out.println("Empty input array. Integer not found.");
		} else if (ints.length == 1) {
			System.out.print("Input integer array: ");
			DSPrinter.printIntArray(ints);
			if (ints[0] == n) {
				System.out.println("Index of " + n + " is 0");
			}
		} else {
			System.out.print("Input integer array: ");
			DSPrinter.printIntArray(ints);
			System.out.println("Index of " + n + " is "
					+ getFirstIndex(n, ints, 0, ints.length - 1));
		}

		System.out.println();
	}

	private static int getFirstIndex(int n, int[] ints, int start, int end) {
		// Check if sub-array is valid
		if (end < start) {
			return -1; // No more array elements left for analyzing.
		} else if (ints[start] > n) {
			return -1; // Smallest element in the sub-array is larger than n,
						// possibility of n being present in the sub array is 0.
		} else if (ints[end] < n) {
			return -1; // Largest element in the sub-array is smaller than n,
						// possibility of n being present in the sub array is 0.
		} else {
			if (ints[start] == n) {
				return start; // Here we have found n, now we need to find the
								// first occurrence of n.
			}

			// Binary search
			int mid = (start + end) / 2;

			if (ints[mid] == n) {
				// There are 2 choices here. Either mid position is the first
				// occurrence or the first occurrence of n is left to the mid
				// position.
				int leftIndex = getFirstIndex(n, ints, start, mid - 1);
				return (leftIndex == -1) ? mid : leftIndex;
			} else if (ints[mid] > n) {
				// This means, the first occurrence of n is to the left of the
				// mid position.
				return getFirstIndex(n, ints, start, mid - 1);
			} else {
				// Only possible in the right half.
				return getFirstIndex(n, ints, mid + 1, end);
			}
		}
	}

}
