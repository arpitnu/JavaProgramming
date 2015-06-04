package interviews.practice.trees;

/**
 * @author arpitm
 *
 */
class BSTInsertion {

	public static void main(String[] args) {
		BTreeNode bst = new BTreeNode(10, new BTreeNode(-5, new BTreeNode(-10),
				new BTreeNode(7)), new BTreeNode(20, new BTreeNode(15),
				new BTreeNode(25)));

		System.out.println("Input BST: ");
		bst.printBTree();
		int data;
		BTreeNode newBST;

		System.out.println();

		data = 0;
		newBST = addNodeInBST(bst, data);
		System.out.println();
		System.out.println("BST after inserting " + data + ": ");
		newBST.printBTree();

		System.out.println();

		data = -20;
		newBST = addNodeInBST(bst, data);
		System.out.println("BST after inserting " + data + ": ");
		System.out.println();
		newBST.printBTree();

		System.out.println();

		data = 9;
		newBST = addNodeInBST(bst, data);
		System.out.println("BST after inserting " + data + ": ");
		System.out.println();
		newBST.printBTree();

		System.out.println();

		data = 11;
		newBST = addNodeInBST(bst, data);
		System.out.println("BST after inserting " + data + ": ");
		System.out.println();
		newBST.printBTree();

		System.out.println();

		data = 13;
		newBST = addNodeInBST(bst, data);
		System.out.println("BST after inserting " + data + ": ");
		System.out.println();
		newBST.printBTree();

		System.out.println();

		data = 19;
		newBST = addNodeInBST(bst, data);
		System.out.println("BST after inserting " + data + ": ");
		System.out.println();
		newBST.printBTree();

		System.out.println();

		data = 22;
		newBST = addNodeInBST(bst, data);
		System.out.println("BST after inserting " + data + ": ");
		System.out.println();
		newBST.printBTree();

		System.out.println();

		data = 100;
		newBST = addNodeInBST(bst, data);
		System.out.println("BST after inserting " + data + ": ");
		System.out.println();
		newBST.printBTree();

	}

	private static BTreeNode addNodeInBST(BTreeNode root, int data) {
		BTreeNode node = new BTreeNode(data);
		if (root == null) {
			return node;
		}

		BTreeNode parent = null;
		BTreeNode current = root;

		while (current != null) {
			parent = current;

			if (current.value <= data) {
				current = current.right;
			} else {
				current = current.left;
			}
		}

		if (parent.value <= data) {
			parent.right = node;
		} else {
			parent.left = node;
		}

		return root;
	}

}
