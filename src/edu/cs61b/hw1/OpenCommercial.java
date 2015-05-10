package edu.cs61b.hw1;

/* OpenCommercial.java */

import java.net.*;
import java.io.*;

/**
 * A class that provides a main function to read five lines of a commercial Web
 * page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

	/**
	 * Prompts the user for the name X of a company (a single string), opens the
	 * Web site corresponding to www.X.com, and prints the first five lines of
	 * the Web page in reverse order.
	 * 
	 * @param arg
	 *            is not used.
	 * @exception Exception
	 *                thrown if there are any problems parsing the user's input
	 *                or opening the connection.
	 */
	public static void main(String[] arg) throws Exception {

		BufferedReader keyboard;
		String inputLine;

		keyboard = new BufferedReader(new InputStreamReader(System.in));

		System.out
				.print("Please enter the name of a company (without spaces): ");
		inputLine = keyboard.readLine();
		
		keyboard.close();

		String urlString = "http://www.X.com".replace("X", inputLine);

		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();

		// Create a buffered reader for the data stream.
		BufferedReader urlBr = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));

		// Array to store first five lines.
		String[] urlData = new String[5];

		int i = 0;
		for (i = 0; i < 5; i++) {
			urlData[i] = urlBr.readLine();
		}

		// Print the lines.
		for (i = urlData.length - 1; i >= 0; i--) {
			System.out.println("Line " + (i + 1) + ": " + urlData[i]);
		}
		
		// Close BuffereReader
		urlBr.close();
	}
}
