package LinkedList;

public class InsertionInSortedLinkedList {

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		head = insertInSorted(head, new Node(5));
		head = insertInSorted(head, new Node(39));
		head = insertInSorted(head, new Node(65));
		disaplay(head);
	}

	static void disaplay(Node head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	static Node insertInSorted(Node root, Node node) {
		Node head = root;
		if (head == null)
			return head;

		Node prevNode = null;
		while (head != null && head.val < node.val) {
			prevNode = head;
			head = head.next;
		}

		if (prevNode == null) {
			node.next = head;
			return node;
		}

		prevNode.next = node;
		node.next = head;

		return root;
	}

}
