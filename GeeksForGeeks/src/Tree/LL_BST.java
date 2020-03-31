package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LL_BST {

	static class LNode {
		int data;
		LNode next = null;

		LNode(int data) {
			this.data = data;
		}
	}

	static class TNode {
		int data;
		TNode left = null;
		TNode right = null;

		TNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		LNode head = new LNode(10);
		head.next = new LNode(20);
		head.next.next = new LNode(30);
		head.next.next.next = new LNode(40);
		head.next.next.next.next = new LNode(50);
		head.next.next.next.next.next = new LNode(60);
		head.next.next.next.next.next.next = new LNode(70);
		head.next.next.next.next.next.next.next = new LNode(80);

		TNode root = new TNode(head.data);
		head = head.next;
		while (head != null) {
			insertNodeInTree(root, head);
			head = head.next;
		}
		preOrder(root);
	}

	static void insertNodeInTree(TNode root, LNode node) {

		Queue<TNode> store = new LinkedList<TNode>();
		store.add(root);
		while (!store.isEmpty()) {
			TNode r = store.poll();
			if (r.left != null) {
				store.add(r.left);
			}
			if (r.right != null) {
				store.add(r.right);
			}
			if (r.left == null) {
				r.left = new TNode(node.data);
				break;
			} else if (r.right == null) {
				r.right = new TNode(node.data);
				break;
			}
		}

	}

	static void preOrder(TNode root) {
		if (root == null)
			return;

		System.out.print(" " + root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
}
