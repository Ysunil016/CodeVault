package _60Days.LinkedList;

public class NthNodeFromEnd {

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
		head.next.next.next.next.next.next.next = new ListNode(8);

		int N = 5;
		System.out.println(lastNthElement(head, N).val);
	}

	private static ListNode lastNthElement(ListNode head, int n) {
		ListNode slow = head;
		ListNode fast = head;

		int counter = 0;
		while (fast != null) {
			if (counter >= n)
				slow = slow.next;
			counter++;
			fast = fast.next;
		}
		return slow;
	}

}
