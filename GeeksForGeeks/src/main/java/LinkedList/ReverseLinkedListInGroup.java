package LinkedList;

public class ReverseLinkedListInGroup {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = getRandomLinkedList(10);
		System.out.println("Original List");
		printLinkedList(head);
		System.out.println();
		System.out.println("ReversedLinkedList");
		Node revList = reverseListInGroup(head, 2);
		printLinkedList(revList);
	}

	static Node reverseListInGroup(Node head, int k) {
		if (head == null)
			return null;

		Node current = head;

		Node next = null;
		int count = 0;
		Node prev = null;

		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (next != null)
			head.next = reverseListInGroup(next, k);

		return prev;
	}

	static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print("-> " + head.data);
			head = head.next;
		}
	}

	static Node getRandomLinkedList(int counter) {
		Node head = new Node(69);
		Node currentNode = head;
		for (int i = 0; i < counter; i++) {
			currentNode.next = new Node((int) (Math.random() * 100));
			currentNode = currentNode.next;
		}
		return head;
	}

}
