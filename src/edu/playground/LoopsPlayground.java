/**
 * 
 */
package edu.playground;

/**
 * @author arpitm
 * 
 *         Playground for loops
 *
 */
public class LoopsPlayground {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 3;
		do {
			System.out.println("Index = " + i);
			i--;
		} while (i != 0);

		// IMPORTANT: Note the difference between the loops below
		int j = 0;
		System.out.println("While loop with continue statement.");
		while (j < 10) {
			if (j == 5) {
				continue;
			}
			System.out.print(j + " ");
			j++;
		}
		// Note: In the above loop, when j = 5, the control jumps to the end of
		// the loop body, skipping j++. Hence control again enters the if
		// condition in the subsequent iterations. Which is why it makes sense
		// to use the loop below.

		System.out.println("While loop with continue statement.");
		for (int k = 0; k < 10; k++) {
			if (k == 5) {
				continue;
			}

			System.out.print(k + " ");
		}
	}

}
