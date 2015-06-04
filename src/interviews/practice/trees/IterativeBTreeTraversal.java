package interviews.practice.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author arpitm
 * 
 *         Given a binary tree implement the In-order, Pre-order and Post-order
 *         traversal of the tree iteratively. This is done using stacks
 * 
 *         where n is the number of nodes in the Binary Tree
 * 
 *         Given the below BTree:
 * 
 *         root -> 2 (V)
 * 
 *         root.left -> 3 (L)
 * 
 *         root.right -> 4 (R)
 * 
 *         In order traversal: L V R
 * 
 *         Pre order traversal: V L R
 * 
 *         Post order traversal: L R V
 *
 */
class IterativeBTreeTraversal {

	public static void main(String[] args) {
		BTreeNode root = new BTreeNode(10, new BTreeNode(15, new BTreeNode(3,
				new BTreeNode(5), new BTreeNode(4)), new BTreeNode(6)), new BTreeNode(30,
				null, new BTreeNode(2, new BTreeNode(9), new BTreeNode(8))));

		System.out.println("Input tree: ");
		root.printBTree();

		System.out.println();

		System.out.print("In order traversal: ");
		inOrderTraversal(root);

		System.out.println();

		System.out.print("Pre order traversal: ");
		preOrderTraversal(root);

		System.out.println();

		System.out.print("Post order traversal: ");
		postOrderTraversal(root);

		System.out.println();

		System.out.print("Level order traversal: ");
		levelOrderTraversal(root);
	}

	/**
	 * Function prints the nodes of the binary tree level-by-level
	 * 
	 * In the worst case, time complexity is O(n)
	 * 
	 * The space complexity depends on the size of the queue, and, in he worst
	 * case the queue will have all the leaf nodes. If there are n nodes in the
	 * tree, there are atmost n/2 leaf nodes possible. Hence, the worst case
	 * space complexity is O(n)
	 */
	private static void levelOrderTraversal(BTreeNode root) {
		if (root == null) {
			return;
		}

		// Define a list that is intended to behave as a queue
		Queue<BTreeNode> q = new LinkedList<BTreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			root = q.remove();

			System.out.print(root.value + " ");

			if (root.left != null) {
				q.add(root.left);
			}

			if (root.right != null) {
				q.add(root.right);
			}
		}

	}

	/**
	 * Worst case run time: O(n)
	 * 
	 * Space utilized: O(n)
	 */
	private static void postOrderTraversal(BTreeNode root) {
		if (root == null) {
			return;
		}

		// Define stacks
		Stack<BTreeNode> stack1 = new Stack<BTreeNode>();
		Stack<BTreeNode> stack2 = new Stack<BTreeNode>();

		stack1.push(root);

		while (!stack1.isEmpty()) {
			root = stack1.pop();

			stack2.push(root);

			if (root.left != null) {
				stack1.push(root.left);
			}

			if (root.right != null) {
				stack1.push(root.right);
			}
		}

		while (!stack2.isEmpty()) {
			root = stack2.pop();
			System.out.print(root.value + " ");
		}
	}

	/**
	 * Worst case run time: O(n), because we visit every node once
	 * 
	 * Space utilized: O(h), which is O(n) in the worst case
	 */
	private static void preOrderTraversal(BTreeNode root) {
		if (root == null) {
			return;
		}

		// Define stacks
		Stack<BTreeNode> stack = new Stack<BTreeNode>();

		stack.add(root);

		while (!stack.isEmpty()) {
			root = stack.pop();

			System.out.print(root.value + " ");

			if (root.right != null) {
				stack.push(root.right);
			}

			if (root.left != null) {
				stack.push(root.left);
			}
		}

	}

	/**
	 * Worst case run time: O(n)
	 * 
	 * Worst case Space utilized: O(h) = O(n)
	 * 
	 * where h is the height of the tree. In the worst case the height of the
	 * tree is equal to the number of nodes in the tree.
	 */
	private static void inOrderTraversal(BTreeNode root) {
		if (root == null) {
			return;
		}

		// Define stack
		Stack<BTreeNode> stack = new Stack<BTreeNode>();

		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				if (stack.isEmpty()) {
					break;
				} else {
					root = stack.pop();
					System.out.print(root.value + " ");
					root = root.right;
				}
			}
		}
	}

}
