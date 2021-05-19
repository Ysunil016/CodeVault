package Tree.Problems;

public class CountLeavesInBinaryTree {

	static class Node {
		int data;
		Node left = null;
		Node right = null;
		Node rightNeighbour = null;

		Node(int data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {
		Node root = new Node(69);
		getRandomTreeGeneration(root, 2, 0);

		System.out.println(numberOfLeaveNodes(root, 0));

	}

	// Leaf Node Logic
	static int numberOfLeaveNodes(Node root, int leafCounter) {
		if (root.left == null && root.right == null)
			return ++leafCounter;

		return numberOfLeaveNodes(root.left, leafCounter) + numberOfLeaveNodes(root.right, leafCounter);
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
