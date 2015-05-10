/**
 * 
 */
package edu.cs61b.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author arpitm
 * 
 *         Program reads a string from the keyboard and prints the same string,
 *         with its second character removed. (That's character number 1, since
 *         Java numbers characters in a string starting from zero.) In other
 *         words, after you run "java Nuke2", if you type in the string "skin",
 *         the program will print "sin".
 *
 */
public class Nuke2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(
				System.in));
		String inputLine;

		System.out.print("Please enter a string (atleast 2 characters): ");
		inputLine = keyboard.readLine();

		keyboard.close();

		int len = inputLine.length();

		if (len < 2) {
			System.out
					.println("Please enter a string with atleast 2 characters.");
			System.exit(0);
		}

		System.out.println(len);

		char[] cArray = new char[len - 1];

		int j = 0;
		for (int i = 0; i < len; i++) {
			if (i != 1) {
				cArray[j] = inputLine.charAt(i);
				j++;
			}

		}

		System.out.println(new String(cArray));
	}

}
