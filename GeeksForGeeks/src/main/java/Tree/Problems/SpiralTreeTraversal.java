package Tree.Problems;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SpiralTreeTraversal {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node rootNode = new Node(69);
		getRandomTreeGeneration(rootNode, 2, 0);

		System.out.println("Spiral Traversal");
		getSpiralTreeTraversal(rootNode);
	}

	static void getSpiralTreeTraversal(Node root) {
		TreeMap<Integer, ArrayList<Node>> nodeStore = new TreeMap<Integer, ArrayList<Node>>();
		getNodesByLevel(root, 0, nodeStore);

		boolean isEven = true;
		for (Map.Entry<Integer, ArrayList<Node>> node : nodeStore.entrySet()) {
			if (isEven) {
				for (int i = node.getValue().size() - 1; i >= 0; i--) {
					System.out.print(node.getValue().get(i).data + " ");
				}
				isEven = false;
			} else {
				for (int i = 0; i < node.getValue().size(); i++) {
					System.out.print(node.getValue().get(i).data + " ");
				}
				isEven = true;
			}
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

	public static Node getRandomTreeGeneration(Node root, int levelCounter, int currentCounter) {

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
