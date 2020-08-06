package LinkedList;

public class RemoveLoopFromLinkedList {

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
		head.next.next.next.next.next.next = head.next.next.next;
		HasCycleRemove(head);
		display(head);
	}

	private static void display(Node head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	private static void HasCycleRemove(Node head) {
		Node slow = head;
		Node fast = head;
		if (fast == null)
			return;

		boolean hasLoop = false;
		while (fast.next != null && fast != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow.equals(fast)) {
				hasLoop = true;
				break;
			}
		}
		if (!hasLoop)
			return;

		slow = head;
		Node prevNode = null;
		while (slow != fast) {
			prevNode = fast;
			slow = slow.next;
			fast = fast.next;
		}
		if (prevNode != null)
			prevNode.next = null;

	}

}
