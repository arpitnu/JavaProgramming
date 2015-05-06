/**
 * 
 */
package edu.cs61b.class3.IterationsAndArrays;

/**
 * @author arpitm
 * 
 *         Code prints all prime numbers from 2 to n.
 *
 */
public class AllPrimes2ToN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 133;
		System.out.println("All primes from 2 to " + n);
		printAllPrimes(n);
		
		System.out.println();

		n = 55;
		System.out.println("All primes from 2 to " + n);
		printAllPrimes(n);
		
		System.out.println();
		
		n = 907;
		System.out.println("All primes from 2 to " + n);
		printAllPrimes(n);
		
		System.out.println();
		
		n = 3;
		System.out.println("All primes from 2 to " + n);
		printAllPrimes(n);
		
		System.out.println();
		
		n = 2;
		System.out.println("All primes from 2 to " + n);
		printAllPrimes(n);

	}

	private static void printAllPrimes(int n) {
		for (int i = 2; i <= n; i++) {
			if (isNumPrime(i)) {
				System.out.print(i + " ");
			}
		}
		
		// At this point (when for loop is done) i = n + 1
	}

	private static boolean isNumPrime(int num) {
		int divisor = 2;

		while (divisor < num) {
			if ((num % divisor) == 0) {
				return false;
			}

			divisor++;
		}

		return true;
	}

}
