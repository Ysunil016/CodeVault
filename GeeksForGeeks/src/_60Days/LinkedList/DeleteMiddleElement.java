package _60Days.LinkedList;

public class DeleteMiddleElement {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);

		display(head);
		System.out.println();
		deleteMiddleElement(head);
		display(head);
	}

	private static void deleteMiddleElement(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode PrevNode = head;
		while (fast != null && fast.next != null) {
			PrevNode = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		PrevNode.next = slow.next;
	}

	private static void display(ListNode node) {
		while (node != null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
	}

}
