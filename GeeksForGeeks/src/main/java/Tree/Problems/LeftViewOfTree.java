package Tree.Problems;

import java.util.ArrayList;
import java.util.TreeMap;

public class LeftViewOfTree {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(69);
		getRandomTreeGeneration(root, 3, 0);
		TreeMap<Integer, ArrayList<Node>> nodeStore = new TreeMap<Integer, ArrayList<Node>>();
		getNodesByLevel(root, 0, nodeStore);

		System.out.println();
		System.out.println("Left View of Node ");
		System.out.println();
		for (int i = 0; i < nodeStore.size(); i++) {
			System.out.println("-> " + nodeStore.get(i).get(0).data);
		}
	}

	static void getNodesByLevel(Node root, int level, TreeMap<Integer, ArrayList<Node>> nodeStore) {
		if (root == null)
			return;

		ArrayList<Node> currentLevelNodes = nodeStore.get(level);
		if (currentLevelNodes == null) {
			currentLevelNodes = new ArrayList<Node>();
		}
		currentLevelNodes.add(root);
		nodeStore.put(level, currentLevelNodes);

		getNodesByLevel(root.left, level + 1, nodeStore);
		getNodesByLevel(root.right, level + 1, nodeStore);
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
