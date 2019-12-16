package LinkedList;

public class ReverseLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = getRandomLinkedList(10);
		System.out.println("Linked List :: ");
		printLinkedList(head);
		System.out.println();
		System.out.println("Reversed Linked List is ::");
		Node revLinkedList = reverseLinkedList(head);
		printLinkedList(revLinkedList);
	}

	static Node reverseLinkedList(Node head) {
		Node currentNode = head;
		Node prev = null;
		Node next = null;

		while (currentNode.next != null) {
			next = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = next;
		}
		currentNode.next = prev;
		prev = currentNode;

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
