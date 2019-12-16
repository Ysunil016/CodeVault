package LinkedList;

public class NthNodeFromEnd {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = getRandomLinkedList(9);
		System.out.println("Linked List :: ");
		printLinkedList(head);
		System.out.println();
		int index = 4;
		Node node = nthNode(head, index);
		if (node != null)
			System.out.println("Node at " + index + " from Last is : " + node.data);
	}

	static Node nthNode(Node head, int index) {
		Node slowPointer = head;
		Node fastPointer = head;
		int count = 0;
		while (fastPointer != null) {
			if (count >= index)
				slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
			count++;
		}
		if (count < index) {
			return null;
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
