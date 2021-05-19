package Tree;

public class DeleteNodeFromBST {

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

//		Node root = new Node(5);
//		root.right = new Node(6);
//		root.right.right = new Node(7);
//		root.left = new Node(4);
//		root.left.left = new Node(3);
//		root.left.left.left = new Node(2);

		inOrder(root);
		System.out.println();
		deleteNode(root, 81, null);
		System.out.println();
		inOrder(root);
	}

	static Node deleteNode(Node root, int key, Node parent) {
		if (root.data != key) {
			if (key < root.data)
				return deleteNode(root.left, key, root);
			else
				return deleteNode(root.right, key, root);
		} else {

			// Leaf Node
			if (root.left == null && root.right == null) {
				if (parent.right == root)
					parent.right = null;
				else
					parent.left = null;
			}

			// Single Node
			if (root.left == null && root.right != null) {
				if (parent.right == root)
					parent.right = root.right;
				else
					parent.left = root.right;
			}
			// Single Node
			if (root.right == null && root.left != null) {
				if (parent.right == root)
					parent.right = root.left;
				else
					parent.left = root.left;
			}

			// Both Child
			if (root.right != null && root.left != null) {
				Node maxNode = findMinInTree(root.left);
				if (parent.right == root) {
					parent.right.data = maxNode.data;
					deleteNode(root.left, maxNode.data, root);
				} else {
					parent.left.data = maxNode.data;
					deleteNode(root.right, maxNode.data, root);
				}

			}

		}
		return root;
	}

	static Node findMinInTree(Node root) {
		Node minNode = root;
		while (root != null) {
			if (root.right == null)
				return root;
			else {
				minNode = root;
				root = root.right;
			}
		}
		return minNode;
	}

	static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
}
