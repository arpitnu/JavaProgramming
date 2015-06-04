package interviews.practice.trees;

/**
 * @author arpitm
 * 
 *         Given 2 binary trees, funstion checks if the two have the same data
 *         and the same structure or not
 *
 */
class EqualBTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTreeNode root1 = null;
		BTreeNode root2 = null;

		// Test case 1
		root1 = new BTreeNode(10, new BTreeNode(-5, new BTreeNode(-10),
				new BTreeNode(7)), new BTreeNode(20, new BTreeNode(15),
				new BTreeNode(25)));

		root2 = new BTreeNode(10, new BTreeNode(-5, new BTreeNode(-10),
				new BTreeNode(7)), new BTreeNode(20, new BTreeNode(15),
				new BTreeNode(25)));

		System.out.println("Input tree 1: ");
		root1.printBTree();
		System.out.println();
		System.out.println("Input tree 2: ");
		root2.printBTree();
		System.out.println();
		System.out.println("Are tree1 and tree2 the same? "
				+ sameTree(root1, root2));

		System.out.println();

		// Test case 2
		root1 = new BTreeNode(10, new BTreeNode(-5, new BTreeNode(-10),
				new BTreeNode(7)), new BTreeNode(20, new BTreeNode(15),
				new BTreeNode(25)));

		root2 = new BTreeNode(10, new BTreeNode(-5, new BTreeNode(-10),
				new BTreeNode(7)), new BTreeNode(20, new BTreeNode(15,
				new BTreeNode(12), null), new BTreeNode(25)));

		System.out.println("Input tree 1: ");
		root1.printBTree();
		System.out.println();
		System.out.println("Input tree 2: ");
		root2.printBTree();
		System.out.println();
		System.out.println("Are tree1 and tree2 the same? "
				+ sameTree(root1, root2));

		System.out.println();

		// Test case 3
		root1 = new BTreeNode(10, new BTreeNode(-5, new BTreeNode(-10),
				new BTreeNode(8)), new BTreeNode(20, new BTreeNode(15),
				new BTreeNode(25)));

		root2 = new BTreeNode(10, new BTreeNode(-5, new BTreeNode(-10),
				new BTreeNode(7)), new BTreeNode(20, new BTreeNode(15),
				new BTreeNode(25)));

		System.out.println("Input tree 1: ");
		root1.printBTree();
		System.out.println();
		System.out.println("Input tree 2: ");
		root2.printBTree();
		System.out.println();
		System.out.println("Are tree1 and tree2 the same? "
				+ sameTree(root1, root2));
	}

	private static boolean sameTree(BTreeNode root1, BTreeNode root2) {
		if ((root1 == null) && (root2 == null)) {
			return true;
		} else if ((root1 == null) || (root2 == null)) {
			return false;
		} else {
			return ((root1.value == root2.value)
					&& (sameTree(root1.left, root2.left)) && (sameTree(
						root1.right, root2.right)));
		}
	}

}
