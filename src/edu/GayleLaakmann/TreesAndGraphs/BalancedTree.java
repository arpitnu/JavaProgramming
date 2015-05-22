/**
 * 
 */
package edu.GayleLaakmann.TreesAndGraphs;

/**
 * @author arpitm
 *
 */
public class BalancedTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Construct a tree
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);
		Node n13 = new Node(13);
		Node n14 = new Node(14);
		Node n15 = new Node(15);
		Node n4 = new Node(4, n8, n9);
		Node n5 = new Node(5, n10, n11);
		Node n6 = new Node(6, n12, n13);
		Node n7 = new Node(7, n14, n15);
		Node n2 = new Node(2, n4, n5);
		Node n3 = new Node(3, n6, n7);
		Node root = new Node(1, n2, n3);

		System.out.println("Is the tree balanced? " + isBalanced(root));

		// Lets add more nodes to make the tree un-balanced
		Node n18 = new Node(18);
		Node n19 = new Node(19);
		Node n17 = new Node(17, n18, n19);
		n14.left = n17;

		System.out
				.println("After adding more nodes, is the tree still balanced? "
						+ isBalanced(root));
	}

	private static boolean isBalanced(Node root) {
		return (maxDepth(root) - minDepth(root) <= 1);
	}

	private static int minDepth(Node root) {
		if (root == null) {
			return 0;
		} else {
			return (1 + Math.min(minDepth(root.left), minDepth(root.right)));
		}
	}

	private static int maxDepth(Node root) {
		if (root == null) {
			return 0;
		} else {
			return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
		}
	}

}
