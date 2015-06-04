package interviews.practice.trees;

/**
 * @author arpitm
 *
 */
class BTreeNode {
	public int value;
	public BTreeNode left;
	public BTreeNode right;

	/**
	 * Tree() constructor
	 */
	public BTreeNode(int a) {
		this.left = null;
		this.right = null;
		this.value = a;
	}

	public BTreeNode(int a, BTreeNode leftNode, BTreeNode rightNode) {
		this.left = leftNode;
		this.right = rightNode;
		this.value = a;
	}

	public void printBTree() {
		if (this.right != null) {
			this.right.printTree(true, "");
		}

		System.out.println(this.value);

		if (this.left != null) {
			this.left.printTree(false, "");
		}
	}

	private void printTree(boolean isRight, String indent) {
		if (this.right != null) {
			this.right.printTree(true, (indent + (isRight ? "        "
					: " |      ")));
		}

		System.out.print(indent);

		if (isRight) {
			System.out.print(" /");
		} else {
			System.out.print(" \\");
		}

		System.out.print("----- ");

		System.out.println(this.value);

		if (this.left != null) {
			this.left.printTree(false, (indent + (isRight ? " |      "
					: "        ")));
		}
	}
}
