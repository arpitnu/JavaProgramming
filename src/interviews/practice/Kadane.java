package interviews.practice;

/**
 * 
 *  QUESTION: 
 *  
 *  Given an array, write a function to identify the sub-array with the maximum sum.
 *  For example if the input is [1, -3, 5, -2, 9, -8, -6, 4] the output would be [5, -2, 9]
 */

import java.util.Arrays;

class Kadane {

	public static void main(String[] args) {
		// Test case 1: input array provided in the question
		int[] array1 = { 1, -3, 5, -2, 9, -8, -6, 4 };
		printMaxSumSubArray(array1);

		// Test case 2: All negative integers
		int[] array2 = { -9, -8, -7, -6, -5, -4, -3, -2, -1 };
		printMaxSumSubArray(array2);

		// Test case 2: All positive integers
		int[] array3 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		printMaxSumSubArray(array3);

		// Test case 4
		int[] array4 = { -1, 2, -3, 4, 0, -101, 102, 11, 99, 111, -111, 112,
				-99, 99 };
		printMaxSumSubArray(array4);

		// Test case 5: Input array contains consecutive repetitive numbers
		int[] array5 = { -1, -2, -2, 3, 3, 0, 0, -2, 0, 0, 0, 5, -10 };
		printMaxSumSubArray(array5);

		// Test case 6: All zeros
		int[] array6 = { 0, 0, 0, 0, 0 };
		printMaxSumSubArray(array6);

		// Test case 7: All equal positive numbers
		int[] array7 = { 1, 1, 1, 1 };
		printMaxSumSubArray(array7);

		// Test case 8: All equal negative numbers
		int[] array8 = { -1, -1, -1, -1 };
		printMaxSumSubArray(array8);

		// Test case 9: All Integer.MIN_VALUE
		int[] array9 = { Integer.MIN_VALUE, Integer.MIN_VALUE,
				Integer.MIN_VALUE };
		printMaxSumSubArray(array9);

		// Test case 10: All Integer.MAX_VALUE
		int[] array10 = { Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE };
		printMaxSumSubArray(array10);

		// Test case 11: All Integer.MIN_VALUE with -1
		int[] array11 = { Integer.MIN_VALUE, Integer.MIN_VALUE,
				Integer.MIN_VALUE, Integer.MIN_VALUE, -1 };
		printMaxSumSubArray(array11);
	}

	// Function determines the maximum sum sub array of the input integer array
	// and prints the output
	private static void printMaxSumSubArray(int[] array) {
		int[] maximumSumSubArray = maxSumSubArray(array);

		System.out.print("Input Array: ");
		printArray(array);
		System.out.print("Maximum Sum Sub Array: ");
		printArray(maximumSumSubArray);
		System.out.println();
	}

	// Function returns the maximum sum sub array. The idea is to scan the
	// array and calculate the maximum sub array for each array index as
	// the end point.
	private static int[] maxSumSubArray(int[] array) {
		int startIndex = 0;
		int maxStartIndex = 0;
		int maxEndIndex = 0;

		long currSum = 0L;
		long maxSum = (long) Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			currSum += (long) array[i];

			if (currSum >= maxSum) {
				maxSum = currSum;
				maxStartIndex = startIndex;
				maxEndIndex = i;
			} else if (currSum <= 0L) {
				currSum = 0;
				startIndex = i + 1;
			}
		}

		// Return the sub array
		return (Arrays.copyOfRange(array, maxStartIndex, maxEndIndex + 1));
	}

	// Function prints the input parameter integer array.
	private static void printArray(int[] array) {
		System.out.print("[ ");

		for (int i : array) {
			System.out.print(i + " ");
		}

		System.out.print("]");

		System.out.println();
	}
}