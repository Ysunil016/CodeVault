package LinkedList;

public class MiddleNodeOfLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = getRandomLinkedList(8);
		System.out.println("Linked List :: ");
		printLinkedList(head);
		System.out.println();
		Node node = middleNode(head);
		System.out.println("Middle Node is : " + node.data);
	}

	static Node middleNode(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		return slowPointer;
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
