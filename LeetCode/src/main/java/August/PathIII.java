package August;

public class PathIII {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {

	}

	static int resCount = 0;

	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		doForEach(root, sum);
		return resCount;
	}

	private static void doForEach(TreeNode root, int finalSum) {
		if (root == null)
			return;

		findPath(root, finalSum, root.val);

		doForEach(root.left, finalSum);
		doForEach(root.right, finalSum);
	}

	private static void findPath(TreeNode root, int finalSum, int curSum) {
		if (curSum == finalSum)
			resCount++;

		if (root == null)
			return;

		if (root.left != null)
			findPath(root.left, finalSum, curSum + root.left.val);
		if (root.right != null)
			findPath(root.right, finalSum, curSum + root.right.val);
	}

}
