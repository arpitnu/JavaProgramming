/**
 * 
 */
package edu.cs61b.lists;

/*
 * @author arpitm
 * 
 * Advantages: 
 * 1. Very fast access of each item in the array.
 * 
 * Disadvantages:
 * 1. Inserting an item/int at the beginning or in the middle of the
 * list takes time proportional to the length of the list.
 * 2. An array has fixed length.
 *
 */
public class ArrayBasedIntList {
	int[] a;
	int lastItem;

	public ArrayBasedIntList() {
		this.a = new int[50];
		this.lastItem = -1;
	}

	public ArrayBasedIntList(int n) {
		this.a = new int[n];
		this.lastItem = -1;
	}

	public void addItem(int newItem) {
		int i = 0;

		// Check if array is full.
		if (lastItem + 1 == this.a.length) {
			int[] b = new int[2 * this.a.length];

			for (i = 0; i < lastItem; i++) {
				b[i] = a[i];
			}

			this.a = b;
		}

		this.a[lastItem + 1] = newItem;
		this.lastItem++;
	}

	public void insertItem(int newItem, int location) {
		int i = 0;

		// Check if array is full.
		if (lastItem + 1 == this.a.length) {
			int[] b = new int[2 * this.a.length];

			for (i = 0; i < lastItem; i++) {
				b[i] = a[i];
			}

			this.a = b;
		}

		// Insert item
		for (i = this.lastItem; i >= location; i--) {
			this.a[i + 1] = this.a[i];
		}

		this.a[location] = newItem;
		this.lastItem++;
	}

	public void deleteItem(int location) {
		int i = 0;

		for (i = location; i < this.lastItem; i++) {
			this.a[i] = this.a[i + 1];
		}

		this.a[lastItem] = 0;
		this.lastItem--;
	}

	@Override
	public String toString() {
		String s = new String();

		if (this.lastItem == -1) {
			System.out.println("Woops! Empty list.");
			return s;
		}

		for (int i = 0; i < this.lastItem; i++) {
			// s.concat(this.a[i] + " ");
			s += this.a[i] + " ";
		}

		return s;
	}

	public static void main(String[] args) {
		int len = 30;
		ArrayBasedIntList abil1 = new ArrayBasedIntList(len);

		// Populate
		int i = 0;
		for (i = 0; i < 25; i++) {
			abil1.addItem(i+1);
		}

		System.out.println(abil1.toString());
		System.out.println(abil1.lastItem);
		
		// Checks
		abil1.insertItem(100, 0);
		System.out.println(abil1.toString());
		abil1.deleteItem(0);
		System.out.println(abil1.toString());
		abil1.insertItem(100, 11);
		System.out.println(abil1.toString());
		abil1.deleteItem(11);
		System.out.println(abil1.toString());
	}
}
