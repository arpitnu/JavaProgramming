/**
 * 
 */
package interviews.codeeval.easy.challenge4;

/**
 * @author arpitm
 * 
 *         Program prints all odd numbers from 1 to 99
 *
 */
public class Challenge4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 1;

		while (num <= 99) {
			if (num % 2 != 0) {
				System.out.println(num);
			}
			
			num++;
		}
	}

}
