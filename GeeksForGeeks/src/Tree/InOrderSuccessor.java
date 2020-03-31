package Tree;

public class InOrderSuccessor {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	static Node fNode = null;
	static boolean findNext = false;

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.left.right = new Node(17);

		inorderSuccessor(root, root.right.left);
		System.out.println(fNode.data);
	}

	static Node inorderSuccessor(Node root, Node xNode) {
		if (root == null)
			return null;

		inorderSuccessor(root.left, xNode);

		if (findNext) {
			fNode = root;
			findNext = false;
		}
		if (root.data == xNode.data) {
			fNode = new Node(-1);
			findNext = true;
		}

		inorderSuccessor(root.right, xNode);

		return fNode;
	}

}
