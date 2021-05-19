package _60Days.LinkedList;

import java.util.Stack;

public class AddTwoNumbers {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int c) {
			this.val = c;
		}
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(9);
		head1.next = new ListNode(9);
		head1.next.next = new ListNode(9);
//		head1.next.next.next = new ListNode(1);
//		head1.next.next.next.next = new ListNode(1);

		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(8);
//		head2.next.next = new ListNode(2);
//		head2.next.next.next = new ListNode(3);
//		head2.next.next.next.next = new ListNode(8);

		display(getAddition(head1, head2));

	}

	private static void display(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	// Complexity -
	// Time - O(m+n)
	// Space - O(m+n+Max(m,n);

	static ListNode getAddition(ListNode head, ListNode head2) {
		// Getting Sum of Number Digits
		Stack<ListNode> OneStack = new Stack<>(); // Space - m
		Stack<ListNode> TwoStack = new Stack<>(); // Space - n
		Stack<Integer> ResultStack = new Stack<>(); // Space max(m,n)

		// O(m)
		while (head != null) {
			OneStack.add(head);
			head = head.next;
		}
		// O(n)
		while (head2 != null) {
			TwoStack.add(head2);
			head2 = head2.next;
		}

		int carry = 0;
		// O(max(m,n))
		while (!OneStack.isEmpty() && !TwoStack.isEmpty()) {
			int Sum = OneStack.pop().val + TwoStack.pop().val + carry;
			carry = 0;
			if (Sum > 9) {
				ResultStack.add(Sum % 10);
				carry = Sum / 10;
			} else {
				ResultStack.add(Sum);
			}
		}
		// O(m)
		while (!OneStack.isEmpty()) {
			int Sum = OneStack.pop().val + carry;
			carry = 0;
			if (Sum > 9) {
				ResultStack.add(Sum % 10);
				carry = Sum / 10;
			} else
				ResultStack.add(Sum);
		}
		// O(n)
		while (!TwoStack.isEmpty()) {
			int Sum = TwoStack.pop().val + carry;
			carry = 0;
			if (Sum > 9) {
				ResultStack.add(Sum % 10);
				carry = Sum / 10;
			} else
				ResultStack.add(Sum);
		}
		if (carry != 0) {
			ResultStack.add(1);
		}
		ListNode ResultNode = new ListNode(-1);
		ListNode fR = ResultNode;
		// O(max(m,n))
		while (!ResultStack.isEmpty()) {
			ResultNode.next = new ListNode(ResultStack.pop());
			ResultNode = ResultNode.next;
		}
		return fR.next;
	}

}
