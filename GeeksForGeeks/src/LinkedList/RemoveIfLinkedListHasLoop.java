package LinkedList;

public class RemoveIfLinkedListHasLoop {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		Node h1 = head.next = new Node(15);
		Node h2 = h1.next = new Node(30);
		Node h3 = h2.next = new Node(45);
		h3.next = h2;
//		h4.next = h3;

		Node loopFoundNode = getLoopExist(head);
		if (loopFoundNode != null) {
			int totalCount = countTheNumberOfNodeInLoop(loopFoundNode);
			removeLoop(head, totalCount);
		}

		printLinkedList(head);
	}

	static void removeLoop(Node head, int counter) {

		if (head == null)
			return;

		Node currentNode = head;
		Node first = currentNode;
		Node second = head;

		for (int i = 0; i < counter; i++) {
			second = second.next;
		}

		Node prev = null;
		while (second != first) {
			prev = second;
			second = second.next;
			first = first.next;
		}
		prev.next = null;

	}

	static Node getLoopExist(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;

		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer.equals(fastPointer)) {
				return slowPointer;
			}

		}
		return null;

	}

	static int countTheNumberOfNodeInLoop(Node head) {
		int count = 0;
	
		if (head.next == null)
			return 0;
		
		
		Node currentNode = head;
		while (!currentNode.next.equals(head)) {
			currentNode = currentNode.next;
			count++;
		}

		return ++count;
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
