package Tree;

public class PrintBSTInRange {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(2);
		root.right = new Node(81);
		root.right.right = new Node(87);
		root.right.left = new Node(42);
		root.right.left.right = new Node(66);
		root.right.right.right = new Node(90);
		root.right.left.right.left = new Node(45);

		getPreOrderTraversal(root, 40, 69);
	}

	static void getPreOrderTraversal(Node root, int x, int y) {
		if (root == null)
			return;

		getPreOrderTraversal(root.left, x, y);
		if (root.data > x && root.data < y)
			System.out.print(root.data + " ");
		getPreOrderTraversal(root.right, x, y);
	}

}
