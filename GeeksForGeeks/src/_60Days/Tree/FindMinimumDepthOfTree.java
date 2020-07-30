package _60Days.Tree;

public class FindMinimumDepthOfTree {

	static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);

		System.out.println(getMinHeight(root));
	}

	static int getMinHeight(Node root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		if (root.left == null)
			return getMinHeight(root.right) + 1;
		if (root.right == null)
			return getMinHeight(root.left) + 1;

		return Math.min(getMinHeight(root.left), getMinHeight(root.right)) + 1;
	}

}
