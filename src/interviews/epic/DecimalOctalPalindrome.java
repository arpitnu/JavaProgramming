/**
 * 
 */
package interviews.epic;

/**
 * @author arpitm
 * 
 *         Given a number nMax, program prints all decimal numbers between 1 and
 *         nMax, whose decimal and octal representations are palindromes.
 *
 */
public class DecimalOctalPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nMax = 1000;
		int c = 1;

		while (c <= nMax) {
			if (decimalOctalPalindrome(c)) {
				System.out.println(c
						+ " is positive for Decimal-Octal palindrome!");
				System.out.println("Octal representation of " + c + " is "
						+ convertDecimalToOctal(c));
				System.out.println();
			}

			c++;
		}
	}

	private static boolean decimalOctalPalindrome(int N) {
		boolean result = false;

		int oct = convertDecimalToOctal(N);
		if ((isPalindrome(N)) && (isPalindrome(oct))) {
			result = true;
		}

		return result;
	}

	private static boolean isPalindrome(int n) {
		int num = n;
		int reverse = 0;
		int digit = 0;

		while (num > 0) {
			digit = num % 10;
			reverse = reverse * 10 + digit;
			num /= 10;
		}

		if (n == reverse) {
			return true;
		}

		return false;
	}

	private static int convertDecimalToOctal(int N) {
		int result = 0;
		int counter = 0;

		while (N != 0) {
			int temp = (int) ((N % 8) * Math.pow(10, counter));
			counter++;
			result += temp;
			N /= 8;
		}

		return result;
	}

}
