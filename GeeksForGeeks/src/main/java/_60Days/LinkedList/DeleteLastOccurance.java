package _60Days.LinkedList;

public class DeleteLastOccurance {
	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(6);

		head = deleteLastOccurance(head, 2);
		display(head);
	}

	private static ListNode deleteLastOccurance(ListNode head, int n) {
		ListNode PrevNode = null;
		ListNode SuccessorNode = null;
		ListNode current = head;
		if (head == null)
			return head;

		while (current.next != null) {
			if (current.next.val == n) {
				PrevNode = current;
				SuccessorNode = current.next.next;
			}
			current = current.next;
		}

		if (PrevNode == null) {
			return null;
		}
		PrevNode.next = SuccessorNode;

		return head;
	}

	private static void display(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

}
