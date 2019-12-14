package Tree.Problems;

import Tree.Problems.LeftViewOfTree.Node;

public class BinaryToDLL {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	static class DLL {
		int data;
		DLL next = null;
		DLL prev = null;

		DLL(int data) {
			this.data = data;
		}
	}

	static Node head;
	static Node prev = null;

	public static void main(String[] args) {
		Node rootN = new Node(69);
		getRandomTreeGeneration(rootN, 2, 0);

		head = bToDLL(rootN);

		while (head != null) {
			System.out.println(head.data);
			head = head.right;
		}

	}

	static Node bToDLL(Node root) {
		BinaryTree2DoubleLinkedList(root);
		return head;
	}

	static void BinaryTree2DoubleLinkedList(Node root) {
		if (root == null)
			return;

		BinaryTree2DoubleLinkedList(root.left);

		if (prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}

		prev = root;

		BinaryTree2DoubleLinkedList(root.right);

	}

	static Node getRandomTreeGeneration(Node root, int levelCounter, int currentCounter) {

		if (root == null)
			return null;

		if (currentCounter > levelCounter)
			return null;

		// Assigning Random Value to Node
		root.left = new Node((int) (Math.random() * 100));
		root.right = new Node((int) (Math.random() * 100));

		System.out.println(root.data + " has " + root.left.data + " - " + root.right.data);

		// Calling Recursively
		getRandomTreeGeneration(root.left, levelCounter, ++currentCounter);
		getRandomTreeGeneration(root.right, levelCounter, ++currentCounter);

		return root;
	}

}
