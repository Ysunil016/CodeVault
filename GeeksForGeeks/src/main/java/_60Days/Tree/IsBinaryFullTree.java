package _60Days.Tree;

public class IsBinaryFullTree {

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
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
		System.out.println(isFullTree(root));
	}

	static boolean isFullTree(TreeNode root) {
		if (root == null)
			return true;
		if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
			return false;
		}
		return isFullTree(root.left) && isFullTree(root.right);
	}

}
