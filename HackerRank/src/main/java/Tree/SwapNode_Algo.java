package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class SwapNode_Algo {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	static TreeMap<Integer, ArrayList<Node>> store = new TreeMap<Integer, ArrayList<Node>>();

	static int level = 0;

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.left.left.right = new Node(4);
		root.left.left.right.right = new Node(13);
		root.right.left = new Node(7);
		root.right.right = new Node(8);
		root.right.left.left = new Node(11);
		root.right.left.left.right = new Node(12);
		root.right.right.left = new Node(9);
		root.right.right.left.right = new Node(10);

		getNodeLevelByLevel(root);
		preOrder(root);
		System.out.println();
		System.out.println();

		for (Map.Entry<Integer, ArrayList<Node>> key : store.entrySet()) {
			key.getValue().forEach(node -> {
				System.out.print(node.data + " ");
			});
			System.out.println();
		}
		int query = 2;
		for (int i = query; i <= level; i = i + 2) {
			swapNode(i - 1);
		}
		preOrder(root);
	}

	static void getNodeLevelByLevel(Node root) {
		if (root == null)
			return;

		Queue<Node> sNode = new LinkedList<Node>();
		sNode.add(root);

//		int level = 0;

		ArrayList<Node> nodeArray = new ArrayList<Node>();
		nodeArray.add(root);
		store.put(level, nodeArray);
		nodeArray = new ArrayList<Node>();

		while (true) {
			int nodeCount = sNode.size();

			if (nodeCount == 0)
				break;

			level++;
			while (nodeCount > 0) {
				Node node = sNode.poll();
				if (node.left != null) {
					sNode.add(node.left);
					nodeArray.add(node.left);
				}
				if (node.right != null) {
					sNode.add(node.right);
					nodeArray.add(node.right);
				}
				nodeCount--;
				store.put(level, nodeArray);
			}
			nodeArray = new ArrayList<Node>();
		}

	}

	static void preOrder(Node root) {
		if (root == null)
			return;

		preOrder(root.left);
		System.out.print(root.data + " ");
		preOrder(root.right);
	}

	static void swapNode(int x) {
		ArrayList<Node> nodeAtLevelX = store.get(x);
		for (Node node : nodeAtLevelX) {
			Node nodeRight = node.right;
			node.right = node.left;
			node.left = nodeRight;
		}
	}
}
