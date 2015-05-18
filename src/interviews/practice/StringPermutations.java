/**
 * 
 */
package interviews.practice;

/*
 * @author arpitm
 * 
 *         Program prints all permutations of an input string.
 * 
 *         Approach: Swap based recursive approach 
 *         1. Keep track of the index of
 *         current character in focus. 
 *         2. Swap the focus character with every
 *         other character in the string.
 *         
 *         Example:
 *         ("abc", index = 0)
 *         1) No swapping, process ("abc", index = 1)
 *         2) Swap characters '1' and '2', process ("bac", index = 1)
 *         3) Swap characters '1' and '3', process ("cba", index = 1)
 *
 */
public class StringPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "";
		printStringPermutations(str);

		System.out.println();

		str = "a";
		printStringPermutations(str);

		System.out.println();

		str = "ab";
		printStringPermutations(str);

		System.out.println();

		str = "abc";
		printStringPermutations(str);

		System.out.println();

		str = "abcd";
		printStringPermutations(str);

		System.out.println();

		str = "a b b a";
		printStringPermutations(str);
		
		str = "1234";
		printStringPermutations(str);
	}

	private static void printStringPermutations(String str) {
		if (str.length() == 0) {
			System.out.println("No permuations of " + str);
		} else if (str.length() == 1) {
			System.out.println("Printing permutations of " + str + ":");
			System.out.println(str);
			System.out.println();
		} else {
			System.out.println("Printing permutations of " + str + ":");
			System.out.println(str);
			stringPermutation(str, str.length(), 0);
			System.out.println();
		}
	}

	private static void stringPermutation(String str, int strLen, int charIndex) {
		// Return if currIndex = string length
		if (charIndex> strLen) {
			return;
		} else {
			int i = charIndex + 1;
			while (i < strLen) {
				String permStr = swapCharatersInString(str, i, charIndex);
				System.out.println(permStr);
				i++;
			}

			stringPermutation(str, strLen, charIndex + 1);
		}
	}

	private static String swapCharatersInString(String str, int i, int charIndex) {
		char[] strCharArray = str.toCharArray();
		char temp;

		temp = strCharArray[i];
		strCharArray[i] = strCharArray[charIndex];
		strCharArray[charIndex] = temp;

		return (new String(strCharArray));
	}

}
