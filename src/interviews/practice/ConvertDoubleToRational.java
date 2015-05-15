/**
 * 
 */
package interviews.practice;

/*
 * @author arpitm
 * 
 *         Program converts a double to rational. For example if the input is
 *         -0.125, the output should be -1/8
 * 
 *         Approach: 
 *         1. Multiply 10^x to make double to integer. E.g, 0.125 *
 *         1000 = 125 Thus 0.125 = 125/1000 
 *         2. Find Greatest Common Divisor of
 *         both divisors and dividend. 
 *         3.Return the result.
 *
 */
public class ConvertDoubleToRational {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double n = 0.125;
		printRational(n);

		n = -0.125;
		printRational(n);

		n = 0;
		printRational(n);

		n = -1.125;
		printRational(n);

		// Note: tenPow for this is greater than Integer.MAX_VALUE and hence
		// long is required.
		n = 6.00000000222;
		printRational(n);
		
		n = -9.129874;
		printRational(n);
	}

	private static void printRational(double n) {
		if (n == 0) {
			System.out.println("Zero input.");
			System.out.println();
			return;
		}

		boolean nIsNegative = false;

		if (n < (double) 0) {
			nIsNegative = true;
			n *= -1;
		}

		// Find 10^x. This way of finding 10^x is not suitable if the precision
		// of the input number is high.
		long tenPow = 1;
		while ((n * tenPow) - (long) (n * tenPow) != 0) {
			tenPow *= 10;
		}

		long dividend = (int) (n * tenPow);
		long divisor = tenPow;

		// Find the GCD of dividend and divisor.
		long gcd = 0;
		if (dividend > divisor) {
			gcd = findGCD(dividend, divisor);
		} else {
			gcd = findGCD(divisor, dividend);
		}

		dividend /= gcd;
		divisor /= gcd;

		String rationalOutput = (nIsNegative ? (n + " = -" + dividend + "/" + divisor)
				: (n + " = " + dividend + "/" + divisor));
		System.out.println(rationalOutput);
		System.out.println();
	}

	private static long findGCD(long dividend, long divisor) {
		long remainder = dividend % divisor;

		if (remainder == 0) {
			return divisor;
		} else {
			return findGCD(divisor, remainder);
		}
	}

}
