package LinkedList;

public class HasLoop {

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
		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println(HasCycleF(head));
	}

	private static boolean HasCycleF(Node head) {
		Node slow = head;
		Node fast = head;
		if (fast == null)
			return false;
		
		fast = fast.next;
		while (fast.next != null && fast != null) {
			if (slow.equals(fast))
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
}
