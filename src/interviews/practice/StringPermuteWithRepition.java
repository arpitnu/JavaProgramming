/**
 * 
 */
package interviews.practice;

/**
 * @author arpitm
 *
 */
public class StringPermuteWithRepition {

	static void Recur(String prefix, String str) {
		if (prefix.length() == str.length()) {
			System.out.println(prefix);
			return;
		}

		for (int i = 0; i < str.length(); i++)
			Recur(prefix + str.charAt(i), str);
	}

	static void printAll(char[] c, int n, String start) {
		if (start.length() >= n) {
			System.out.println(start);
		} else {
			for (char x : c) { // not a valid syntax in Java
				printAll(c, n, start + x);
			}
		}
	}

	public static void main(String[] args) {
		String str = "AB";
		String prefix = "DC";
		Recur(prefix, str);

		char[] c = { '+', '*', '-' };
		int n = 4;
		printAll(c, n, "");
	}
}
