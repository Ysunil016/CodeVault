package LinkedList;

public class HasCycle {

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

		System.out.println(HasCycleF(head));
		System.out.println();
		head.next.next.next.next.next.next = head;
		System.out.println(HasCycleF(head));
	}

	private static boolean HasCycleF(Node head) {
		Node StartNode = head;
		if (head == null)
			return false;
		head = head.next;
		while (head != null) {
			if (head.equals(StartNode))
				return true;
			head = head.next;
		}
		return false;
	}
}
