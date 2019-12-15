package Tree.Problems;

public class HeightOfTheeTree {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node rootN = new Node(69);
		getRandomTreeGeneration(rootN, 2, 0);
		System.out.println(getHeightOfTheTree(rootN));
	}

	// Recursive Logic to Get Height of Tree
	static int getHeightOfTheTree(Node root) {
		if (root == null)
			return 0;

		return Math.max(getHeightOfTheTree(root.left), getHeightOfTheTree(root.right)) + 1;
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
