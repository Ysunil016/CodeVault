package _60Days.Tree;

import java.util.TreeMap;

public class BottomViewBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	static TreeMap<Integer, Integer> treeSet = new TreeMap<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(25);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);

		getBottomView(root, 0);

		for (int Key : treeSet.keySet()) {
			System.out.println(treeSet.get(Key));
		}

	}

	static void getBottomView(TreeNode root, int digit) {
		if (root == null)
			return;

		treeSet.put(digit, root.val);

		getBottomView(root.left, digit - 1);
		getBottomView(root.right, digit + 1);

	}

}
