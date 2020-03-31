package Working;

public class Merge2SortedLinkedList {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node headA = new Node(10);
		headA.next = new Node(20);
		headA.next.next = new Node(30);
		headA.next.next.next = new Node(40);
		headA.next.next.next.next = new Node(50);

		Node headB = new Node(5);
		headB.next = new Node(15);
		headB.next.next = new Node(30);
		headB.next.next.next = new Node(45);
		headB.next.next.next.next = new Node(60);

		System.out.println("\nA Linked List\n");
		displayLinkedList(headA);
		System.out.println("\nB Linked List\n");
		displayLinkedList(headB);
		System.out.println();
		System.out.println("Merging");
		System.out.println();

	}

	static void mergeLinkedList(Node A, Node B) {
		Node refNode = A;
		while (A.next != null && B.next != null) {
			if (A.data < B.data) {

				A = A.next;
			} else {

				B = B.next;
			}
		}

	}

	static void displayLinkedList(Node head) {
		while (head != null) {
			System.out.print("-> " + head.data);
			head = head.next;
		}
	}

}
