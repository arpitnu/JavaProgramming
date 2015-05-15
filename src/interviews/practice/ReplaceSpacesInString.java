/**
 * 
 */
package interviews.practice;

/**
 * @author arpitm
 * 
 *         Program replaces all the spaces in an input string with %20
 * 
 *         Algorithm: 1. Count the number of spaces int he first scan of the
 *         string. 2. Parse the string again from end for each character: a. If
 *         a space is encountered, store %20 b. Else, store the character as is
 *         in the newly shifted location
 *
 */
public class ReplaceSpacesInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String myString = "Hello there! My name is Arpit Mehta.";
		System.out.println("Input string: " + myString);
		replaceSpaces(myString.toCharArray(), myString.length());
		
		System.out.println();

		myString = "ababababa";
		System.out.println("Input string: " + myString);
		replaceSpaces(myString.toCharArray(), myString.length());
		
		System.out.println();
		
		myString = "";
		System.out.println("Input string: " + myString);
		replaceSpaces(myString.toCharArray(), myString.length());
		
		System.out.println();
		
		myString = " ";
		System.out.println("Input string: " + myString);
		replaceSpaces(myString.toCharArray(), myString.length());
	}

	private static void replaceSpaces(char[] strArray, int length)
			throws NullPointerException {
		// Count the number of spaces in first scan.
		int nSpaces = 0;
		int i;
		for (i = 0; i < length; i++) {
			if (strArray[i] == ' ') {
				nSpaces++;
			}
		}

		// Calculate the length of the new string
		int newLength = length + (nSpaces * 2);

		// Define a new char array with the new length
		char[] newStrArrtay = new char[newLength + 1];
		newStrArrtay[newLength] = '\0';

		// Scan from the end
		for (i = length - 1; i >= 0; i--) {
			if (strArray[i] == ' ') {
				newStrArrtay[newLength - 1] = '0';
				newStrArrtay[newLength - 2] = '2';
				newStrArrtay[newLength - 3] = '%';
				newLength -= 3;
			} else {
				newStrArrtay[newLength - 1] = strArray[i];
				newLength--;
			}
		}

		// Print
		System.out.println(new String(newStrArrtay));
	}
}
