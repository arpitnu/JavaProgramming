/**
 * 
 */
package practice.hackerrank.algorithms.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author arpitm
 * 
 *         Problem Statement
 * 
 *         Given a list of N integers, your task is to select K integers from
 *         the list such that its unfairness is minimized.
 * 
 *         if (x1,x2,x3,…,xk) are K numbers selected from the list N, the
 *         unfairness is defined as
 * 
 *         max(x1,x2,…,xk)−min(x1,x2,…,xk) where max denotes the largest integer
 *         among the elements of K, and min denotes the smallest integer among
 *         the elements of K.
 * 
 *         Input Format The first line contains an integer N. The second line
 *         contains an integer K. N lines follow. Each line contains an integer
 *         that belongs to the list N.
 * 
 *         Note: Integers in the list N may not be unique.
 * 
 *         Output Format An integer that denotes the minimum possible value of
 *         unfairness.
 * 
 *         Constraints 2≤N≤105 2≤K≤N 0≤integer in N ≤109 Sample Input #00
 * 
 *         Sample Input #00
 * 
 *         7
 * 
 *         3
 * 
 *         10
 * 
 *         100
 * 
 *         300
 * 
 *         200
 * 
 *         1000
 * 
 *         20
 * 
 *         30
 * 
 *         Sample Output #00
 * 
 *         20
 *
 */
public class MaxMin {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[] nList = new int[N];

		for (int i = 0; i < N; i++) {
			nList[i] = Integer.parseInt(br.readLine());
		}
		
		int unfairness = Integer.MAX_VALUE;
	}

}
