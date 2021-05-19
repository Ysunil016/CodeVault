package _60Days.LinkedList;

import java.util.Stack;

public class SumZeroLinkedList {
	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(6);
		head.next = new ListNode(6);
		head.next.next = new ListNode(8);
		head.next.next.next = new ListNode(-8);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(-5);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next = new ListNode(-8);
		head.next.next.next.next.next.next.next = new ListNode(12);
		display(getZeroStack(head));

	}

	private static void display(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	private static ListNode getZeroStack(ListNode head) {
		// Stack Store in Details
		Stack<ListNode> stackStore = new Stack<>();
		ListNode node = head;
		while (node != null) {
			if (node.val < 0) {
				int sum = node.val;
				while (!stackStore.isEmpty()) {
					ListNode temp = stackStore.pop();
					sum += temp.val;
					temp = null;
					if (sum == 0) {
						stackStore.peek().next = node.next;
						break;
					}
				}
			} else {
				stackStore.push(node);
			}
			node = node.next;
		}

		return head;
	}

}
