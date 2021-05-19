package _60Days.LinkedList;

public class RemoveDuplicateSortedList {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(7);

		removeDuplicates(head);
		display(head);
	}

	private static void removeDuplicates(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode PrevNode = head;
		head = head.next;
		while (head != null) {
			if (PrevNode.val == head.val) {
				PrevNode.next = head.next;
			} else {
				PrevNode = head;
			}
			head = head.next;

		}

	}

	private static void display(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

}
