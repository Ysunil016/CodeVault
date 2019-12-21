package LinkedList;

public class DeleteNodeWithoutLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		Node one = head.next = new Node(20);
		Node two = one.next = new Node(30);
		Node three = two.next = new Node(40);
		Node four = three.next = new Node(50);
		Node five = four.next = new Node(60);
		five.next = new Node(70);
		printLinkedList(head);
		System.out.println();
		deleteNode(two);
		System.out.println();
		printLinkedList(head);
	}

	static void deleteNode(Node node) {
		if (node == null)
			return;

		if (node.next == null) {
			return;
		}

		Node next = node.next;
		Node nextNext = next.next;

		System.out.println(next.data);
		
		node.data = next.data;
		node.next = nextNext;

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
