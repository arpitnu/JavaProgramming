/**
 * 
 */
package edu.GayleLaakmann.TreesAndGraphs;

/**
 * @author arpitm
 * 
 *         Given a sorted (increasing order) array, write an algorithm to create
 *         a binary tree with minimal height.
 *
 */
public class CreateMinimalBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Node root = createMinimalBST(sortedArray);
		printHelper(root, "    ");
	}

	private static Node createMinimalBST(int[] a) {
		return addToTree(a, 0, a.length - 1);
	}

	private static Node addToTree(int[] a, int start, int end) {
		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;
		Node node = new Node(a[mid], addToTree(a, start, mid - 1), addToTree(a,
				mid + 1, end));
		return node;
	}
	
	private static void printHelper(Node root, String indent) {
	    if (root == null) {
	      System.out.println(indent + "null");
	      return;
	    }

	    // Pick a pretty indent.
	    String newIndent;
	    if (indent.equals("")) {
	      newIndent = ".. ";
	    }
	    else {
	      newIndent = "..." + indent;
	    }

	    printHelper(root.left, newIndent);
	    System.out.println(indent + root.item);
	    printHelper(root.right, newIndent);
	  }

}
