package September;

public class SumLeafRoot {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(0);

		System.out.println(sumRootToLeaf(root));
	}

	public static int sumRootToLeaf(TreeNode root) {
		return sumRootToLeaf(root, 0);
	}

	// Finding the Root End Point
	private static int sumRootToLeaf(TreeNode root, int val) {
		if (root == null)
			return 0;
		val = val * 2 + root.val;
		if (root.left == null && root.right == null)
			return val;
		return sumRootToLeaf(root.left, val) + sumRootToLeaf(root.right, val);
	}
}
