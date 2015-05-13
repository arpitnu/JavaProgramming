/**
 * 
 */
package interviews.wayfair;

/**
 * @author arpitm
 * 
 *         You have an array of negative and positive numbers. Please move all
 *         negative numbers to the left and all positive numbers to the right.
 *         Do so without sorting these numbers to be in numeric order. Example:
 *         Input: [-6, 2, 1, 2, -10, -4, 8] Output: [-6, -10, -4, 2, 1, 2, 8]
 *
 */

public class ShuffleIntArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ints1 = { -6, 2, 1, 2, -10, -4, 8 };
		printAfterShuffle(ints1);

		int[] ints2 = { -1, -2, -10, -2, -5, -4 };
		printAfterShuffle(ints2);

		int[] ints3 = { 1, 2, 10, 2, 5, 4 };
		printAfterShuffle(ints3);

		int[] ints4 = { -11, -1, -10, -2, 5, 4 };
		printAfterShuffle(ints4);

		int[] ints5 = { 11, 1, -10, -2, -5, -4 };
		printAfterShuffle(ints5);
		
		int[] ints6 = { 1 };
		printAfterShuffle(ints6);
	}

	private static void printAfterShuffle(int[] ints) {
		System.out.print("Input Array: ");
		printArray(ints);
		int[] shuffledInts = shuffleIntsArray(ints);
		System.out.print("Maximum Sum Sub Array: ");
		printArray(shuffledInts);
		System.out.println();
	}

	/**
	 * Function sorts the integer array in such a way that all negative integers
	 * are bought to the left side of the array in order and all the positive
	 * integers are bought to the right side.
	 * 
	 * @param ints
	 * @return sorted array of integers
	 */
	private static int[] shuffleIntsArray(int[] ints) {
		int len = ints.length;

		if (len == 0) {
			return null;
		}

		int nNeg = 0;

		if (ints[0] < 0) {
			nNeg++;
		}

		for (int i = 1; i < len; i++) {
			if (ints[i] < 0) {
				int j = i;

				while (j > nNeg) {
					ints[j - 1] += ints[j];
					ints[j] = ints[j - 1] - ints[j];
					ints[j - 1] -= ints[j];
					j--;
				}

				nNeg++;
			}
		}

		return ints;
	}

	private static void printArray(int[] ints) {
		System.out.print("[ ");

		for (int i : ints) {
			System.out.print(i + " ");
		}

		System.out.print("]");

		System.out.println();
	}

}
