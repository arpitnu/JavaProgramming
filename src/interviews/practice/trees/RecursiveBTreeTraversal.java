/**
 * 
 */
package interviews.practice.trees;

/**
 * @author arpitm
 * 
 *         This program implements Pre-order, In-order and Post-order traversals
 *         of a binary tree.
 * 
 *         A binary tree is a tree in which every node has AT MOST 2 child nodes
 *         (0, 1,or 2).
 * 
 *         Given the below BTree:
 * 
 *         root -> 2 (V)
 * 
 *         root.left -> 3 (L)
 * 
 *         root.right -> 4 (R)
 * 
 * 
 *         In order traversal: L V R
 * 
 *         Pre order traversal: V L R
 * 
 *         Post order traversal: L R V
 * 
 *
 */
class RecursiveBTreeTraversal {

	public static void main(String[] args) {
		// construct a simple tree
		BTreeNode root = new BTreeNode(10, new BTreeNode(15, new BTreeNode(3,
				new BTreeNode(5), null), new BTreeNode(6)), new BTreeNode(30,
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
	}
	
	private static void inOrderTraversal(BTreeNode node) {
		if(node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.value + " ");
			inOrderTraversal(node.right);
		}
	}
	
	private static void preOrderTraversal(BTreeNode node) {
		if(node != null) {
			System.out.print(node.value + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	private static void postOrderTraversal(BTreeNode node) {
		if(node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.value + " ");
		}
	}

}
