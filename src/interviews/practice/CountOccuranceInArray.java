/**
 * 
 */
package interviews.practice;

import edu.playground.DSPrinter;

/**
 * @author arpitm
 * 
 *         Program finds the occurrences of a g number in a given sorted array
 *         allowing duplicates.
 *
 */
public class CountOccuranceInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ints = { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 4, 4, 5, 5, 5, 5 };
		int n = 0;
		printOccurrances(n, ints);

		n = 1;
		printOccurrances(n, ints);

		n = 2;
		printOccurrances(n, ints);

		n = 3;
		printOccurrances(n, ints);

		n = 4;
		printOccurrances(n, ints);

		n = 5;
		printOccurrances(n, ints);

		n = 6;
		printOccurrances(n, ints);
	}

	private static void printOccurrances(int n, int[] ints) {
		System.out.print("Input array: ");
		DSPrinter.printIntArray(ints);
		int nOccurances = getOccurance(n, ints, 0, ints.length - 1);
		System.out.println("Number of occurances of " + n
				+ " in the above array: " + nOccurances);
		System.out.println();
	}

	private static int getOccurance(int n, int[] ints, int startIndex,
			int endIndex) {
		if (endIndex < startIndex) {
			return 0;
		} else if (ints[startIndex] > n) {
			return 0;
		} else if (ints[endIndex] < n) {
			return 0;
		} else if ((ints[startIndex] == n) && (ints[endIndex] == n)) {
			return endIndex - startIndex + 1;
		} else {
			int midIndex = (startIndex + endIndex) / 2;
			if (ints[midIndex] == n) {
				return 1 + getOccurance(n, ints, startIndex, midIndex - 1)
						+ getOccurance(n, ints, midIndex + 1, endIndex);
			} else if (ints[midIndex] > n) {
				return getOccurance(n, ints, startIndex, midIndex - 1);
			} else {
				return getOccurance(n, ints, midIndex + 1, endIndex);
			}
		}
	}

}
