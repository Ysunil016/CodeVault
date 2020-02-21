package LinkedList;

public class DeleteMiddleNode {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		Delete(head);
		printList(head);
	}

	static Node Delete(Node head) {
		Node slow = head;
		Node fast = head;
		Node prev = null;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (prev != null)
			prev.next = slow.next;

		return head;
	}

	static void printList(Node head) {
		while (head != null) {
			System.out.print("-> " + head.data + " ");
			head = head.next;
		}
	}
}
