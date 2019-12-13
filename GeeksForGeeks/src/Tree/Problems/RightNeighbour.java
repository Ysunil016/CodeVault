package Tree.Problems;

import java.util.ArrayList;
import java.util.TreeMap;

public class RightNeighbour {

	static class Node {
		int data;
		Node left = null;
		Node right = null;
		Node rightNeighbour = null;

		Node(int data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {
		System.out.println("Auto Generated Tree");
		System.out.println();
		Node rootNode = new Node(21);
		getRandomTreeGeneration(rootNode, 2, 0);

		System.out.println();

		TreeMap<Integer, ArrayList<Node>> nodeStore = new TreeMap<Integer, ArrayList<Node>>();
		getNodesByLevel(rootNode, 0, nodeStore);

		System.out.println("Level Order Nodes ");
		System.out.println();

		for (int i = 0; i < nodeStore.size(); i++) {
			System.out.println("Level " + i);
			for (int j = 0; j < nodeStore.get(i).size(); j++) {
				System.out.print("-> " + nodeStore.get(i).get(j).data);
			}
			System.out.println();
		}

		getRightNeighboursOfNodes(rootNode, 0, nodeStore);

		System.out.println("\nFinding Right Neighbours\n");
		getPreOrder(rootNode);
	}

	public static void getRightNeighboursOfNodes(Node root, int index, TreeMap<Integer, ArrayList<Node>> nodeStore) {
		if (root == null)
			return;

		if (root.left != null) {
			if (root.right != null)
				root.left.rightNeighbour = root.right;
			else
				root.left.rightNeighbour = getRightNeighbour(root.left, nodeStore.get(index + 1));
		}
		if (root.right != null) {
			root.right.rightNeighbour = getRightNeighbour(root.right, nodeStore.get(index + 1));
		}

		getRightNeighboursOfNodes(root.left, index + 1, nodeStore);
		getRightNeighboursOfNodes(root.right, index + 1, nodeStore);

	}

	static void getNodesByLevel(Node root, int level, TreeMap<Integer, ArrayList<Node>> nodeStore) {
		if (root == null)
			return;

		ArrayList<Node> currentLevelNodes = nodeStore.get(level);
		if (currentLevelNodes == null) {
			currentLevelNodes = new ArrayList<RightNeighbour.Node>();
		}
		currentLevelNodes.add(root);
		nodeStore.put(level, currentLevelNodes);

		getNodesByLevel(root.left, level + 1, nodeStore);
		getNodesByLevel(root.right, level + 1, nodeStore);
	}

	static Node getRightNeighbour(Node node, ArrayList<Node> levelNodes) {

		for (int i = 0; i < levelNodes.size(); i++) {
			if (node.equals(levelNodes.get(i))) {
				if (i != levelNodes.size() - 1)
					return levelNodes.get(i + 1);
				else
					return null;
			}
		}
		return null;
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

	static void getPreOrder(Node root) {
		if (root == null)
			return;
		if (root.rightNeighbour != null)
			System.out.println("Node " + root.data + " has Right Neigbour as " + root.rightNeighbour.data);
		else
			System.out.println("Node " + root.data);

		getPreOrder(root.left);
		getPreOrder(root.right);
	}

}
