package Tree.Problems;

import java.util.ArrayList;

public class isBST {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		public Node(int data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {
		Node root = new Node(20);
		Node root1 = root.left = new Node(10);
		Node root2 = root1.left = new Node(5);
		Node root3 = root2.left = new Node(1);
		root3.right = new Node(50);

		System.out.println(isBSTM(root));
	}

	static int isBSTM(Node root) {

		ArrayList<Integer> sortedNode = new ArrayList<Integer>();
		inOrderBST(root, sortedNode);

		System.out.println(sortedNode);

		for (int i = 0; i < sortedNode.size() - 1; i++) {
			if (sortedNode.get(i) > sortedNode.get(i + 1))
				return 0;
		}

		return 1;
	}

	static void inOrderBST(Node root, ArrayList<Integer> sortedArray) {
		if (root == null)
			return;

		inOrderBST(root.left, sortedArray);
		sortedArray.add(root.data);
		inOrderBST(root.right, sortedArray);
	}

}
