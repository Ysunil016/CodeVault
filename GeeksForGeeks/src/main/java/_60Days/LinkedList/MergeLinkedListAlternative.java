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

		ListNode One_Current = l1;
		ListNode Two_Current = l2;

		ListNode One_Next, Two_Next;

		while (One_Current != null && Two_Current != null) {
			One_Next = One_Current.next;
			Two_Next = Two_Current.next;

			One_Current.next = Two_Current;
			Two_Current.next = One_Next;

			One_Current = One_Next;
			Two_Current = Two_Next;

		}
		return l1;
	}

}
