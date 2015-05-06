/**
 * 
 */
package edu.DataStructures;

/**
 * @author arpitm
 *
 */
public class List {
	public int value;
	public List next;

	public List(int v) {
		this.value = v;
		this.next = null;
	}

	public String toString() {
		String out = "";
		List curNode = this;

		while (curNode != null) {
			out += curNode.value + "-->";
			curNode = curNode.next;
		}

		return out + "TAIL";
	}
}
