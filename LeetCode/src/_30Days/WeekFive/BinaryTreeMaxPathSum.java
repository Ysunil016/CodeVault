package _30Days.WeekFive;

public class BinaryTreeMaxPathSum {

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

	static int MaxAnswer = Integer.MIN_VALUE;

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(-1);
//		root.right = new TreeNode(20);
//		root.right.right = new TreeNode(7);
//		root.right.left = new TreeNode(15);
		System.out.println(dfs(root));

		System.out.println(MaxAnswer);

	}

	static int dfs(TreeNode root) {
		if (root == null)
			return 0;

		int x = dfs(root.left);
		int y = dfs(root.right);
		MaxAnswer = Math.max(MaxAnswer, x + y + root.val);
		return Math.max(0, Math.max(x, y) + root.val);
	}

}
