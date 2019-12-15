package Tree.Problems;

public class isBinaryTreeBalanced {

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


		System.out.println(isNodeBalanced(root));

	}

	static boolean isNodeBalanced(Node root) {
		if (root == null)
			return true;

		int leftTreeHeight = heightOfNode(root.left);

		int rightTreeHeight = heightOfNode(root.right);

		int difference = leftTreeHeight - rightTreeHeight;

		System.out.println("Lef "+leftTreeHeight+" and Right "+rightTreeHeight);
		
		if (Math.abs(difference)<=1 && isNodeBalanced(root.left) && isNodeBalanced(root.right)) {
			return true;
		} else {
			return false;
		}
	}

	static int heightOfNode(Node node) {
		if (node == null)
			return 0;

		return Math.max(heightOfNode(node.left), heightOfNode(node.right)) + 1;
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
