package Tree;

public class InsertNodeInBST {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Node insert(Node root, int data) {
		if (root == null)
			return new Node(data);

		Node node = root;

		while (true) {
			if (data == node.data)
				break;

			if (data > node.data) {
				if (node.right == null) {
					node.right = new Node(data);
					break;
				} else {
					node = node.right;
				}
			} else {
				if (node.left == null) {
					node.left = new Node(data);
					break;
				} else {
					node = node.left;
				}
			}
		}

		return root;
	}

}
