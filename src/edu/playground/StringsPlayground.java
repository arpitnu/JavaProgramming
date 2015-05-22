/**
 * 
 */
package edu.playground;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author arpitm
 * 
 *         Playground for Strings
 *
 */
public class StringsPlayground {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] cArray = { 'h', 'e', 'l', 'l', 'o', ' ', '\n', 'A', 'r', 'p', 'i',
				't' };
		
		System.out.println(new String(cArray));
		
		String s1 = "\\joe\\jill\\";
		System.out.println(s1.replaceAll("\\\\$|\\\\^", ""));
		
		String s2 = "\"Hello\"";
		System.out.println(s2);
		System.out.println(s2.replace("\"", ""));
		
		String s3 = "[Hello Arpit]";
		System.out.println(s3);
		System.out.println(s3.replace("[", "").replace("]", ""));
		
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		ArrayList<String> al = new ArrayList<String>();
		
	}
}
