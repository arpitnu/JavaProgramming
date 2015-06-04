package interviews.practice.trees;

/**
 * @author arpitm
 * 
 *         QUESTION:
 * 
 *         Give a B tree, program prints the tree level-by-level
 *         
 *         Time complexity - O(n)
 *         
 *         Space complexity - O(n) (worst case)
 *
 */
public class PrintBTree {

	public static void main(String[] args) {
		BTreeNode root = new BTreeNode(10, new BTreeNode(15, new BTreeNode(3,
				new BTreeNode(5), null), new BTreeNode(6)), new BTreeNode(30,
				null, new BTreeNode(2, new BTreeNode(9), new BTreeNode(8))));
		
		printBTree(root);
	}

	private static void printBTree(BTreeNode root) {
		if(root == null) {
			return;
		}
		
		
	}

}
