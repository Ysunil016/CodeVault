package Ignite;

public class LowestCommonAncestorInBST {

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
		root.left = new Node(6);
		root.left.left = new Node(4);
		root.left.right = new Node(8);
		root.left.left.left = new Node(2);
		root.left.left.right = new Node(5);
		root.right = new Node(20);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(20);

		int START = 4;
		int END = 8;

		Node ancNode = getLowestCommonAncestorInBST(root, START, END);
		if (ancNode != null)
			System.out.println("Common Node in BST for " + START + " Node to " + END + " Node is " + ancNode.data);

	}

	// Function Returns a Node that Act as Least Common Ancestor in an BST...
	static Node getLowestCommonAncestorInBST(Node root, int startPoint, int endPoint) {
		if (root == null)
			return null;

		//Is Current Root FullFilling the Required Ancestor Properties.
		if (root.data >= startPoint && root.data <= endPoint)
			return root;

		
		//Checking if Current Root is Less then That of Given Left Data
		if (root.data < startPoint)
			return getLowestCommonAncestorInBST(root.right, startPoint, endPoint);
		else
			return getLowestCommonAncestorInBST(root.left, startPoint, endPoint);
	}

}
