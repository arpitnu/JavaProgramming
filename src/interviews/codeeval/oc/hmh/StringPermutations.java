package interviews.codeeval.oc.hmh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @author arpitm
 * 
 *         Write a program which prints all the permutations of a string in
 *         alphabetical order. We consider that digits < upper case letters <
 *         lower case letters. The sorting should be performed in ascending
 *         order.
 * 
 *         INPUT SAMPLE: Your program should accept a file as its first
 *         argument. The file contains input strings, one per line.
 * 
 *         For example: 
 *         hat 
 *         abc 
 *         Zu6
 * 
 *         OUTPUT SAMPLE:
 * 
 *         Print to stdout the permutations of the string separated by comma, in
 *         alphabetical order.
 * 
 *         For example: 
 *         aht,ath,hat,hta,tah,tha 
 *         abc,acb,bac,bca,cab,cba
 *         6Zu,6uZ,Z6u,Zu6,u6Z,uZ6
 * 
 */
public class StringPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			char[] permChars = line.toCharArray();

			// Sort the character array in ascending order.
			Arrays.sort(permChars);

			permute(permChars);

			// int len = permChars.length;
			// int nPermutations = factorial(len - 1);
			// // System.out.println(nPermutations);
			//
			// // Define list of strings to store app permutations
			// ArrayList<String> allPermutations = new ArrayList<String>();
			//
			// getPermutations(new String(permChars), 0, permChars.length,
			// allPermutations);
			//
			// // Print all permutations of the string in a comma separated list
			// // form
			// StringBuilder sb = new StringBuilder();
			//
			// for (int i = 0; i < allPermutations.size(); i++) {
			// if (i == 0) {
			// sb.append(allPermutations.get(i));
			// } else {
			// sb.append("," + allPermutations.get(i));
			// }
			// }
			//
			// System.out.println(sb.toString());
		}

		// Close buffer
		buffer.close();
	}

	private static void permute(char[] permChars) {
		// List to store all permutations
		ArrayList<String> allPermutations = new ArrayList<String>();

		allPermutations.add(new String(permChars));

		// Print permutations

		while (hasNext(permChars)) {
			allPermutations.add(new String(permChars));
		}

		// Print ArrayList
		printPermutations(allPermutations);
	}

	private static void printPermutations(ArrayList<String> allPermutations) {
		int i;
		StringBuilder sb = new StringBuilder();

		for (i = 0; i < allPermutations.size(); i++) {
			if (i == 0) {
				sb.append(allPermutations.get(i));
			} else {
				sb.append("," + allPermutations.get(i));
			}
		}

		// Print
		System.out.println(sb.toString());
	}

	private static boolean hasNext(char[] permChars) {
		int N = permChars.length;
		int i;

		// Find the rightmost char in permChars that is smaller than the
		// character to its right
		for (i = N - 2; i >= 0; i--) {
			if (permChars[i] < permChars[i + 1]) {
				break;
			}
		}

		if (i == -1) {
			return false;
		}

		// Find the rightmost permChars[j] that is larger than permChars[i]
		int j = N - 1;
		while (permChars[i] > permChars[j]) {
			j--;
		}

		swap(permChars, i, j);

		for (int k = N - 1, l = i + 1; k > l; k--, l++) {
			swap(permChars, k, l);
		}

		return true;
	}

	private static void swap(char[] permChars, int i, int j) {
		char temp = permChars[i];
		permChars[i] = permChars[j];
		permChars[j] = temp;
	}
}