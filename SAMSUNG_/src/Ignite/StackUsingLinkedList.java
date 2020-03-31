package Ignite;

public class StackUsingLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static Node LinkedListHead;

	public static void main(String[] args) {
		pushOperation(10);
		pushOperation(20);
		pushOperation(30);
		pushOperation(40);
		pushOperation(50);
		popOperation();
		popOperation();
		popOperation();
		pushOperation(60);
		pushOperation(70);

		printLinkedList(LinkedListHead);

	}

	// Pushing Element to Linked List at the End of Linked List as Stack
	static void pushOperation(int data) {
		if (LinkedListHead == null)
			LinkedListHead = new Node(data);
		else {
			Node tNode = LinkedListHead;
			while (tNode.next != null) {
				tNode = tNode.next;
			}
			tNode.next = new Node(data);
		}
	}

	// Popping Element from Linked List from the End of Linked List as Stack
	static void popOperation() {
		Node tNode = LinkedListHead;
		Node prevNode = null;
		while (tNode.next != null) {
			prevNode = tNode;
			tNode = tNode.next;
		}
		if (prevNode != null) {
			prevNode.next = null;
		}
	}

	// Printing List of Elements in a Linked List
	static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(" -> " + head.data);
			head = head.next;
		}
	}

}
