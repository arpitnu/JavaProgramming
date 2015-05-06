/**
 * 
 */
package edu.playground;

/**
 * @author arpitm
 * 
 *         Playground for Arrays.
 *
 */
public class ArraysPlayground {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 2;
		int[][] arr1 = { { 3, 4, 5 }, { 1 }, { 11, 12, 13 },
				{ n + 2, n + 1, n, n - 1, n - 2, n - 3 } };
		
		int[] a, b[];
		// Note:
		// Here a is a 1-D array of int
		// b is a 2-D array of int
		
		// When you construct an array of objects, Java does not construct the objects.
		String[] sentence = new String[3];
		sentence[0] = "Hello ";
		sentence[1] = new String();
		// Here sentence[1] points to an empty string.
		// sentence[2] has null reference.
	}

}
