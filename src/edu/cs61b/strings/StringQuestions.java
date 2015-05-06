package edu.cs61b.strings;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author arpitm
 * 
 *         This class is used for generic String tests
 *         
 *         Strings are IMMUTABLE!!! Their contents never change.
 *
 */
public class StringQuestions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int testFuncIndex = 5;

		switch (testFuncIndex) {
		case 1:
			System.out.println("Testing function stringTestFunc"
					+ testFuncIndex);
			stringTestFunc1();
			break;

		case 2:
			System.out.println("Testing function stringTestFunc"
					+ testFuncIndex);
			stringTestFunc2();
			break;

		case 3:
			System.out.println("Testing function stringTestFunc"
					+ testFuncIndex);
			stringTestFunc3();
			break;

		case 4:
			System.out.println("Testing function stringTestFunc"
					+ testFuncIndex);
			stringTestFunc4();
			break;
			
		case 5:
			System.out.println("Testing function stringTestFunc"
					+ testFuncIndex);
			stringTestFunc5();
			break;

		default:
			break;
		}
	}

	private static void stringTestFunc5() {
		System.out.println("Function takes in a line of text from the user and output the same line.");
		
		
		
		System.out.print(" Enter text: ");
	}

	private static void stringTestFunc4() {
		String s = "Yow!";

		System.out.println("s = 'Yow!'");
		System.out
				.println("Function checks different inbuild String class methods");
		System.out.println("Output: ");
		System.out.println("toLowerCase(): " + s.toLowerCase());
		System.out.println("toUpperCase(): " + s.toUpperCase());
		System.out.println("concat(): " + s.concat(" What's up dawg?"));
		System.out.println("Chaining concat(): "
				+ "*".concat(s).concat("*").concat(s).concat("##"));
		// Note: In all these function calls, the object "Yow!" did not change.
	}

	private static void stringTestFunc1() {
		String s1 = "Yow!";
		String s2 = "Yow!";

		System.out.println("s1 = 'Yow!'");
		System.out.println("s2 = 'Yow!'");
		System.out
				.println("Function checks if s1 and s2 point to the same object or not");

		if (s1 == s2) {
			System.out.println("Output: Both strings point to the same object");
		} else {
			System.out
					.println("Output: Both strings point to the different objects");
		}
	}

	private static void stringTestFunc2() {
		String s1 = "Yow!";
		String s2 = "Yow";

		System.out.println("s1 = 'Yow!'");
		System.out.println("s2 = 'Yow'");
		System.out
				.println("Function checks if s1 and s2 point to the same object or not");

		if (s1 == s2) {
			System.out.println("Output: Both strings point to the same object");
		} else {
			System.out
					.println("Output: Both strings point to the different objects");
		}
	}

	private static void stringTestFunc3() {
		String s1 = "Yow!";
		String s2 = s1;

		System.out.println("s1 = 'Yow!'");
		System.out.println("s2 = s1");
		System.out
				.println("Function checks if s1 and s2 point to the same object or not");

		if (s1 == s2) {
			System.out.println("Output: Both strings point to the same object");
		} else {
			System.out
					.println("Output: Both strings point to the different objects");
		}
	}

}
