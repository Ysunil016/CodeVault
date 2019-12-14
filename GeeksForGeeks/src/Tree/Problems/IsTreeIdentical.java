package Tree.Problems;

public class IsTreeIdentical {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root1 = new Node(69);
		getRandomTreeGeneration(root1, 3, 0);

		Node root2 = new Node(69);
		getRandomTreeGeneration(root2, 3, 0);

		System.out.println(isIdentical(root1, root2));
	}

	static boolean isIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 != null && root2 == null) {
			return false;
		}
		if (root1 == null && root2 != null) {
			return false;
		}

		if (root1.data != root2.data) {
			return false;
		}

		return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);

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
