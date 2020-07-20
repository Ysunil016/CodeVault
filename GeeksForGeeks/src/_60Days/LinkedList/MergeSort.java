package _60Days.LinkedList;

public class MergeSort {
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
		head = mergeSort(head);
		display(head);
	}

	private static void display(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	private static ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode middle = getMiddle(head);
		ListNode next2Middle = middle.next;

		middle.next = null;

		ListNode left = mergeSort(head);
		ListNode right = mergeSort(next2Middle);

		ListNode x = sortedList(left, right);
		return x;
	}

	private static ListNode sortedList(ListNode x, ListNode y) {
		ListNode result = null;
		if (x == null)
			return y;
		if (y == null)
			return x;

		if (x.val <= y.val) {
			result = x;
			result.next = sortedList(x.next, y);
		} else {
			result = y;
			result.next = sortedList(x, y.next);
		}
		return result;
	}

	private static ListNode getMiddle(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
