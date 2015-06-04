package interviews.practice.trees;

/**
 * @author arpitm
 * 
 *         Program searches for a given key in the Binary Tree.
 *
 */
class BSTSearch {

	public static void main(String[] args) {
		BTreeNode root = new BTreeNode(10, new BTreeNode(-5,
				new BTreeNode(-10), new BTreeNode(7)), new BTreeNode(20,
				new BTreeNode(15), new BTreeNode(25)));

		System.out.println("Input BST: ");
		root.printBTree();
		int key;
		BTreeNode keyNode = null;

		System.out.println();

		key = 10;
		System.out.println("Searching for " + key);
		keyNode = searchKeyInBST(root, key);
		if (keyNode != null) {
			System.out.println("Found!");
		} else {
			System.out.println("Not found!");
		}

		key = 25;
		System.out.println("Searching for " + key);
		keyNode = searchKeyInBST(root, key);
		if (keyNode != null) {
			System.out.println("Found!");
		} else {
			System.out.println("Not found!");
		}

		key = 27;
		System.out.println("Searching for " + key);
		keyNode = searchKeyInBST(root, key);
		if (keyNode != null) {
			System.out.println("Found!");
		} else {
			System.out.println("Not found!");
		}

		key = -20;
		System.out.println("Searching for " + key);
		keyNode = searchKeyInBST(root, key);
		if (keyNode != null) {
			System.out.println("Found!");
		} else {
			System.out.println("Not found!");
		}
	}

	private static BTreeNode searchKeyInBST(BTreeNode root, int key) {
		if (root == null) {
			return null;
		}

		if (root.value == key) {
			return root;
		} else if (root.value < key) {
			return searchKeyInBST(root.right, key);
		} else {
			return searchKeyInBST(root.left, key);
		}
	}

}
