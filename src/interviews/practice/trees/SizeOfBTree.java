package interviews.practice.trees;

/**
 * @author arpitm
 *
 */
class SizeOfBTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// construct a simple tree
		BTreeNode tree = new BTreeNode(10, new BTreeNode(15, new BTreeNode(3,
				new BTreeNode(5), null), new BTreeNode(6)), new BTreeNode(30,
				null, new BTreeNode(2, new BTreeNode(9), new BTreeNode(8))));

		System.out.println("Size of Binary Tree: " + bTreeSize(tree));
	}

	private static int bTreeSize(BTreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return (1 + bTreeSize(node.left) + bTreeSize(node.right));
		}
	}

}
