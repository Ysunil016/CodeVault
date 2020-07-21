package _60Days.LinkedList;

public class RotateLinkedList {
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

		head = rotateLinkedList(head, 4);
		display(head);
	}

	private static void display(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	private static ListNode rotateLinkedList(ListNode head, int K) {
		ListNode Current = head;
		ListNode Prev = null;
		int Counter = 0;
		while (Current.next != null) {
			if (Counter < K) {
				Prev = Current;
			}
			Counter++;
			Current = Current.next;
		}
		ListNode resultNode = Prev.next;
		Prev.next = null;
		Current.next = head;
		return resultNode;
	}

}
