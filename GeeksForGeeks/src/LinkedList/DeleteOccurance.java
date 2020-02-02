package LinkedList;

public class DeleteOccurance {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node hOne = head.next = new Node(1);
		Node hTwo = hOne.next = new Node(5);
		Node hThree = hTwo.next = new Node(9);
		Node hFour = hThree.next = new Node(2);
		hFour.next = new Node(1);
		head = deleteAllOccurances(head, 1);
		printNode(head);

	}

	static Node deleteAllOccurances(Node head, int x) {
		Node node = head;
		Node prev = null;
		while (node.next != null) {

			if (node.data == x && prev != null) {
				System.out.println("AT NODE " + node.data);
				prev.next = node.next;
				node = prev;

			} else if (node.data == x && prev == null) {
				head = node.next;
				prev = null;
				node = node.next;
			} else {
				prev = node;
				node = node.next;
			}
		}

		if (node.data == x && prev != null) {
			prev.next = node.next;
			node = prev;
		}

		return head;
	}

	static void printNode(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}
