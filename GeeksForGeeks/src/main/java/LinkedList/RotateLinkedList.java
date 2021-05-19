package LinkedList;

public class RotateLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = getRandomLinkedList(10);
		System.out.println("Original Linked List");
		printLinkedList(head);
		System.out.println("\nRotated Linked List");
		Node rotateList = rotateLinkedList(head, 4);
		printLinkedList(rotateList);

	}

	static Node rotateLinkedList(Node head, int k) {
			
		Node currentNode = head;
		Node leftPrev = null;
		Node rightPart = head;

		for (int i = 0; i < k; i++) {
			if (currentNode == null)
				return null;
			leftPrev = currentNode;
			currentNode = currentNode.next;
		}
		leftPrev.next = null;
		head = currentNode;

		if(currentNode==null) return head;
		
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = rightPart;

		return head;
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
