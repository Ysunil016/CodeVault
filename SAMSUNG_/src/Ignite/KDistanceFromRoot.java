package Ignite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class KDistanceFromRoot {

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
		root.right.left = new Node(40);
		root.right.right = new Node(50);
		root.right.right.right = new Node(70);
		root.right.left.left = new Node(60);
		root.right.left.left.left = new Node(30);

		// Finding All Nodes at Level as Given By User
		int getNodesAtDistance = 3;
		findNodesAtDistance(root, getNodesAtDistance);
	}

	static void findNodesAtDistance(Node root, int getNodesAtDistance) {
		// Lets First Get All the Node BAsed on Level
		HashMap<Integer, ArrayList<Node>> levelBasedNodes = new HashMap<Integer, ArrayList<Node>>();
		levelOrderTraversalStorage(root, levelBasedNodes);

		ArrayList<Node> arrayList = levelBasedNodes.get(getNodesAtDistance);
		for (Node node : arrayList)
			System.out.print("-> " + node.data);

	}

	static HashMap<Integer, ArrayList<Node>> levelOrderTraversalStorage(Node root,
			HashMap<Integer, ArrayList<Node>> hStore) {

		Queue<Node> qStore = new LinkedList<>();
		qStore.add(root);

		// init Level at 0
		int level = 0;
		while (true) {
			int counter = qStore.size();
			if (counter == 0)
				break;

			while (counter > 0) {
				Node node = qStore.poll();

				// Checking if hStore
				if (!hStore.containsKey(level)) {
					ArrayList<Node> arr = new ArrayList<Node>();
					arr.add(node);
					hStore.put(level, arr);
				} else {
					ArrayList<Node> arr = hStore.get(level);
					arr.add(node);
					hStore.put(level, arr);
				}

				// Checking if Node has Left and Right
				if (node.left != null)
					qStore.add(node.left);
				if (node.right != null)
					qStore.add(node.right);

				counter--;

			}

			// Incrementing for Next Level
			level++;

		}

		return hStore;
	}

}
