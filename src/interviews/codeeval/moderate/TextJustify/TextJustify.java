/**
 * 
 */
package interviews.codeeval.moderate.TextJustify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * @author arpitm
 * 
 *         JUSTIFY THE TEXT
 * 
 *         CHALLENGE DESCRIPTION:
 * 
 *         Write a program that reformats the text into lines of 80 symbols by
 *         stretching the text to full line width by adding extra spaces.
 * 
 *         Longer series of spaces should go first. For example:
 * 
 *         - if you need to add just one extra space, add it between the first
 *         and the second word
 * 
 *         - if there are 4 words in a line, and you need 10 spaces to stretch
 *         the text up to 80 symbols, add 4 spaces between the first and the
 *         second word, 3 spaces between the second and the third word, and 3
 *         spaces between the third and the fourth word. The last line of the
 *         paragraph remains unchanged.
 * 
 *         INPUT SAMPLE:
 * 
 *         The first argument is a filename. The input file contains a text.
 * 
 *         For example:
 * 
 *         Line 1: 
 *         
 *         Hello, World!
 * 
 *         Line 2: 
 *         
 *         The precise 50-digits value of Pi is 3.14159265358979323846264338327950288419716939937510.
 *
 *         Line 3: 
 *         
 *         But he who would be a great man ought to regard, not himself or his interests, but what is just, whether the just act be his own or that of another. Next as to habitations. Such is the tradition.
 * 
 * 
 *         OUTPUT SAMPLE:
 * 
 *         Print to stdout the text, reformatted into lines of 80 symbols by
 *         stretching the text to the full line width by adding extra spaces.
 * 
 *         For example:
 * 
 *         Line 1:
 * 
 *         Hello, World!
 * 
 *         Line 2:
 * 
 *         The precise 50-digits value of Pi is
 *         3.14159265358979323846264338327950288419716939937510.
 * 
 *         Line 3:
 * 
 *         But he who would be a great man ought to regard, not himself or his
 *         interests, but what is just, whether the just act be his own or that
 *         of another. Next as to habitations. Such is the tradition.
 * 
 * 
 *         Approach:
 * 
 *         1. Get the length of the input line.
 * 
 *         2. If length of input line < 80 characters, there is no need to
 *         change the formatting of the line. Print it as it is.
 * 
 *         3. If the length of the line is more than 80 characters, first check
 *         for the character at multiples of 80. Let that character be 'cAt80'
 * 
 *         4. If cAt80 is a ' ', replace that with '\n'
 * 
 *         5. If cAt80 is not ' ', find the previous ' ' in the character array
 *         of the string and replace that with '\n'. Now that there are spaces
 *         to be filled, distribute spaces in the words in the sub-string before
 *         '\n' equally.
 *
 */
public class TextJustify {
	private static final int MAX_CHARACTERS = 80;

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
			int lineLength = line.length();

			if (lineLength != 0) {
				if (lineLength <= MAX_CHARACTERS) {
					System.out.println(line);
				} else {
					int curCharPtr = 0;
					char[] lineCharArray = line.toCharArray();
					int nRows = lineLength / MAX_CHARACTERS - 1;
					char[][] jCharArray = new char[nRows][MAX_CHARACTERS];
					int curRowIndex = 0;
					int curColIndex = 0;

					while (curCharPtr < lineLength) {
						int start = curCharPtr;
						int end = ((curRowIndex == (nRows - 1)) ? (lineLength - start - 1) : (start + MAX_CHARACTERS - 1));

						while (start <= end) {
							if(lineCharArray[end] == ' ') {
								
							}
						}
					}

					// while (curCharPtr < lineLength) {
					// if (curCharPtr < (MAX_CHARACTERS * (curRowIndex + 1))) {
					// jCharArray[curRowIndex][curColIndex] =
					// lineCharArray[curCharPtr];
					// curColIndex++;
					// } else {
					// if (curColIndex == MAX_CHARACTERS - 1) {
					// curColIndex = 0;
					// }
					//
					// if (lineCharArray[curCharPtr] == ' ') {
					// lineCharArray[curCharPtr] = '\n';
					// }
					// }
					//
					// curCharPtr++;
					// }

					// while (curCharPtr < lineLength) {
					// if (curRowIndex != jCharArray.length) {
					// if (lineCharArray[curCharPtr + MAX_CHARACTERS - 1] ==
					// ' ') {
					// // These set of 80 character in the line are
					// // already justified. Copy these 80 character in
					// // jCharArray
					//
					// for (int j = 0; j < MAX_CHARACTERS - 1; j++) {
					// jCharArray[curRowIndex][j] = lineCharArray[curCharPtr];
					// curCharPtr++;
					// }
					//
					// lineCharArray[curCharPtr + MAX_CHARACTERS - 1] = '\n';
					//
					// curRowIndex++;
					// } else {
					// // The character at curCharPtr + MAX_CHARACTERS
					// // is not a space. Now we need to find the
					// // previous space and set that as the end point.
					// // Then store all the characters from
					// // curCharPointer to end point in the current
					// // row.
					// int end = curCharPtr + MAX_CHARACTERS - 1;
					//
					// while (lineCharArray[end] != ' ') {
					// end--;
					// }
					//
					// for (int j = curCharPtr; j < end; j++) {
					// jCharArray[curRowIndex][j] = lineCharArray[curCharPtr];
					// }
					// }
					// } else {
					// // Handle last row
					// }
					//
					// // curCharPtr++;
					// }

					// char[][] justifiedCharArray = new char[lineLength
					// / MAX_CHARACTERS][MAX_CHARACTERS];
					// int curRowIndex = 0;
					// int newLineCharIndex = 0;
					// int jIndex = 0;
					//
					// while (curCharPtr < lineLength) {
					// if (curCharPtr < (curRowIndex * MAX_CHARACTERS +
					// MAX_CHARACTERS)) {
					// justifiedCharArray[curRowIndex][jIndex] =
					// lineCharArray[curCharPtr];
					// jIndex++;
					// curCharPtr++;
					// } else {
					// curRowIndex++;
					// jIndex = 0;
					// }
					// }
					//
					// // TODO for testing
					// for (int i = 0; i < justifiedCharArray.length; i++) {
					// System.out.println(new String(justifiedCharArray[i]));
					// }

					// int newLineIndex = 1;
					// int[] newLineIndexes = new int[lineLength / 80];
					//
					// for (int i = 0; i < newLineIndexes.length; i++) {
					// newLineIndexes[i] = -1;
					// }
					//
					// // Scan the lineCharArray till the end and place markers
					// in
					// // the
					// // array from where new line needs to be printed.
					// while (curCharPtr < lineLength) {
					// if (curCharPtr == (newLineIndex * MAX_CHARACTERS - 1)) {
					// if (lineCharArray[curCharPtr] == ' ') {
					// // Place a new line pointer to the character
					// // after
					// // this space.
					// }
					//
					// int prevSpaceIndex = curCharPtr - 1;
					//
					// while (lineCharArray[prevSpaceIndex] != ' ') {
					// prevSpaceIndex--;
					// }
					//
					// // Set the new line pointer to this index
					// newLineIndexes[newLineIndex - 1] = prevSpaceIndex + 1;
					//
					// newLineIndex++;
					// }
					//
					// curCharPtr++;
					// }
				}
			} else {
				// Print a blank line for blank line input
				System.out.println();
			}
		}

		// Close buffer
		buffer.close();
	}
}
