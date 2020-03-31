package Ignite;

public class CountLeavesInBinaryTree {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}

	}

	static int leave_count = 0;

	public static void main(String[] args) {
		// 10
		// 20 30
		// 32 12 18 76
		// 17 12 98 89

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(32);
		root.left.right = new Node(12);
		root.left.left.left = new Node(17);
		root.left.right.left = new Node(12);
		root.right.left = new Node(18);
		root.right.right = new Node(76);
		root.right.left.left = new Node(98);
		root.right.right.right = new Node(89);

		// Traversing Binary Tree and Checking if Node has Left or Right Child
		checkNodeChild(root);
		System.out.println("Tree has " + leave_count + " Leaves");
	}

	// Function that Recursively Checks for the Child Nodes in PreOrder Fashion
	static void checkNodeChild(Node root) {
		if (root == null)
			return;

		// Checking if Particular Node is a Child
		if (root.left == null && root.right == null) {
			leave_count++;
//			System.out.print("->  " + root.data);
		}

		// Traversing for Rest of the Nodes
		checkNodeChild(root.left);
		checkNodeChild(root.right);

	}

}
