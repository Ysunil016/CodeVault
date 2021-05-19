package Tree.Problems;

public class CommonAncestorofBST {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	static Node commonNode;

	public static void main(String[] args) {
		Node root = new Node(23);
		Node root2 = root.left = new Node(10);
		Node root3 = root.right = new Node(35);
		root2.left = new Node(2);
		root2.right = new Node(16);
		root3.left = new Node(30);
		root3.right = new Node(49);

		getCommonAncestor(root3, 16, 49);
		System.out.println(commonNode.data);
	}

	public static void getCommonAncestor(Node root, int n1, int n2) {
		if (root == null)
			return;

		if (root.data > n1 && root.data > n2) {
			getCommonAncestor(root.left, n1, n2);
		} else if (root.data < n1 && root.data < n2) {
			getCommonAncestor(root.right, n1, n2);
		} else if (root.data == n1) {
			commonNode = root;
		} else if (root.data == n2) {
			commonNode = root;
		} else {
			commonNode = root;
		}

	}

}
