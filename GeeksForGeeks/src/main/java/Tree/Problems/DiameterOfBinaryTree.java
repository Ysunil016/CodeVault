package Tree.Problems;

public class DiameterOfBinaryTree {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	static class Height {
		int h;
	}

	public static void main(String[] args) {
		Node root = new Node(69);
		getRandomTreeGeneration(root, 2, 0);
		System.out.println(diameter(root));
	}

	static int diameter(Node root) {
		return diameterOpt(root, new Height());
	}

	static int diameterOpt(Node root, Height height) {
		Height lh = new Height();
		Height rh = new Height();

		if (root == null) {
			height.h = 0;
			return 0;
		}

		int ldiameter = diameterOpt(root.left, lh);
		int rdiameter = diameterOpt(root.right, rh);

		height.h = Math.max(lh.h, rh.h) + 1;

		return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
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
