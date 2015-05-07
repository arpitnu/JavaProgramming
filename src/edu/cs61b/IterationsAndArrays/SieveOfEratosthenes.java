/**
 * 
 */
package edu.cs61b.IterationsAndArrays;

/**
 * @author arpitm
 * 
 *         Algorithm: All integers are assumed prime until proven composite and for
 *         each possible prime factor we're going to go through all the larger
 *         numbers and eliminate the ones that are multiples of that prime
 *         factor. In other words, we're going to mark as non-prime every
 *         integer that is divisible by a given divisor.
 *
 */
public class SieveOfEratosthenes {

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
		
		n = 50000;
		System.out.println("All primes from 2 to " + n);
		printAllPrimes(n);

	}

	private static void printAllPrimes(int n) {
		// Allocate an array of booleans
		// Size = n + 1 in order to have an index entry for number 'n'
		boolean[] prime = new boolean[n + 1];

		// Assume all number prime until proven composite.
		for (int i = 0; i < n + 1; i++) {
			prime[i] = true;
		}

		for (int d = 2; d * d <= n; d++) {
			if (prime[d]) {
				// Mark all multiples of prime divisor to not prime.
				for (int j = 2 * d; j <= n; j += d) {
					prime[j] = false;
				}
			}
		}

		// Print all primes
		for (int i = 2; i < n + 1; i++) {
			if (prime[i]) {
				System.out.print(i + " ");
			}
		}
	}

}
