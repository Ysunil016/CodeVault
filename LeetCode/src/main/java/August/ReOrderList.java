package August;

import java.util.Stack;

public class ReOrderList {

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
		head.next.next.next.next.next = new ListNode(60);
//		head.next.next.next.next.next.next = new ListNode(70);

		reorderList(head);
		display(head);
	}

	static void display(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static void reorderList(ListNode head) {
		if (head == null)
			return;

		Stack<ListNode> stack = new Stack<>();
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode prevNode = null;
		while (slow != null) {
			stack.add(slow);
			if (prevNode != null) {
				prevNode.next = null;
			}
			prevNode = slow;
			slow = slow.next;

		}
		ListNode nextNode = head.next;

		while (!stack.isEmpty() && nextNode != null) {
			head.next = stack.pop();
			head = head.next;
			head.next = nextNode;
			head = head.next;
			nextNode = nextNode.next;
		}
		if (nextNode != null)
			nextNode.next = null;

	}

}
