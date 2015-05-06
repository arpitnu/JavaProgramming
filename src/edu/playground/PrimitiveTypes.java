/**
 * 
 */
package edu.playground;

/**
 * @author arpitm
 * 
 * Play around with Java primitive types
 *
 */
public class PrimitiveTypes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Integer
		int i1 = 4344;
		long i2 = 43L;
		System.out.println("i1 = " + i1);
		System.out.println("i2 = " + i2);
		
		i2 = i1;
		System.out.println("i2 = " + i2);
		
		i2 = 3147483649L;
		i1 = (int) i2;
		System.out.println("i1 = " + i1);
		
		// Boolean
		boolean b1 = 3 == 5;
		System.out.println(b1);
		boolean b2 = false == (3 != 3);
		System.out.println(b2);
	}

}
