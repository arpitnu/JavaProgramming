package interviews.codeeval.moderate.NumberOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author arpitm
 * 
 *         NUMBER OPERATIONS CHALLENGE DESCRIPTION:
 * 
 *         Alice has invented a new card game to play with Bob. Alice made a
 *         deck of cards with random values between 1 and 52. Bob picks 5 cards.
 *         Then, he has to rearrange the cards so that by utilizing the
 *         operations plus, minus, or times, the value of the cards reach
 *         Alice's favorite number, 42. More precisely, find operations such
 *         that ((((val1 op1 val2) op2 val3) op3 val4) op4 val5) = 42.
 * 
 *         Help Bob by writing a program to determine whether it is possible to
 *         reach 42 given 5 card values.
 * 
 *         For example, Bob picks 5 cards out of the deck containing 60, 1, 3,
 *         5, and 20. Bob rearranges the cards and supplies four operations, so
 *         that 5 * 20 - 60 + 3 - 1 = 42.
 * 
 *         INPUT SAMPLE:
 * 
 *         The input consists of five integers on a line, separated by spaces.
 *         Each integer V is 0 <= V <= 52.
 * 
 *         44 6 1 49 47
 * 
 *         34 1 49 2 21
 * 
 *         31 38 27 51 18
 * 
 *         OUTPUT SAMPLE:
 * 
 *         For each test case print a line containing "YES" if it is possible to
 *         reach the value 42 according to the rules of the game, or "NO"
 *         otherwise.
 * 
 *         NO
 * 
 *         YES
 * 
 *         NO
 *
 */
public class NumberOperations {
	private static final int desiredSum = 42;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// Before beginning reading lines, get all permutations of operations
		char[] ops = { '+', '-', '*' };
		HashSet<String> opPermutations = getOpsPermutations(ops);

		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;

		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			// Get all permutations of the deck numbers.
			ArrayList<ArrayList<Integer>> allDecks = getDeckPermutations(line);
			boolean isYes = false;
			
			for(ArrayList<Integer> deck : allDecks) {
				int deckIndex;
				int curSum;
				boolean isThisYes = false;
				
				for (String opString : opPermutations) {
					deckIndex = 0;
					curSum = deck.get(deckIndex);

					char[] opArray = opString.toCharArray();

					for (char op : opArray) {
						deckIndex++;

						if (op == '+') {
							curSum += deck.get(deckIndex);
						} else if (op == '*') {
							curSum *= deck.get(deckIndex);
						} else if (op == '-') {
							curSum -= deck.get(deckIndex);
						} else {
							// Do nothing
						}
					}

					// Check if curSum = desired sum
					if (curSum == desiredSum) {
						isThisYes = true;
						break;
					}
				}

				if (isThisYes) {
					isYes = true;
					break;
				} 
			}
			
			if (isYes) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

		// Close buffer
		buffer.close();
	}

	private static ArrayList<ArrayList<Integer>> getDeckPermutations(String line) {
		String[] lineParts = line.split(" ");
		int size = lineParts.length;
		ArrayList<ArrayList<Integer>> allPerms = new ArrayList<ArrayList<Integer>>();

		int[] deck = new int[size];
		for (int i = 0; i < size; i++) {
			deck[i] = Integer.parseInt(lineParts[i]);
		}

		permuteDeck(deck, size, 0, allPerms);

		return allPerms;
	}

	private static void permuteDeck(int[] deck, int size, int start,
			ArrayList<ArrayList<Integer>> allPerms) {
		if (start >= size) {
			ArrayList<Integer> item = new ArrayList<Integer>();

			for (int i : deck) {
				item.add(i);
			}

			allPerms.add(item);
		} else {
			for (int i = start; i < size; i++) {
				swap(deck, start, i);
				permuteDeck(deck, size, start + 1, allPerms);
				swap(deck, start, i);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static HashSet<String> getOpsPermutations(char[] ops) {
		HashSet<String> opPerms = new HashSet<String>();
		int len = 4;
		String startStr = "";
		permuteOps(ops, len, startStr, opPerms);

		return opPerms;
	}

	private static void permuteOps(char[] ops, int len, String startStr,
			HashSet<String> opPerms) {
		if (startStr.length() >= len) {
			opPerms.add(startStr);
		} else {
			for (char op : ops) {
				permuteOps(ops, len, startStr + op, opPerms);
			}
		}
	}

}
