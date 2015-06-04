package interviews.practice.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arpitm
 * 
 *         Question:
 * 
 *         Given a Binary Tree and a sum, find the path in the BT where the sum
 *         of values of the nodes is equal to the sum.
 * 
 *         Worst case
 *
 */
class BTRootToLeafSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTreeNode root = new BTreeNode(10, new BTreeNode(-5,
				new BTreeNode(-10), new BTreeNode(7)), new BTreeNode(20,
				new BTreeNode(15), new BTreeNode(25)));

		System.out.println("Input BST: ");
		root.printBTree();
		int sum;
		boolean pathExists = false;
		List<Integer> path = null;

		System.out.println();

		sum = 12;
		path = new ArrayList<Integer>();
		System.out.println("Sum = " + sum);
		pathExists = rootToLeafSum(root, sum, path);
		if (pathExists) {
			for (int i = path.size() - 1; i >= 0; i--) {
				System.out.print(path.get(i) + " ");
			}
			System.out.println();
		} else {
			System.out.println("No path found!");
		}

		System.out.println();

		sum = 45;
		path = new ArrayList<Integer>();
		System.out.println("Sum = " + sum);
		pathExists = rootToLeafSum(root, sum, path);
		if (pathExists) {
			for (int i = path.size() - 1; i >= 0; i--) {
				System.out.print(path.get(i) + " ");
			}
			System.out.println();
		} else {
			System.out.println("No path found!");
		}

		System.out.println();

		sum = 46;
		path = new ArrayList<Integer>();
		System.out.println("Sum = " + sum);
		pathExists = rootToLeafSum(root, sum, path);
		if (pathExists) {
			for (int i = path.size() - 1; i >= 0; i--) {
				System.out.print(path.get(i) + " ");
			}
			System.out.println();
		} else {
			System.out.println("No path found!");
		}
	}

	private static boolean rootToLeafSum(BTreeNode root, int sum,
			List<Integer> path) {
		// Check if root is null
		if (root == null) {
			return false;
		}

		// Check if root is a leaf node
		if ((root.left == null) && (root.right == null)) {
			if (sum == root.value) {
				path.add(root.value);
				return true;
			} else {
				return false;
			}
		}

		// Root is not a leaf node
		if (rootToLeafSum(root.left, sum - root.value, path)) {
			path.add(root.value);
			return true;
		}

		if (rootToLeafSum(root.right, sum - root.value, path)) {
			path.add(root.value);
			return true;
		}

		return false;
	}

}
