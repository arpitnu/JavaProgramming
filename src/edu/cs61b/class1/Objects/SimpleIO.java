/**
 * 
 */
package edu.cs61b.class1.Objects;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author arpitm
 * 
 *         Demonstrates Simple I/O capabilities in Java
 *
 */
public class SimpleIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// InputStream reads raw data
		InputStream is = System.in;

		// isr composes raw data into characters (2-byte Unicode)
		InputStreamReader isr = new InputStreamReader(is);

		// br knows how to take characters as input until return key is presses
		// and composes them into
		// a line of text that can be read at once.
		BufferedReader br = new BufferedReader(isr);
		
		// Print input line to screen
		System.out.println("Enter text:");
		System.out.println(br.readLine());
	}

}
