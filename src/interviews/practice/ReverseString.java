package interviews.practice;

/**
 * @author arpitm
 *
 */
public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Hello";
		printReverseString(str);
	}

	private static void printReverseString(String str) {
		System.out.println("Input string: " + str);
		String reversedStr = reverseStringRecursion(str, 0, str.length() - 1);
		System.out.println("Reversed string: " + reversedStr);
	}

	// This implementation creates a new string
	private static String reverseString(String str, int start, int end) {
		String reversedStr = new String();

		for (int i = end; i >= 0; i--) {
			reversedStr += str.charAt(i);
		}

		return reversedStr;
	}

	private static String reverseStringRecursion(String str, int start, int end) {
		if (start == end) {
			return str;
		} else {
			char firstChar = str.charAt(0);
			return (reverseStringRecursion(str.substring(1, end), 0,
					end - 1) + firstChar);
		}
	}

}
