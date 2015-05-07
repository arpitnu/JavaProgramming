/**
 * 
 */
package edu.cs61b.IterationsAndArrays;

/**
 * @author arpitm
 * 
 *         Determine if a number is prime or not
 *
 */
public class IsPrime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 31;
		isNumPrime(num);

		num = 54;
		isNumPrime(num);
		
		num = 55;
		isNumPrime(num);

		num = 13331;
		isNumPrime(num);

		num = 1;
		isNumPrime(num);

		num = 2;
		isNumPrime(num);
		
		num = 906;
		isNumPrime(num);
		
		num = 907;
		isNumPrime(num);
		
		num = 908;
		isNumPrime(num);
	}

	private static void isNumPrime(int num) {
		int divisor = 2;
		
		if (num == 1) {
			System.out.println(num + " is neither prime nor composite.");
			return;
		}

		while (divisor < num) {
			if ((num % divisor) == 0) {
				System.out.println(num + " is not prime.");
				return;
			}

			divisor++;
		}

		System.out.println(num + " is prime.");
	}

}
