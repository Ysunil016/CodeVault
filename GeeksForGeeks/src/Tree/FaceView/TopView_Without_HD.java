package Tree.FaceView;

import java.util.Map;
import java.util.TreeMap;

public class TopView_Without_HD {
	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	static TreeMap<Integer, Node> topViewStore = new TreeMap<Integer, Node>();

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		root.right.left = new Node(5);
		root.right.left.left = new Node(8);
		
		
		
		getTopView(root, 0);
		for (Map.Entry<Integer, Node> node : topViewStore.entrySet()) {
			System.out.print(node.getValue().data + " ");
		}
		
	}

	static void getTopView(Node root, int nodeV) {
		if (root == null)
			return;

		if (!topViewStore.containsKey(nodeV))
			topViewStore.put(nodeV, root);
		System.out.println("Node " + root.data + " is at " + nodeV);
		getTopView(root.left, --nodeV);
		nodeV++;
		getTopView(root.right, ++nodeV);
	}

}
