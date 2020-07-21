package _60Days.LinkedList;

import java.util.Stack;

public class PalindromeCheck {

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
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(head));
	}

	private static boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Stack<Integer> stackS = new Stack<>();
		while (slow != null) {
			stackS.add(slow.val);
			slow = slow.next;
		}

		while (!stackS.isEmpty()) {
			if (stackS.pop() != head.val) {
				return false;
			}
			head = head.next;
		}

		return true;
	}

}
