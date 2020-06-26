package June.WeekFour;

public class SumRootLeaf {

	static class TreeNode {
		int val;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	private static int Result;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		System.out.println(sumNumbers(root));
	}

	private static int sumNumbers(TreeNode root) {
		Result = 0;
		traverse(root, 0);
		return Result;
	}

	private static void traverse(TreeNode root, int Sum) {
		if (root == null) {
			return;
		}
		Sum *= 10;
		Sum += root.val;
		if (root.left == null && root.right == null) {
			Result += Sum;
		}
		traverse(root.left, Sum);
		traverse(root.right, Sum);
	}

}
