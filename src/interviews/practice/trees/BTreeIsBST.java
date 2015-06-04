package interviews.practice.trees;

/**
 * @author arpitm
 * 
 *         Question:
 * 
 *         Given an input Binary tree, program determines if it is a BST.
 *
 */
class BTreeIsBST {

	public static void main(String[] args) {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;

		// Test case 1
		BTreeNode root = new BTreeNode(10, new BTreeNode(-5,
				new BTreeNode(-10), new BTreeNode(7)), new BTreeNode(20,
				new BTreeNode(15), new BTreeNode(25)));

		System.out.println("Input BST: ");
		root.printBTree();
		System.out.println("Is BST? " + isBTreeBST(root, min, max));

		System.out.println();

		// Test case 2
		root = new BTreeNode(10, new BTreeNode(-5, new BTreeNode(-10),
				new BTreeNode(7)), new BTreeNode(20, new BTreeNode(19),
				new BTreeNode(18)));

		System.out.println("Input BST: ");
		root.printBTree();
		System.out.println("Is BST? " + isBTreeBST(root, min, max));

		System.out.println();

		// Test case 3
		root = new BTreeNode(10, new BTreeNode(-5, new BTreeNode(-3),
				new BTreeNode(-4)), new BTreeNode(20, new BTreeNode(22),
				new BTreeNode(25)));

		System.out.println("Input BST: ");
		root.printBTree();
		System.out.println("Is BST? " + isBTreeBST(root, min, max));
		
		System.out.println();

		// Test case 4
		root = new BTreeNode(10, new BTreeNode(-5, new BTreeNode(-5),
				new BTreeNode(-5)), new BTreeNode(20, new BTreeNode(22),
				new BTreeNode(25)));

		System.out.println("Input BST: ");
		root.printBTree();
		System.out.println("Is BST? " + isBTreeBST(root, min, max));

	}

	private static boolean isBTreeBST(BTreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		if ((root.value <= min) || (root.value > max)) {
			return false;
		} else {
			return (isBTreeBST(root.left, min, root.value) && isBTreeBST(
					root.right, root.value, max));
		}
	}

}
