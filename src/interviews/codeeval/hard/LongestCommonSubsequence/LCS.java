/**
 * 
 */
package interviews.codeeval.hard.LongestCommonSubsequence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * @author arpitm
 * 
 *         LONGEST COMMON SUBSEQUENCE
 * 
 *         CHALLENGE DESCRIPTION:
 * 
 *         You are given two sequences. Write a program to determine the longest
 *         common subsequence between the two strings (each string can have a
 *         maximum length of 50 characters). NOTE: This subsequence need not be
 *         contiguous. The input file may contain empty lines, these need to be
 *         ignored.
 * 
 *         INPUT SAMPLE:
 * 
 *         The first argument will be a path to a filename that contains two
 *         strings per line, semicolon delimited. You can assume that there is
 *         only one unique subsequence per test case. E.g.
 * 
 *         XMJYAUZ;MZJAWXU
 * 
 *         OUTPUT SAMPLE:
 * 
 *         The longest common subsequence. Ensure that there are no trailing
 *         empty spaces on each line you print. E.g.
 * 
 *         MJAU
 *
 */
public class LCS {

	/**
	 * @param args
	 * @throws IOException
	 * 
	 */
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;

		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			if (line.length() != 0) {

				String[] lineParts = line.split(";");

				String str1 = lineParts[0].trim();
				int str1Len = str1.length();
				HashSet<String> str1SubStrings = new HashSet<String>();
				
				String str2 = lineParts[1].trim();
				int str2Len = str2.length();
				HashSet<String> str2SubStrings = new HashSet<String>();

				allSubstrings(str1, str1Len, str1SubStrings);
				allSubstrings(str2, str2Len, str2SubStrings);

				System.out.println(str1SubStrings);
				System.out.println(str2SubStrings);

				// In a loop, now check if any of the sub strings of str1 is
				// present in the HashSet of substrings of str2
				String lcs = new String();
				for (String str1SubStr : str1SubStrings) {
					if (str2SubStrings.contains(str1SubStr)) {
						if(lcs.length() < str1SubStr.length()) {
							lcs = str1SubStr;
						}
					}
				}
				
				System.out.println(lcs);
			}
		}

		// Close buffer
		buffer.close();
	}

	private static void allSubstrings(String str, int strLen,
			HashSet<String> strSubStrings) {
		int i;
		int subStrSize = 0;

		while (subStrSize != strLen) {
			for (i = 0; i + subStrSize < strLen; i++) {
				if (subStrSize == 0) {
					strSubStrings.add(str.substring(i, i));
				} else {
					// strSubStrings.add(str.substring(i, i + subStrSize));
					String subStr = str.substring(i, i + subStrSize);
					permuteAndStore(subStr.toCharArray(), strSubStrings);
				}
			}
			subStrSize++;
		}
	}

	/**
	 * Function creates all possible permutations of characters in charArray and
	 * stores in the input HashSet 'hs' parameter.
	 * 
	 * @param permChars
	 * @param hs
	 */
	private static void permuteAndStore(char[] permChars, HashSet<String> hs) {
		hs.add(new String(permChars));

		while (hasNext(permChars)) {
			hs.add(new String(permChars));
		}
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
