package interviews.codeeval.oc.DeveloperAuction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * 
 * @author arpitm
 * 
 *         The problem is as follows: choose a number, reverse its digits and
 *         add it to the original. If the sum is not a palindrome (which means,
 *         it is not the same number from left to right and right to left),
 *         repeat this procedure.
 * 
 *         For example: 
 *         195 (initial number) + 591 (reverse of initial number) = 786 
 *         786 + 687 = 1473 
 *         1473 + 3741 = 5214 
 *         5214 + 4125 = 9339 (palindrome)
 * 
 *         Your program should accept as its first argument a path to a
 *         filename. Each line in this file is one test case. Each test case
 *         will contain an integer n < 10,000. Assume each test case will always
 *         have an answer and that it is computable with less than 100
 *         iterations (additions).
 * 
 *         OUTPUT SAMPLE: For each line of input, generate a line of output
 *         which is the number of iterations (additions) to compute the
 *         palindrome and the resulting palindrome. (they should be on one line
 *         and separated by a single space character).
 * 
 *         For example: 4 9339
 *
 */
public class ReverseAndAddPalindrome {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			// Process line of input Here
			int nIterations = 0;
			int maxIterations = 100; // From question we know that palingrom of
										// sum can be found within 100
										// iterations
			long N = Integer.parseInt(line);
			long curSum = 0;

			while (nIterations < maxIterations) {
				long reverseOfN = getReverseOf(N);
				curSum = N + reverseOfN;

				if (isPalindrome(curSum)) {
					System.out.println(nIterations + 1 + " " + curSum);
					break;
				} else {
					N = curSum;
				}

				nIterations++;
			}

		}

		// Close buffer
		buffer.close();
	}

	private static boolean isPalindrome(long curSum) {
		return (curSum == getReverseOf(curSum));
	}

	private static long getReverseOf(long n) {
		long reverseOfN = 0;

		while (n != 0) {
			reverseOfN *= 10;
			reverseOfN += (n % 10);
			n /= 10;
		}

		return reverseOfN;
	}
}
