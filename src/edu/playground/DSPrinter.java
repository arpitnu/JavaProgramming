/**
 * 
 */
package edu.playground;

/**
 * @author arpitm
 * 
 *         This class contains print helper functions for different data
 *         structures. These functions are used in different programs in this
 *         workspace to print the data structure on the console for testing
 *         purposes.
 * 
 *
 */
public class DSPrinter {
	public static void printIntArray(int[] ints) {
		System.out.print("[ ");

		for (int i : ints) {
			System.out.print(i + " ");
		}

		System.out.print("]");

		System.out.println();
	}
}
