package Ignite;

public class DeleteKeysFromLinkedList {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(40);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(20);

		displayAllNodes(head);
		System.out.println("\n**********");
		head = deleteAllOccurances(head, 20);
		System.out.println("**********");
		displayAllNodes(head);
	}

	static Node deleteAllOccurances(Node head, int key) {
		if (head == null)
			return null;
		// Keeping Head for Safe
		Node actualHead = head;
		Node prev = null;
		// Checking if Head is Data...
		if (head.data == key) {
			if (head.next != null) {
				actualHead = head.next;
				head = head.next;
			} else
				return head.next;
		}
		// Traversing Each Node for Checking.
		while (head.next != null) {
			if (head.data == key)
				prev.next = head.next;
			prev = head;
			head = head.next;
		}
		// If Still Last Node is the Key
		if (prev.next != null) {
			if (prev.next.data == key)
				prev.next = null;
		}

		return actualHead;
	}

	static void displayAllNodes(Node head) {
		while (head != null) {
			System.out.print("-> " + head.data);
			head = head.next;
		}
	}

}
