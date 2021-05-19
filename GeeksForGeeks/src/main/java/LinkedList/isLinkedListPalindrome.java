package LinkedList;

import java.util.Stack;

public class isLinkedListPalindrome {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		Node head = new Node(1);
		Node one = head.next = new Node(2);
		Node two = one.next = new Node(2);
		Node three = two.next = new Node(1);
		Node four = three.next = new Node(2);
		Node five = four.next = new Node(2);
		five.next = new Node(1);

		System.out.println("Linked List is Palindrome :: " + isPalidrome(head));

	}

	static boolean isPalidrome(Node head) {
		Node slower = head;
		Node faster = head;

		while (faster != null && faster.next != null) {
			slower = slower.next;
			faster = faster.next.next;
		}

		Stack<Node> store = new Stack<Node>();
		while (slower != null) {
			store.push(slower);
			slower = slower.next;
		}

		while (!store.isEmpty()) {
			Node popStack = store.pop();
			if (popStack.data != head.data) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

}
