package interviews.codeeval.moderate.challenge6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * @author arpitm
 * 
 *         Print out the prime numbers less than a given number N. For bonus
 *         points your solution should run in N*(log(N)) time or better. You may
 *         assume that N is always a positive integer.
 * 
 *         INPUT SAMPLE: Your program should accept as its first argument a path
 *         to a filename. Each line in this file is one test case. Each test
 *         case will contain an integer n < 4,294,967,295. E.g.
 * 
 *         10 
 *         20 
 *         100
 * 
 *         OUTPUT SAMPLE: For each line of input, print out the prime numbers
 *         less than N, in ascending order, comma delimited. (There should not
 *         be any spaces between the comma and numbers) E.g.
 * 
 *         2,3,5,7 
 *         2,3,5,7,11,13,17,19
 *         2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97
 * 
 *
 */
public class NPrimes {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;

		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			int n = Integer.parseInt(line);

			printPrimes(n);
		}

		buffer.close();
	}

	// Function implements Sieve of Eratosthenes algorithm to find all primes
	// from 2 to N
	private static void printPrimes(int n) {
		// Allocate an array of booleans
		// Size = n + 1 in order to have an index entry for number 'n'
		boolean[] primes = new boolean[n + 1];
		int i;

		// Assume all number prime until proven composite.
		for (i = 0; i < n + 1; i++) {
			primes[i] = true;
		}

		for (int d = 2; d * d <= n; d++) {
			if (primes[d]) {
				// Mark all multiples of prime divisor to not prime.
				for (int j = 2 * d; j <= n; j += d) {
					primes[j] = false;
				}
			}
		}

		// Print
		StringBuilder sb = new StringBuilder();

		for (i = 2; i < n + 1; i++) {
			if (primes[i]) {
				if (sb.length() == 0) {
					sb.append(i);
				} else {
					sb.append("," + i);
				}
			}
		}

		System.out.println(sb.toString());
	}

}
