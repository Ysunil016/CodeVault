package Ignite;

public class DeleteNodeWithoutHeader {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		// Making Linked List of Elements as 10->12->32->11->44->98->56
		Node head = new Node(10);
		Node _one = head.next = new Node(12);
		Node _two = _one.next = new Node(32);
		Node _three = _two.next = new Node(11);
		Node _four = _three.next = new Node(44);
		Node _five = _four.next = new Node(98);
		_five.next = new Node(56);

		// Traverse Linked List As Insertion Completes;
		displayLinkedList(head);
		System.out.println();

		// Removing _Three From the LinkedList .. Without Using Head Pointer of the
		// Linked List
		removeNode(_three);
		System.out.println();

		// Traverse Linked List After Removal of Node
		displayLinkedList(head);

	}

	// Removing _Three From the LinkedList .. Without Using Head Pointer of the
	static void removeNode(Node node) {

		// If Node is Null, or Node if Only Single Node, then there is No Mean Possible
		// to Delete the Node.. We have to Return from the Function
		if (node == null || node.next == null)
			return;
		Node prev = null;

		// Copying the Data of Next Nodes to the Previous Node.. So that Data Inside the
		// Node will be Replaced by the Next Node
		while (node.next != null) {
			node.data = node.next.data;
			prev = node;
			node = node.next;
		}

		// Removing Last Node Reference as Node has Been Shifted One Step Back..
		if (prev != null)
			prev.next = null;
	}

	// Printing all the Node in the Linked List
	static void displayLinkedList(Node head) {
		while (head != null) {
			System.out.print("-> " + head.data);
			head = head.next;
		}
	}

}
