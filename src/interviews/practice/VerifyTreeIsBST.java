/**
 * 
 */
package interviews.practice;

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

	static class Tree {
		public int value;
		public Tree left;
		public Tree right;

		/**
		 * Tree() constructor
		 */
		public Tree(int a) {
			this.left = null;
			this.right = null;
			this.value = a;
		}

		public Tree(int a, Tree leftNode, Tree rightNode) {
			this.left = leftNode;
			this.right = rightNode;
			this.value = a;
		}
	}

	public static void main(String[] args) {
		// construct a simple tree
		Tree myTree1 = new Tree(4, new Tree(2, new Tree(1), new Tree(3)),
				new Tree(6, new Tree(5), new Tree(7)));
		System.out.println("Is my tree BST? "
				+ isBST(myTree1, Integer.MIN_VALUE, Integer.MAX_VALUE));

		Tree myTree2 = new Tree(2, new Tree(4, new Tree(1), new Tree(3)),
				new Tree(6, new Tree(5), new Tree(7)));
		System.out.println("Is my tree BST? "
				+ isBST(myTree2, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	public static boolean isBST(Tree t, int small, int large) {
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
