package July;

import java.util.HashMap;

public class WidthOfBinaryTree {

	static class TreeNode {
		int Val;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int Val) {
			this.Val = Val;
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(5);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		root.right.right.right.right = new TreeNode(9);
		System.out.println(widthOfBinaryTree(root));
	}

	static int MaxWidth;
	static HashMap<Integer, Integer> hash;

	public static int widthOfBinaryTree(TreeNode root) {
		hash = new HashMap<>();
		MaxWidth = 0;
		getWidth(root, 0, 0);
		return MaxWidth;
	}

	private static void getWidth(TreeNode root, int depth, int position) {
		if (root == null) {
			return;
		}
		hash.computeIfAbsent(depth, x -> position);
		MaxWidth = Math.max(MaxWidth, position - hash.get(depth) + 1);
		getWidth(root.left, depth + 1, position * 2);
		getWidth(root.right, depth + 1, (position * 2) + 1);
	}

}
