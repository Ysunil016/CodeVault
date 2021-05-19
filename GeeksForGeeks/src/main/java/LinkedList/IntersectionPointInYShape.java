package LinkedList;

import java.util.Stack;

public class IntersectionPointInYShape {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		Node h1 = new Node(20);
		Node h2 = new Node(30);
		Node h3 = new Node(40);
		Node head2 = new Node(70);
		Node h4 = new Node(50);
		Node h5 = new Node(60);
		head.next = h1;
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		head2.next = h4;

		Node result = findIntersect(head, head2);
		if (result != null)
			System.out.println("Intersect Node = " + result.data);

	}

	static Node findIntersect(Node headA, Node headB) {

		Stack<Node> headOneStack = new Stack<Node>();

		while (headA != null) {
			headOneStack.push(headA);
			headA = headA.next;
		}

		Stack<Node> headTwoStack = new Stack<Node>();

		while (headB != null) {
			headTwoStack.push(headB);
			headB = headB.next;
		}

		Node headOnePop = headOneStack.pop();
		Node headTwoPop = headTwoStack.pop();
		Node intersectNode = null;
		while (headOnePop.equals(headTwoPop)) {
			intersectNode = headOnePop;

			headOnePop = headOneStack.pop();
			headTwoPop = headTwoStack.pop();
		}

		return intersectNode;
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
