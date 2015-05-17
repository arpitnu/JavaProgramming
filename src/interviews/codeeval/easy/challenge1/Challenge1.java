/**
 * 
 */
package interviews.codeeval.easy.challenge1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author arpitm
 * 
 *         QUESTION: Link: https://www.codeeval.com/open_challenges/196/submit/
 * 
 *         Write a program that, given a sentence where each word has a single
 *         digit positive integer as a prefix and suffix, swaps the numbers
 *         while retaining the word in between. Words in the sentence are
 *         delimited from each other by a space.
 * 
 *         INPUT SAMPLE: The first argument is a path to a file. Each line of
 *         the input file contains one test case represented by a sentence. Each
 *         word in the sentence begins and ends with a single digit positive
 *         integer i.e. 0 through 9. Assume all characters are ASCII. 1)
 *         4Always0 5look8 4on9 7the2 4bright8 9side7 3of8 5life5 2) 5Nobody5
 *         7expects3 5the4 6Spanish4 9inquisition0
 * 
 *         OUTPUT SAMPLE: For each test case, print to standard output the
 *         sentence obtained by swapping the numbers surrounding each word, one
 *         per line. 1) 0Always4 8look5 9on4 2the7 8bright4 7side9 8of3 5life5
 *         2) 5Nobody5 3expects7 4the5 4Spanish6 0inquisition9
 *
 */
public class Challenge1 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader fileBuffer = new BufferedReader(new FileReader(file));
		String sentence = null;

		while ((sentence = fileBuffer.readLine()) != null) {
			sentence = sentence.trim();

			// Process line here.
			String[] words = sentence.split(" ");
			int len = words.length;
			int i;

			for (i = 0; i < len; i++) {
				String word = words[i];
				int wordLen = word.length();
				String newWord = swapCharacters(word, 0, wordLen - 1);
				words[i] = newWord;
			}
			
			// Print the line on the console
			for (i = 0; i < len - 1; i++) {
				System.out.print(words[i] + " ");
			}
			System.out.print(words[i]);
			System.out.println();
		}
		
		fileBuffer.close();
	}

	private static String swapCharacters(String word, int i, int j) {
		char[] wordCharArray = word.toCharArray();
		char temp = wordCharArray[i];
		wordCharArray[i] = wordCharArray[j];
		wordCharArray[j] = temp;
		return (new String(wordCharArray));
	}

}
