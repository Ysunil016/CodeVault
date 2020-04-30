package _30Days.WeekFive;

public class isValidSequence {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {

		int[] arr = { 0, 0, 0, 1 };

		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);

		System.out.println(isValidSequence_(root, arr));

	}

	static public boolean isValidSequence_(TreeNode root, int[] arr) {
		if (root == null)
			return (arr.length == 0) ? true : false;
		return dfs(root, arr, 0);
	}

	static boolean dfs(TreeNode root, int[] arr, int index) {
		if (arr[index] != root.val)
			return false;

		if (index == (arr.length - 1)) {
			return (root.left == null && root.right == null);
		}

		return ((root.left != null && dfs(root.left, arr, index + 1))
				|| (root.right != null && dfs(root.right, arr, index + 1)));
	}
}
