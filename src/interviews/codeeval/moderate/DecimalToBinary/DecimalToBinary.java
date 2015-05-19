package interviews.codeeval.moderate.DecimalToBinary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author arpitm
 * 
 *         You are given a decimal (base 10) number, print its binary
 *         representation.
 * 
 *         INPUT SAMPLE:
 * 
 *         Your program should accept as its first argument a path to a filename
 *         containing decimal numbers greater or equal to 0, one per line.
 * 
 *         Ignore all empty lines.
 * 
 *         For example:
 * 
 *         2
 * 
 *         10
 * 
 *         67
 * 
 *         OUTPUT SAMPLE:
 * 
 *         Print the binary representation, one per line.
 * 
 *         For example:
 * 
 *         10
 * 
 *         1010
 * 
 *         1000011
 *
 */
public class DecimalToBinary {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			// Process line of input Here
			int n = Integer.parseInt(line);

			System.out.println(intToBinary(n));
		}
	}

	/**
	 * Function converts the input int parameter to its binary form and prints
	 * the output
	 * 
	 * @param n
	 */
	private static String intToBinary(int n) {
		if (n == 0) {
			return "0";
		} else {
			int divisor = 2;
			StringBuilder binSb = new StringBuilder();

			while (n > 0) {
				binSb.insert(0, n % divisor);
				n /= divisor;
			}
			
			return binSb.toString();
		}
	}

}
