package April.WeekTwo;

public class DiameterOfTree {

	static class TreeNode {
		int data;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(diameterOfBinaryTree(root));
	}

	private static int longestPath = 0;

	public static int diameterOfBinaryTree(TreeNode root) {
		longestPath(root);
		return longestPath;
	}

	// Since Height of a Node is actually its longest path... so collaborating these two will give out the result.
	private static int longestPath(TreeNode root) {
		if (root == null)
			return 0;

		int leftHeight = longestPath(root.left);
		int rightHeight = longestPath(root.right);
		longestPath = Math.max(longestPath, (leftHeight + rightHeight));
		return Math.max(leftHeight, rightHeight) + 1;
	}

}
