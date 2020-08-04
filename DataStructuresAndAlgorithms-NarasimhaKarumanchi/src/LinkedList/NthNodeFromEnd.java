package LinkedList;

public class NthNodeFromEnd {

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);

		Node finalNode = NthNode(head, 3);
		if (finalNode != null)
			System.out.println(finalNode.val);

	}

	private static Node NthNode(Node head, int pos) {
		Node slow = head;
		Node fast = head;
		int counter = 0;
		while (fast != null) {
			if (counter >= pos) {
				slow = slow.next;
			}
			fast = fast.next;
			counter++;
		}
		return slow;
	}

}
