package interviews.practice.trees;

/**
 * @author arpitm
 * 
 *         Program verifies if an input Tree is a Binary Search Tree.
 * 
 *         Binary Search Tree? 1) Any node on the left sub-tree < parent 2) Any
 *         node on the right sub-tree > parent
 * 
 *         This program also contains a Tree class definition for testing
 *
 */
public class VerifyTreeIsBST {

	public static void main(String[] args) {
		// construct a simple tree
		BTreeNode myTree1 = new BTreeNode(4, new BTreeNode(2, new BTreeNode(1),
				new BTreeNode(3)), new BTreeNode(6, new BTreeNode(5),
				new BTreeNode(7)));
		System.out.println("Is my tree BST? "
				+ isBST(myTree1, Integer.MIN_VALUE, Integer.MAX_VALUE));

		BTreeNode myTree2 = new BTreeNode(2, new BTreeNode(4, new BTreeNode(1),
				new BTreeNode(3)), new BTreeNode(6, new BTreeNode(5),
				new BTreeNode(7)));
		System.out.println("Is my tree BST? "
				+ isBST(myTree2, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	public static boolean isBST(BTreeNode t, int small, int large) {
		if (t == null) {
			// If no elements in the tree, we return true
			return true;
		} else {
			if ((t.value > small) && (t.value < large)) {
				// Now we need to check if left sub-trees and right sub-trees
				// are also BST's
				return ((isBST(t.left, small, t.value)) && (isBST(t.right,
						t.value, large)));
			} else {
				return false;
			}
		}
	}
}
