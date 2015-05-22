/**
 * 
 */
package interviews.codeeval.easy.SumOf100Primes;

/**
 * @author arpitm
 * 
 *         Program prints the sum of first 1000 primes
 *
 */
public class SumOf100Primes {

	/**
	 * Driver function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 1000;
		long[] nPrimes = findFirstNPrimes(n);
		System.out.println(sumOfNPrimes(nPrimes));
	}

	private static long sumOfNPrimes(long[] nPrimes) {
		long sum = 0L;
		
		for(long prime : nPrimes) {
			sum += prime;
		}
		
		return sum;
	}

	public static long[] findFirstNPrimes(int n) {
		long[] nPrimesArr = new long[n];
		int numPrimesFound = 0;
		long num = 2L;

		while (numPrimesFound != n) {
			if (isNumPrime(num)) {
				nPrimesArr[numPrimesFound] = num;
				numPrimesFound++;
			}

			num++;
		}
		
		return nPrimesArr;
	}

	// Function checks if the input parameter integer is prime or not.
	private static boolean isNumPrime(long num) {
		long divisor = 2L;

		while (divisor < num) {
			if ((num % divisor) == 0) {
				return false;
			}

			divisor++;
		}

		return true;
	}

}
