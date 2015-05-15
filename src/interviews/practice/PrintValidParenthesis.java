/**
 * 
 */
package interviews.practice;

/**
 * @author arpitm
 *
 *         Program prints all valid combinations of groups of parenthesis
 */
public class PrintValidParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int left = 5;
		int right = 5;
		printParenthesis(left, right, "");
	}

	private static void printParenthesis(int leftRemain, int rightRemain,
			String currString) {
		// Check if we need to print further
		if (rightRemain == 0) {
			System.out.println(currString);
			return;
		}

		if (leftRemain > 0) {
			// Print another left parenthesis
			printParenthesis(leftRemain - 1, rightRemain, currString + "(");

			// Print right parenthesis if valid
			if (leftRemain < rightRemain) {
				printParenthesis(leftRemain, rightRemain - 1, currString + ")");
			}
		} else {
			// Now there are only right parenthesis remaining to be printed
			printParenthesis(leftRemain, rightRemain - 1, currString + ")");
		}
	}

}
