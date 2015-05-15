/**
 * 
 */
package interviews.practice;

/**
 * @author arpitm
 * 
 *         Program computes the square root of a given number
 *
 */
public class SquareRootOfNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double n = 10.012;
		printSquareRoot(n);
		
		n = 0.0;
		printSquareRoot(n);
		
		n = 1.0;
		printSquareRoot(n);
		
		n = 0.5;
		printSquareRoot(n);
		
		n = 0.25;
		printSquareRoot(n);
		
		n = 1.1;
		printSquareRoot(n);
		
		n = 16;
		printSquareRoot(n);
		
		n = 55.55;
		printSquareRoot(n);
		
		n = -25;
		printSquareRoot(n);
	}

	private static void printSquareRoot(double n) {
		System.out.println("Number: " + n);
		double sqRoot = computeSquareRoot(n);
		System.out.println("Square root: " + sqRoot);
		System.out.println();
	}

	private static double computeSquareRoot(double n) {
		if (n < 0) {
			return -1;
		} else if ((n == 0) || (n == 1)) {
			return n;
		} else {
			// Define the precision.
			double precision = 0.00001;
			double start = 0;
			double end = n;

			// NOTE: We define start and end values because usually for (n > 1),
			// 0 < sqrt(n) < n, but, for (n < 1), 0 < n < sqrt(n).
			if (n < 1) {
				end = 1;
			}

			// Loop to run till the precision is achieved
			while (end - start > precision) {
				double mid = (start + end) / 2;
				double midSqr = mid * mid;
				
				if (midSqr == n) {
					return midSqr;
				} else if (midSqr < n) {
					start = mid;
				} else {
					end = mid;
				}
			}

			// Note if exact value of sqroot is not found, we return the approx
			// value with the defined precision
			return (start + end) / 2;

		}
	}

}
