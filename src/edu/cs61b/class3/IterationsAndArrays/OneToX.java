/**
 * 
 */
package edu.cs61b.class3.IterationsAndArrays;

/**
 * @author arpitm
 * 
 *         Print all numbers from one to x
 *
 */
public class OneToX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 20;

		System.out.println("Printing all numbers from 1 to " + x);
		
		// Recusrion
		System.out.println("Recusrion:");
		printOneToX(x);
	}

	private static void printOneToX(int x) {
		if (x < 1) {
			return;
		}
		printOneToX(x - 1);
		System.out.print(x + " ");
	}

}
