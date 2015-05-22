/**
 * 
 */
package edu.GayleLaakmann.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author arpitm
 * 
 *         Given a binary search tree, design an algorithm which creates a
 *         linked list of all the nodes at each depth (eg, if you have a tree
 *         with depth D, you’ll have D linked lists).
 *
 */
public class LevelLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Construct a bst
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);
		Node n13 = new Node(13);
		Node n14 = new Node(14);
		Node n15 = new Node(15);
		Node n4 = new Node(4, n8, n9);
		Node n5 = new Node(5, n10, n11);
		Node n6 = new Node(6, n12, n13);
		Node n7 = new Node(7, n14, n15);
		Node n2 = new Node(2, n4, n5);
		Node n3 = new Node(3, n6, n7);
		Node root = new Node(1, n2, n3);
		
		ArrayList<LinkedList<Node>> levelLists = getLevelLinkedLists(root);
	}

	private static ArrayList<LinkedList<Node>> getLevelLinkedLists(Node root) {
		int level = 0;
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		
		LinkedList<Node> levelList = new LinkedList<Node>();
		levelList.add(root);
		
		return result;
	}

}
