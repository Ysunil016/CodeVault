package LinkedList;

public class RotateDoublyLinkedList {

	static class Node {
		int data;
		Node prev, next;

		public Node(int d) {
			this.data = d;
			prev = null;
			next = null;
		}
	}

	Node rotateP(Node head, int p) {
		Node currentNode = head;
		Node prev = null;
		for (int i = 0; i < p; i++) {
			prev = currentNode;
			currentNode = currentNode.next;
		}
		prev.next = null;
		Node startNode = currentNode;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = head;
		return startNode;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node one = head.next = new Node(2);
		one.prev = head;
		Node two = one.next = new Node(3);
		two.prev = one;
		Node three = two.next = new Node(4);
		three.prev = two;
		Node four = three.next = new Node(5);
		four.prev = three;
		Node five = four.next = new Node(6);
		five.prev = four;
		Node six = five.next = new Node(7);
		six.next = new Node(2);
		six.prev = five;

	}

}
