/**
 * 
 */
package interviews.practice;

/**
 * @author arpitm
 * 
 *         Program implements logic to remove duplicate characters from an input
 *         string.
 *
 */
public class RemoveDuplicateCharsFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Hello";
		System.out.println("Input string: " + str);
		removeDuplicate2(str);

		str = "";
		System.out.println("Input string: " + str);
		removeDuplicate1(str);

		str = null;
		System.out.println("Input string: " + str);
		removeDuplicate1(str);

		str = "abc";
		System.out.println("Input string: " + str);
		removeDuplicate1(str);

		str = "aaaa";
		System.out.println("Input string: " + str);
		removeDuplicate1(str);

		str = "aaabbb";
		System.out.println("Input string: " + str);
		removeDuplicate1(str);
	}

	// private static void printRemovedDuplicates(String str) {
	// System.out.println("Input string: " + str);
	// removeDuplicate(str.toCharArray());
	// System.out.println("Duplicates removed: " + str);
	// }

	private static void removeDuplicate2(String str) {
		
	}

	private static void removeDuplicate1(String str) {
		if (str == null) {
			return;
		}
		
		char[] strArray = str.toCharArray();
		int len = strArray.length;

		if (len < 2) {
			return;
		}

		int tail = 1;

		for (int i = 1; i < len; i++) {
			int j;
			for (j = 0; j < tail; j++) {
				if (strArray[i] == strArray[j]) {
					break;
				}
			}

			if (j == tail) {
				strArray[tail] = strArray[i];
				++tail;
			}
		}

		strArray[tail] = 0;

		System.out.println("Duplicates removed: " + new String(strArray));
	}

}
