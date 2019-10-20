package SinglyLinkedList;

public class BasicOperations {

	public void displayLinkedList(Node head) {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}

	public Node nodeInsertionAtLast(Node head, int data) {
		Node newNode = new Node(data);
		Node currentNode = head;
		while (currentNode.next != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		return head;
	}

}
