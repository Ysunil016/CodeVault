package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderPrint {

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
		root.right = new Node(2);
		root.left = new Node(3);

		getReverseLevelOrder(root);
	}

	static void getReverseLevelOrder(Node root) {
		Queue<Node> store = new LinkedList<Node>();
		store.add(root);

		Stack<Node> sTore = new Stack<Node>();
		sTore.push(root);

		while (!store.isEmpty()) {
			Node t = store.poll();
			if (t.right != null) {
				store.add(t.right);
				sTore.push(t.right);
			}
			if (t.left != null) {
				store.add(t.left);
				sTore.push(t.left);
			}
		}

		while (!sTore.isEmpty()) {
			System.out.print(sTore.pop().data+" ");
		}
	}

}
