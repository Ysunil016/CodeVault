package LinkedList;

public class ReverseEven {

	static class Node {
		int data;
		Node next = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(2);
		Node one = root.next = new Node(18);
		Node two = one.next = new Node(24);
		Node three = two.next = new Node(3);
		Node four = three.next = new Node(5);
		Node five = four.next = new Node(14);
		Node six = five.next = new Node(16);
		Node seven = six.next = new Node(6);
		seven.next = new Node(23);

		printLinkedList(root);
		System.out.println();
		root = reverseList(root);
		System.out.println();
		printLinkedList(root);

	}

	static Node reverseList(Node head) {
		Node node = head;
		Node prev = null;
		Node next = null;
		while (node.next != null) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		node.next = prev;

		return node;
	}

	static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(" -> " + head.data);
			head = head.next;
		}
	}

}
