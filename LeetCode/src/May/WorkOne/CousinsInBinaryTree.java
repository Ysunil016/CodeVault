package May.WorkOne;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int data) {
			this.val = data;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(isCousins(root, 2, 5));

	}

	static boolean isCousins(TreeNode root, int x, int y) {
		if (root == null)
			return false;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		class Info {
			TreeNode node = null;
			TreeNode parent = null;
			Info() {}
			void setInfo(TreeNode node, TreeNode parent) {
				this.node = node;
				this.parent = parent;
			}
		}
		queue.add(root);
		while (true) {
			int size = queue.size();
			if (size == 0)
				break;
			Info XXX = new Info();
			Info YYY = new Info();
			while (size > 0) {
				TreeNode n = queue.poll();
				if (n.left != null) {
					queue.add(n.left);
					if (n.left.val == x) {
						XXX.setInfo(n.left, n);
					}
					if (n.left.val == y) {
						YYY.setInfo(n.left, n);
					}
				}
				if (n.right != null) {
					queue.add(n.right);
					if (n.right.val == x) {
						XXX.setInfo(n.right, n);
					}
					if (n.right.val == y) {
						YYY.setInfo(n.right, n);
					}
				}
				size--;
			}
			if (XXX.node != null && YYY.node != null) {
				if (XXX.parent != YYY.parent)
					return true;
				else
					return false;
			}
		}
		return false;
	}

}
