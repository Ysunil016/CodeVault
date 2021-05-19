package _60Days.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBinaryTree {

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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(5);
		root.left.right.right.right = new TreeNode(6);
		root.left.right.right.right.right = new TreeNode(7);
		root.left.right.right.right.right.right = new TreeNode(8);

		getTopView(root, 0);

		for (int Key : treeSet.keySet()) {
			System.out.println(treeSet.get(Key));
		}

	}

	static void getTopView(TreeNode root, int digit) {
		if (root == null)
			return;

		class Node {
			TreeNode node;
			int hd;

			public Node(TreeNode node, int hd) {
				this.node = node;
				this.hd = hd;
			}

		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(root, 0));

		while (!queue.isEmpty()) {
			Node n = queue.poll();
			treeSet.putIfAbsent(n.hd, n.node.val);
			if (n.node.left != null) {
				queue.add(new Node(n.node.left, n.hd - 1));
			}
			if (n.node.right != null) {
				queue.add(new Node(n.node.right, n.hd + 1));
			}
		}

	}

}
