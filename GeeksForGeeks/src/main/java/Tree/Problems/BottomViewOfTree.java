package Tree.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class BottomViewOfTree {
	static class Node {
		int data;
		int level = Integer.MAX_VALUE;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(69);
		getRandomTreeGeneration(root, 2, 0);
		TreeMap<Integer, ArrayList<Node>> nodeStore = new TreeMap<Integer, ArrayList<Node>>();
		getNodesByVerticalIndex(root, 0, nodeStore);

		System.out.println(nodeStore);

		for (Map.Entry<Integer, ArrayList<Node>> node : nodeStore.entrySet()) {
			System.out.println(node.getValue().get(node.getValue().size() - 1).data);
		}

	}

	static void getNodesByVerticalIndex(Node root, int index, TreeMap<Integer, ArrayList<Node>> nodeStore) {
		if (root == null)
			return;

		LinkedList<Node> queue = new LinkedList<Node>();
		root.level = 0;
		queue.add(root);

		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();

			ArrayList<Node> currentLevelNodes = nodeStore.get(currentNode.level);
			if (currentLevelNodes == null) {
				currentLevelNodes = new ArrayList<Node>();
			}
			currentLevelNodes.add(currentNode);
			nodeStore.put(currentNode.level, currentLevelNodes);

			if (currentNode.left != null) {
				currentNode.left.level = currentNode.level - 1;
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				currentNode.right.level = currentNode.level + 1;
				queue.add(currentNode.right);
			}

		}
	}

	static Node getRandomTreeGeneration(Node root, int levelCounter, int currentCounter) {

		if (root == null)
			return null;

		if (currentCounter > levelCounter)
			return null;

		// Assigning Random Value to Node
		root.left = new Node((int) (Math.random() * 100));
		root.right = new Node((int) (Math.random() * 100));

		System.out.println(root.data + " has " + root.left.data + " - " + root.right.data);

		// Calling Recursively
		getRandomTreeGeneration(root.left, levelCounter, ++currentCounter);
		getRandomTreeGeneration(root.right, levelCounter, ++currentCounter);

		return root;
	}

}
