package _60Days.LinkedList;

public class RetainNDeleteM {

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
		head.next.next.next.next.next.next.next.next = new ListNode(9);

		retainAndDelete(head, 3, 2);
		display(head);
	}

	private static void display(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	private static void retainAndDelete(ListNode head, int retain, int remove) {
		ListNode prevNode = null;

		int removeCount = 1;
		int counter = 1;

		while (head != null) {
			if (removeCount > remove) {
				counter = 1;
				removeCount = 1;
			}

			if (counter > retain) {
				prevNode.next = head.next;
				removeCount++;
			} else {
				prevNode = head;
				counter++;
			}
			head = head.next;
		}
	}
}
