package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		Node rooNode = new Node(69);
		Node root = getRandomTreeGeneration(rooNode, 2, 0);
		System.out.println();

		// TreeMap because it is implemented using Red-Black Tree, that return Sorted
		// Entry
		TreeMap<Integer, Node> node = new TreeMap<Integer, Node>();
		treeTopView(root, 0, node);

		System.out.println();

		// Left Face
		System.out.println("Left Face View");
		for (Map.Entry<Integer, Node> nodex : node.entrySet()) {
			System.out.print("-> " + nodex.getValue().data);
		}

	}

	public static void treeTopView(Node node, int level, TreeMap<Integer, Node> allNodesData) {
		class QueueObj {
			Node node;
			int hd;

			QueueObj(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}

		if (node == null)
			return;

		Queue<QueueObj> q = new LinkedList<QueueObj>();
		q.add(new QueueObj(node, 0));

		while (!q.isEmpty()) {
			QueueObj tmpNode = q.poll();
			if (!allNodesData.containsKey(tmpNode.hd)) {
				allNodesData.put(tmpNode.hd, tmpNode.node);
			}

			if (tmpNode.node.left != null) {
				q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
			}
			if (tmpNode.node.right != null) {
				q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
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
