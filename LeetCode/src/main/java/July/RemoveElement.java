package July;

public class RemoveElement {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);

		display(removeElements(head, 30));
	}

	private static void display(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	public static ListNode removeElements(ListNode head, int val) {
		ListNode result = head;
		if (head == null)
			return null;
		if (head.val == val) {
			result = head.next;
			head = head.next;
		}
		ListNode PrevNode = null;
		while (head != null) {
			if (head.val == val) {
				if (PrevNode == null) {
					result = head.next;
				} else {
					PrevNode.next = head.next;
				}
			} else
				PrevNode = head;
			head = head.next;
		}

		return result;
	}
}
