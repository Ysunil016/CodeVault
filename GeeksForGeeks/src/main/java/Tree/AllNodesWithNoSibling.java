package Tree;

public class AllNodesWithNoSibling {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.left.left = new Node(6);

		getAllNode(root);
	}

	static void getAllNode(Node root) {
		if (root == null)
			return;

		if (root.left == null && root.right != null) {
			System.out.print(root.right.data + " ");
		} else if (root.left != null && root.right == null) {
			System.out.print(root.left.data + " ");
		}

		getAllNode(root.left);
		getAllNode(root.right);

	}

}
