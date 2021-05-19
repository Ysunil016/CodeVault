package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewTree {

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.right.left = new Node(8);
		root.right.right.left = new Node(9);

		topView2(root);
	}

	static void topView2(Node root) {

		// Declaring New Structure that Stores height w.r.t to Node as Well
		class hNode {
			Node node;
			int poition = 0;

			hNode(Node node, int height) {
				this.node = node;
				this.poition = height;
			}
		}

		TreeMap<Integer, Integer> store = new TreeMap<Integer, Integer>();

		// Declaring Queue for Rolling It Over at Every New Level
		Queue<hNode> queue = new LinkedList<hNode>();
		queue.add(new hNode(root, 0));
		int level = -1;
		while (true) {
			int count = queue.size();
			if (count == 0)
				break;

			level++;

			while (count > 0) {
				hNode node = queue.poll();
				if (node.node.left != null) {
					queue.add(new hNode(node.node.left, node.poition - 1));
				}
				if (node.node.right != null) {
					queue.add(new hNode(node.node.right, node.poition + 1));
				}
				count--;

				// Storing Height Details in Hash Store
				if (!store.containsKey(node.poition)) {
					store.put(node.poition, node.node.data);
				}

				System.out.println("At Level " + level + " Node " + node.node.data + " and " + node.poition);
			}

		}

		// Fetching Sequence from Hash based on Tree Map
		for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}

	}

}
