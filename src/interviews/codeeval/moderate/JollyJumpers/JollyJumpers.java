/**
 * 
 */
package interviews.codeeval.moderate.JollyJumpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * @author arpitm
 * 
 *         JOLLY JUMPERS
 * 
 *         A sequence of n > 0 integers is called a jolly jumper if the absolute
 *         values of the differences between successive elements take on all
 *         possible values 1 through n - 1. eg.
 * 
 *         1 4 2 3
 * 
 *         is a jolly jumper, because the absolute differences are 3, 2, and 1,
 *         respectively. The definition implies that any sequence of a single
 *         integer is a jolly jumper. Write a program to determine whether each
 *         of a number of sequences is a jolly jumper.
 * 
 *         INPUT SAMPLE:
 * 
 *         Your program should accept as its first argument a path to a
 *         filename. Each line in this file is one test case. Each test case
 *         will contain an integer n < 3000 followed by n integers representing
 *         the sequence. The integers are space delimited.
 * 
 *         For example:
 * 
 *         4 1 4 2 3
 * 
 *         3 7 7 8
 * 
 *         9 8 9 7 10 6 12 17 24 38
 * 
 *         OUTPUT SAMPLE:
 * 
 *         For each line of input generate a line of output saying 'Jolly' or
 *         'Not jolly'.
 * 
 *         For example:
 * 
 *         Jolly
 * 
 *         Not jolly
 * 
 *         Not jolly
 *
 */
public class JollyJumpers {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;

		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			// Split line to get numbers
			String[] lineSplits = line.split(" ");
			int N = lineSplits.length;
			int[] numbers = new int[N];
			int i;

			for (i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(lineSplits[i]);
			}

			if (jollyJumpers(numbers, N)) {
				System.out.println("Jolly");
			} else {
				System.out.println("Not jolly");
			}
		}

		// Close buffer
		buffer.close();
	}

	private static boolean jollyJumpers1(int[] numbers, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int diff = Math.abs(numbers[i] - numbers[j]);

				if ((diff < 1) || (diff >= N)) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean jollyJumpers(int[] numbers, int N) {
		boolean result = true;
		int i;

		for (i = 1; i < N; i++) {
			int diff = Math.abs(numbers[i - 1] - numbers[i]);

			if ((diff < 1) || (diff >= N)) {
				return false;
			}
		}

		return result;
	}

}
