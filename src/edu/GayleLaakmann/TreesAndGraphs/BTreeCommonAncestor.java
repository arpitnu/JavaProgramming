/**
 * 
 */
package edu.GayleLaakmann.TreesAndGraphs;

/**
 * @author arpitm
 *
 */
public class BTreeCommonAncestor {

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

		Node ancestor = commonAncestor1(root, n13, n5);
		System.out.println("Common ancestor of " + n13.item + " and " + n5.item
				+ " is " + ancestor.item);
		System.out.println();

		ancestor = commonAncestor1(root, n2, n5);
		System.out.println("Common ancestor of " + n2.item + " and " + n5.item
				+ " is " + ancestor.item);
		System.out.println();

		ancestor = commonAncestor1(root, n3, n15);
		System.out.println("Common ancestor of " + n3.item + " and " + n15.item
				+ " is " + ancestor.item);
		System.out.println();

		ancestor = commonAncestor1(root, n3, n4);
		System.out.println("Common ancestor of " + n3.item + " and " + n4.item
				+ " is " + ancestor.item);
		System.out.println();

		ancestor = commonAncestor1(root, n14, n15);
		System.out.println("Common ancestor of " + n14.item + " and "
				+ n15.item + " is " + ancestor.item);
		System.out.println();

		ancestor = commonAncestor1(root, n6, n15);
		System.out.println("Common ancestor of " + n6.item + " and " + n15.item
				+ " is " + ancestor.item);
		System.out.println();
	}

	/**
	 * Function return the common ancestor of nodes p & q.
	 * 
	 * Follow a chain in which p and q are on the same side. That is, if p and q
	 * are both on the left of the node, branch left to look for the common
	 * ancestor. When p and q are no longer on the same side, you must have
	 * found the first common ancestor.
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	private static Node commonAncestor1(Node root, Node p, Node q) {
		if (covers(root.left, p) && covers(root.left, q)) {
			return commonAncestor1(root.left, p, q);
		} else if (covers(root.right, p) && covers(root.right, q)) {
			return commonAncestor1(root.right, p, q);
		} else {
			return root;
		}
	}

	private static boolean covers(Node root, Node n) {
		if (root == null) {
			return false;
		} else if (n == root) {
			return true;
		} else {
			return (covers(root.left, n) || covers(root.right, n));
		}
	}
}
