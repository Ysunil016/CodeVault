package LinkedList;

public class DetectIfLinkedListHasLoop {

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
		h3.next = new Node(60);
//		h4.next = h3;
		System.out.println(isLoopExist(head));
	}

	static boolean isLoopExist(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;

		while (fastPointer != null && fastPointer.next!=null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer.equals(fastPointer))
				return true;

		}
		return false;

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
