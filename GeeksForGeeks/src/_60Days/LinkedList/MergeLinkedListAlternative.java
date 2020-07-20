package _60Days.LinkedList;

public class MergeLinkedListAlternative {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		l1.next = new ListNode(7);
		l1.next.next = new ListNode(17);
		l1.next.next.next = new ListNode(13);
		l1.next.next.next.next = new ListNode(11);

		ListNode l2 = new ListNode(12);
		l2.next = new ListNode(10);
		l2.next.next = new ListNode(2);
		l2.next.next.next = new ListNode(4);
		l2.next.next.next.next = new ListNode(6);

		display(mergeTwoList(l1, l2));
	}

	static void display(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
		ListNode fR = l1;

		int counter = 0;
		ListNode PrevNode = null;
		ListNode L1Node = null;

		while (l2 != null && l1 != null) {
			if (counter % 2 == 0) {
				L1Node = l1;
				PrevNode = l1;
				l1 = l1.next;
			} else {
				PrevNode.next = l2;
				PrevNode = l2;
				l2 = l2.next;
				PrevNode.next = l1;
			}
			counter++;
		}
		if (l2 != null) {
			L1Node.next = l2;
			L1Node = L1Node.next;
			L1Node.next = null;
			l2 = l2.next;
		}
		return fR;
	}

}
