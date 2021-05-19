package Tree.Problems;

public class MaxSumPathInBinaryTree {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static class Result {
		int result;
	}

	public static void main(String[] args) {
		Node root = new Node(69);
		getRandomTreeGeneration(root, 2, 0);

		Result fR = new Result();
		fR.result = Integer.MIN_VALUE;
		findMax(root, fR);

		System.out.println("Max Path Sum " + fR.result);
	}

	static int findMax(Node root, Result result) {
		if (root == null)
			return 0;

		int left = findMax(root.left, result);
		int right = findMax(root.right, result);

		// Calculating Path Distance from Root
		int maxSingle = Math.max(Math.max(left, right) + root.data, root.data);

		int maxTop = Math.max(maxSingle, left + right + root.data);

		result.result = Math.max(result.result, maxTop);

		return maxSingle;
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
