/**
 * 
 */
package edu.cs61b.IterationsAndArrays;

/*
 * @author arpitm
 * 
 * Pascal's Triangle:
 * 											1
 * 										1		1
 * 									1		2		1
 * 								1		3		3		1
 * 							1		4		6		4		1
 * 						1		5		10		10		5		1
 * 
 * Row i represents the coefficients of (x + 1)^i
 * (x + 1)^4 = x^4 + 4x^3 + 6x^2+ 4x + 1 -->  The coefficients of this polynomial are the numbers 
 * in row 4 of Pascal's triangle.
 *
 */
public class PascalsTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// number of rows
		int n = 5;
		int[][] pTriangle = pascalsTriangle(n);
		System.out.println("num rows = " + n);
		System.out.println("Pascal's Triangle: ");
		printPt(n, pTriangle);

		System.out.println();

		n = 7;
		pTriangle = pascalsTriangle(n);
		System.out.println("num rows = " + n);
		System.out.println("Pascal's Triangle: ");
		printPt(n, pTriangle);
	}

	// More work needed on printing
	private static void printPt(int n, int[][] pTriangle) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(pTriangle[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] pascalsTriangle(int n) {
		int[][] pt = new int[n][];

		for (int i = 0; i < n; i++) {
			pt[i] = new int[i + 1];
			pt[i][0] = 1;
			for (int j = 1; j < i; j++) {
				pt[i][j] = pt[i - 1][j - 1] + pt[i - 1][j];
			}
			pt[i][i] = 1;
		}

		return pt;
	}

}
