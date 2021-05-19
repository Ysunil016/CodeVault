package Tree;

public class MakingBSTFromArray {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
		Node result = getBinarySearchTree(arr);
		traverse(result);
	}

	static Node getBinarySearchTree(int[] arr) {
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			if (root == null) {
				root = new Node(arr[i]);
			} else {
				binaryInsertion(root, arr[i]);
			}
		}
		return root;
	}

	static void binaryInsertion(Node root, int data) {
		if (data < root.data) {
			if (root.left != null) {
				binaryInsertion(root.left, data);
			} else {
				root.left = new Node(data);
			}
		} else {
			if (root.right != null) {
				binaryInsertion(root.right, data);
			} else {
				root.right = new Node(data);
			}
		}
	}

	static void traverse(Node root) {
		if (root == null)
			return;
		System.out.print("-> " + root.data);
		traverse(root.left);
		traverse(root.right);
	}
}
