/**
 * 
 */
package interviews.practice;

/**
 * @author arpitm
 *
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 300;
		System.out.println(N + " fibonacci numbers:");
		getFibonacciNumbers(N, 0, new int[N]);
	}

	private static void getFibonacciNumbers(int n, int i, int[] fibo) {
		if(i > n) {
			return;
		} else if (i <= 2) {
			fibo[i] = 1;
		} else {
			
		}
	}

}
