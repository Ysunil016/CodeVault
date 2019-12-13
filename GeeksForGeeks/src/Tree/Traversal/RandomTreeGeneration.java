package Tree.Traversal;

import Tree.TNode;

public class RandomTreeGeneration {

	public static void main(String[] args) {
		getRandomTreeGeneration(new TNode(69), 4, 0);
	}

	// Function that Generates Tree of levelCounter Level
	public static TNode getRandomTreeGeneration(TNode root, int levelCounter, int currentCounter) {

		if (root == null)
			return null;

		if (currentCounter > levelCounter)
			return null;

		// Assigning Random Value to Node
		root.left = new TNode((int) (Math.random() * 100));
		root.right = new TNode((int) (Math.random() * 100));

		System.out.println(root.data + " has " + root.left.data + " - " + root.right.data);

		// Calling Recursively
		getRandomTreeGeneration(root.left, levelCounter, ++currentCounter);
		getRandomTreeGeneration(root.right, levelCounter, ++currentCounter);

		return root;
	}

}
