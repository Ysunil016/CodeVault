package Ignite;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.left.right.right = new Node(90);
		root.right.left = new Node(60);
		root.right.left.left = new Node(80);
		root.right.right = new Node(70);

		levelOrderTraversal(root);
	}

	static void levelOrderTraversal(Node root) {
		if (root == null)
			return;
		Queue<Node> storeNode = new LinkedList<>();
		storeNode.add(root);
		// Iterating for Infinite Loop
		while (true) {
			// Getting Size Inside an List
			int count = storeNode.size();
			if (count == 0)
				break;
			// Looping Queue and Popping Out Based on Count, Based on Level Iterator is On
			while (count > 0) {
				Node node = storeNode.poll();
				System.out.print("-> " + node.data);
				if (node.left != null) {
					storeNode.add(node.left);
				}
				if (node.right != null) {
					storeNode.add(node.right);
				}
				count--;
			}
			System.out.println();
		}
	}

}
