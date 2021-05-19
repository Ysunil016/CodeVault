package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class NoSiblingNodeInParent {

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
		root.left = new Node(20);
		root.left.left = new Node(30);
		root.left.right = new Node(40);
		root.left.left.left = new Node(50);
		root.left.left.right = new Node(60);
		root.left.right.right = new Node(70);
		root.left.right.right.right = new Node(80);

		getAllNoSiblingNode(root);

	}

	// PreOrder Fashion
	static void getAllNoSiblingNode(Node root) {
		if (root == null)
			return;

		Queue<Node> storeL = new LinkedList<Node>();
		storeL.add(root);

		while (!storeL.isEmpty()) {

			Node rootR = storeL.poll();
			if ((rootR.left != null && rootR.right == null) || (rootR.left == null && rootR.right != null))
				if (rootR.right != null)
					System.out.print(rootR.right.data+" ");
				else
					System.out.print(rootR.left.data+" ");

			if (rootR.right != null)
				storeL.add(rootR.right);
			if (rootR.left != null)
				storeL.add(rootR.left);

		}
	}

}
