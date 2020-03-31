package Ignite;

public class ReverseALinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(20);
		head.next = new Node(40);
		head.next.next = new Node(60);
		head.next.next.next = new Node(80);

		displayList(head);
		System.out.println();
		Node revNode = reverseLinkedList(head);
		displayList(revNode);
	}

	// Function that reverses the Linked List.
	static Node reverseLinkedList(Node head) {
		Node prev = null;
		Node next = null;
		// Traversing for
		while (head.next != null) {
			// Placing Head of Next in Next, Since this Will Be Lost in Next Step
			next = head.next;
			// Redirecting Current Node's Next to Previous
			head.next = prev;
			// Marking the Current Node as PrevNode, that will cater for Upcoming nodes.
			prev = head;
			// Iteration for Next Node.
			head = next;
		}
		// Last Node Still Left to be Allocated
		head.next = prev;
		return head;
	}

	static void displayList(Node head) {
		while (head != null) {
			System.out.print("-> " + head.data);
			head = head.next;
		}
	}

}
