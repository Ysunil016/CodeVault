package Tree.Problems;

import java.util.ArrayList;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

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
		root.left = new Node(1);
		root.left.left = new Node(2);
		root.left.left.right = new Node(3);

		String serialObject = serialize(root, new ArrayList<Integer>());

		System.out.println(serialObject);

		deSerialize(serialObject);

	}

	static String serialize(Node root, ArrayList<Integer> record) {

		ArrayList<String> list = new ArrayList<>();
		LinkedList<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			Node h = q.poll();
			if (h == null) {
				list.add("#");
			} else {
				list.add("" + h.data);
				q.offer(h.left);
				q.offer(h.right);
			}
		}
		return String.join(",", list);
	}

	static Node deSerialize(String data) {
		String[] obArray = data.split(",");
		if (obArray[0] == "#")
			return null;

		Node root = new Node(Integer.parseInt(obArray[0]));
		LinkedList<Node> store = new LinkedList<Node>();
		store.add(root);

		int i = 1;

		while (!store.isEmpty()) {
			Node currentNode = store.poll();
			if (currentNode != null) {
				Node left = null;
				if (!obArray[i].equals("#")) {
					left = new Node(Integer.parseInt(obArray[i]));
				}
				currentNode.left = left;
				store.add(left);
				i++;
				Node right = null;
				if (!obArray[i].equals("#")) {
					right = new Node(Integer.parseInt(obArray[i]));
				}
				currentNode.right = right;
				store.add(right);
				i++;

			}

		}

		return root;
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
