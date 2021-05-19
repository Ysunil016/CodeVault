package Tree.Problems;

import java.util.ArrayList;

public class isSymmetricBinaryTree {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node l1 = root.left = new Node(10);
		Node l2 = root.right = new Node(10);
		l1.left = new Node(20);
		l1.right = new Node(30);
		l2.left = new Node(30);
		l2.right = new Node(20);

		System.out.println(isSymmetric(root));
	}

	public static boolean isSymmetric(Node root) {
		ArrayList<Node> lNode = new ArrayList<Node>();

		ArrayList<Node> rNode = new ArrayList<Node>();

		System.out.println("LNR");
		LNR(root.left, lNode);

		System.out.println("RNL");
		RNL(root.right, rNode);

		// Comparing two ArrayList
		int leftArrayLen = lNode.size();
		int rightArrayLen = rNode.size();

		System.out.println(leftArrayLen);
		System.out.println(rightArrayLen);

		if (leftArrayLen != rightArrayLen)
			return false;

		for (int i = 0; i < leftArrayLen; i++) {
			System.out.println(lNode.get(i).data + " with " + rNode.get(i).data);
			if (lNode.get(i).data != rNode.get(i).data)
				return false;
		}
		return true;
	}

	static void LNR(Node root, ArrayList<Node> lNode) {
		if (root == null)
			return;

		LNR(root.left, lNode);
		lNode.add(root);
		LNR(root.right, lNode);
	}

	static void RNL(Node root, ArrayList<Node> rNode) {
		if (root == null)
			return;

		RNL(root.right, rNode);
		rNode.add(root);
		RNL(root.left, rNode);
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
