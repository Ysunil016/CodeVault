package Tree.Problems;

public class SumTree {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	static int sumTree = 0;

	public static void main(String[] args) {

		Node root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(6);
		root.left.left.left.right = new Node(1);
//		root.right.right = new Node(2);
		sumTree = 0;

		isSumTree(root.left);
	}

	static boolean isSumTree(Node root) {
		if (root == null)
			return true;

		return (isSumTreeP(root) == 1) ? true : false;
	}

	static int isSumTreeP(Node node) {
		int ls, rs;

		if ((node == null) || (node.left == null && node.right == null))
			return 1;

		ls = sum(node.left);
		rs = sum(node.right);

		if ((node.data == ls + rs) && (isSumTreeP(node.left) != 0) && (isSumTreeP(node.right)) != 0)
			return 1;

		return 0;
	}

	static int sum(Node node) {
		if (node == null)
			return 0;
		return sum(node.left) + node.data + sum(node.right);
	}
}
