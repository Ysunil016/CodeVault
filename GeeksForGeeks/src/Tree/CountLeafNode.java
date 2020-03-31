package Tree;

public class CountLeafNode {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(2);
		root.left.right = new Node(7);
		root.right.left = new Node(12);
		root.right.right = new Node(15);

		System.out.println(getLeafsCount(root, 0));

	}

	static int getLeafsCount(Node root, int count) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		return getLeafsCount(root.left, count) + getLeafsCount(root.right, count);

	}

}
