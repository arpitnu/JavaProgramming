/**
 * 
 */
package edu.cs61b.class3.IterationsAndArrays;

/**
 * @author arpitm
 * 
 *         Determine the maximum of three numbers
 *
 */
public class MaxOfThreeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n1 = 99;
		int n2 = 33;
		int n3 = 100;
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("Max = " + getMax1(n1, n2, n3));

		System.out.println();

		n1 = 99;
		n2 = 101;
		n3 = 100;
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("Max = " + getMax1(n1, n2, n3));

		System.out.println();

		n1 = 111;
		n2 = 101;
		n3 = 100;
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("Max = " + getMax1(n1, n2, n3));

		System.out.println();

		n1 = 99;
		n2 = 99;
		n3 = 100;
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("Max = " + getMax1(n1, n2, n3));
		
		System.out.println();

		n1 = 101;
		n2 = 100;
		n3 = 100;
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("Max = " + getMax1(n1, n2, n3));
		
		System.out.println();

		n1 = 100;
		n2 = 101;
		n3 = 100;
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("Max = " + getMax1(n1, n2, n3));
		
		System.out.println();

		n1 = 99;
		n2 = 99;
		n3 = 99;
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("Max = " + getMax1(n1, n2, n3));
	}

	private static int getMax1(int n1, int n2, int n3) {
		int max;

		if (n1 > n2) {
			if (n1 > n3) {
				max = n1;
			} else {
				max = n3;
			}
		} else if (n2 > n3) {
			max = n2;
		} else {
			max = n3;
		}

		return max;
	}

}
