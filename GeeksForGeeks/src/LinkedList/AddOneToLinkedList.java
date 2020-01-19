package LinkedList;

import java.util.Stack;

public class AddOneToLinkedList {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static int carry = 0;

	public static void main(String[] args) {

	//	Node root = new Node(4);
		Node one = root.next = new Node(9);
		Node two = one.next = new Node(9);
		two.next = new Node(9);

		addOne(root);
		travese(root);
	}

	static Node addOne(Node root) {
		Node node = root;
		Node prev = null;

		while (node.next != null) {
			prev = node;
			node = node.next;
		}

		prev.next = new Node(node.data + 1);

		return root;
	}

	static void travese(Node root) {
		while (root != null) {
			System.out.println(root.data);
			root = root.next;
		}
	}
}
