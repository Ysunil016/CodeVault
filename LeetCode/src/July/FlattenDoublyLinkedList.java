package July;

import java.util.Stack;

public class FlattenDoublyLinkedList {

	static class Node {
		int val;
		Node next = null;
		Node prev = null;
		Node child = null;

		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		flatten(head);
	}

	public static Node flatten(Node head) {
		if (head == null) {
			return head;
		}
		makeFlatten(head, new Stack<Node>());
		return head;
	}

	private static void makeFlatten(Node head, Stack<Node> store) {
		if (head.next == null) {
			if (head.child != null) {
				head.next = head.child;
				head.child.prev = head;
				head.child = null;
				makeFlatten(head.next, store);
			}
			if (!store.isEmpty()) {
				Node found = store.pop();
				head.next = found;
				found.prev = head;
				makeFlatten(head.next, store);
			}
			return;
		}

		if (head.child != null) {
			store.push(head.next);
			head.next = head.child;
			head.child.prev = head;
			head.child = null;
		}
		makeFlatten(head.next, store);
	}

}
