package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder_LineByLine {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(60);
//		root.left.right.left = new Node(10);
//		root.left.right.right = new Node(14);

		int height = 4;
		for (int i = 1; i <= height; i++) {
			getLineByLine(root, i);
			System.out.println();
		}

		System.out.println("\nOptamized\n");

		printLineByLine(root);
	}

	static void getLineByLine(Node root, int level) {
		if (root == null)
			return;

		if (level == 1) {
			System.out.print(" " + root.data);
		} else if (level > 1) {
			getLineByLine(root.left, level - 1);
			getLineByLine(root.right, level - 1);
		}
	}

	static void printLineByLine(Node root) {

		Queue<Node> nodeStore = new LinkedList<LevelOrder_LineByLine.Node>();
		nodeStore.add(root);
		while (true) {
			int nodeCount = nodeStore.size();

			if (nodeCount == 0)
				break;

			while (nodeCount > 0) {
				Node currentNode = nodeStore.remove();
				if (currentNode.data != -1) {
					System.out.print(currentNode.data + " ");
					if (currentNode.left != null)
						nodeStore.add(currentNode.left);
					if (currentNode.right != null)
						nodeStore.add(currentNode.right);
				} else {

				}
				nodeCount--;
			}
			System.out.print("$ ");
		}

	}

}
