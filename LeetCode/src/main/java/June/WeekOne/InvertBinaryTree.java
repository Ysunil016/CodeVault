package June.WeekOne;

public class InvertBinaryTree {

	static class Node {
		int val;
		Node left = null;
		Node right = null;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		invertTree(root);
	}

	private static Node invertTree(Node root) {
		invertNode(root);
		return root;
	}

	private static void invertNode(Node root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			return;

		Node x = root.right;
		root.right = root.left;
		root.left = x;

		invertNode(root.left);
		invertNode(root.right);
	}

}
