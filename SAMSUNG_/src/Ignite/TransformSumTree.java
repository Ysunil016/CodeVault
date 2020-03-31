package Ignite;

public class TransformSumTree {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(60);
//		root.right.left = new Node(7);
//		root.right.right = new Node(5);

		inOrderTraversal(root);
		System.out.println();
		transform2Sum(root);
		System.out.println();
		inOrderTraversal(root);

	}

	static int transform2Sum(Node root) {
		if (root == null)
			return 0;

		// Generic Scenario Where A Node has Both Left and Right Child
		if (root.left != null && root.right != null)
			root.data = root.left.data + root.right.data + transform2Sum(root.left) + transform2Sum(root.right);

		// Scenario Where A Node has Only Left Child
		if (root.left != null && root.right == null)
			root.data = root.left.data + transform2Sum(root.left);

		// Scenario Where A Node has Only Right Child
		if (root.left == null && root.right != null)
			root.data = root.right.data + transform2Sum(root.right);

		// Child Node Scenario
		if (root.left == null && root.right == null) {
			root.data = 0;
			return 0;
		} else
			return root.data;
	}

	static void preOrderTraversal(Node root) {
		if (root == null)
			return;

		System.out.print("-> " + root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	static void inOrderTraversal(Node root) {
		if (root == null)
			return;

		inOrderTraversal(root.left);
		System.out.print("-> " + root.data);
		inOrderTraversal(root.right);
	}

}
