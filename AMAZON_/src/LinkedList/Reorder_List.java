package LinkedList;

import java.util.Stack;

public class Reorder_List {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
//		head.next.next = new Node(3);
//		head.next.next.next = new Node(4);
//		head.next.next.next.next = new Node(5);

		displayLL(head);
		System.out.println();
		Node head2 = reorderlist(head);
		System.out.println();
		displayLL(head2);
	}

	static Node reorderlist(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Stack<Node> sStore = new Stack<Node>();
		while (slow != null) {
			sStore.push(slow);
			slow = slow.next;
		}

		Node startNode = head;
		Node endNode = null;

		while (!sStore.isEmpty()) {
			endNode = sStore.pop();
			
			Node nextNode = startNode.next;
			startNode.next = endNode;
			endNode.next = nextNode;
			startNode = nextNode;
		}

		if (endNode != null)
			endNode.next = null;

		return head;
	}

	static void displayLL(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

}
