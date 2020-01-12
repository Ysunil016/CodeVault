package Tree;

public class SwapNodes {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		int[][] indexes = { { 2, 3 }, { 4, -1 }, { 5, -1 }, { 6, -1 }, { 7, 8 }, { -1, 9 }, { -1, -1 }, { 10, 11 },
				{ -1, -1 }, { -1, -1 }, { -1, -1 } };
		int[] queries = { 2, 4 };
		int[][] result = swapNodes(indexes, queries);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int[][] swapNodes(int[][] indexes, int[] queries) {
		// First of All Making a Tree Out of Indices
		Node root = new Node(1);
		getTree(root, -1, indexes, 0);
		preOrder(root);
		return new int[0][0];
	}

	static Node getTree(Node root, int indexP, int[][] indexes, int index) {
		if (index == -1 || root == null)
			return new Node(indexP);

		System.out.println(indexes[index][0] + " and " + indexes[index][1]);

		if (indexes[index][0] != -1) {
			System.out.println(indexes[index][0]);
			root.left = getTree(root.left, indexes[index][0], indexes, indexes[index][0] - 1);
		}
		if (indexes[index][1] != -1) {
			System.out.println(indexes[index][1]);
			root.right = getTree(root.right, indexes[index][1], indexes, indexes[index][1] - 1);
		}
		return root;
	}

	static void preOrder(Node root) {
		if (root == null)
			return;
		preOrder(root.left);
		System.out.print("->" + root.data + " ");
		preOrder(root.right);
	}

}
