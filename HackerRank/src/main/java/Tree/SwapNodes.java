package Tree;

public class SwapNodes {

	static class TreeNode {
		int data;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		int[][] indexes = { { 2, 3 }, { 4, -1 }, { 5, -1 }, { 6, -1 }, { 7, 8 }, { -1, 9 }, { -1, -1 }, { 10, 11 },
				{ -1, -1 }, { -1, -1 }, { -1, -1 } };
		int[] queries = { 2, 4 };
		int[][] result = swapNodes(indexes, queries);
		System.out.println();
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int[][] swapNodes(int[][] indexes, int[] queries) {
		TreeNode root = new TreeNode(1);
		makingTree(root, indexes, 1);

		for (int i = 0; i < queries.length; i++) {
			swapNodeAtDepth(root, 1, queries[i]);
		}
		inOrder(root);
		int[][] result = new int[indexes.length][2];
		makeValue(root, result);
		return result;
	}

	private static void makeValue(TreeNode root, int[][] res) {
		if (root == null)
			return;

		if (root.left != null) {
			res[root.data - 1][0] = root.left.data;
		} else {
			res[root.data - 1][0] = -1;

		}
		if (root.right != null) {
			res[root.data - 1][1] = root.right.data;
		} else {
			res[root.data - 1][1] = -1;
		}
		makeValue(root.left, res);
		makeValue(root.right, res);
	}

	static private void swapNodeAtDepth(TreeNode root, int currentDepth, int depth) {
		if (root == null) {
			return;
		}
		if (currentDepth == depth) {
			TreeNode holdNode = root.left;
			root.left = root.right;
			root.right = holdNode;
			return;
		}
		swapNodeAtDepth(root.left, currentDepth + 1, depth);
		swapNodeAtDepth(root.right, currentDepth + 1, depth);
	}

	static private void makingTree(TreeNode root, int[][] indexes, int index) {
		if (root == null) {
			return;
		}
		if (indexes[index - 1][0] != -1) {
			root.left = new TreeNode(indexes[index - 1][0]);
			makingTree(root.left, indexes, indexes[index - 1][0]);
		}
		if (indexes[index - 1][1] != -1) {
			root.right = new TreeNode(indexes[index - 1][1]);
			makingTree(root.right, indexes, indexes[index - 1][1]);
		}
	}

	static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print("->" + root.data + " ");
		inOrder(root.right);
	}

}
