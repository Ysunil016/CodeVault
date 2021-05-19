package _60Days.Tree;

public class RootLeafSum {

	static class TreeNode {
		int Val;
		TreeNode Left;
		TreeNode Right;

		public TreeNode(int Val) {
			this.Val = Val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.Left = new TreeNode(12);
		root.Left.Right = new TreeNode(16);

		root.Right = new TreeNode(5);
		root.Right.Left = new TreeNode(40);

		getPathSumBinaryTree(root, 0);
	}

	static void getPathSumBinaryTree(TreeNode root, int Sum) {
		if (root == null)
			return;

		Sum += root.Val;

		if (root.Left == null && root.Right == null) {
			System.out.print(" --> " + Sum);
			return;
		}

		getPathSumBinaryTree(root.Left, Sum);
		getPathSumBinaryTree(root.Right, Sum);
	}

}
