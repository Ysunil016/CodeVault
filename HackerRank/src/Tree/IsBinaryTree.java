package Tree;

public class IsBinaryTree {

	static class Node {
		int data;
		Node right = null;
		Node left = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.right = new Node(2);
		root.right.left = new Node(2);
		root.right.right = new Node(4);
		root.right.right.right = new Node(5);
		root.right.right.right = new Node(6);
		root.right.right.right = new Node(7);

		System.out.println(isBinarySTree(root));
	}

	static boolean isBinarySTree(Node root) {
		return chBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean chBST(Node root, int min, int max) {
		if (root == null)
			return true;

		System.out.println("AT " + root.data + " MIN " + min + " and MAX " + max);

		if (root.data >= max || root.data <= min)
			return false;

		return chBST(root.left, min, root.data) && chBST(root.right, root.data, max);

	}

}
