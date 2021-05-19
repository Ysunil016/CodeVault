package _60Days.LinkedList;

public class DetectAndRemoveLoop {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode headOne = new ListNode(10);
		headOne.next = new ListNode(15);
		headOne.next.next = new ListNode(4);
		headOne.next.next.next = new ListNode(20);
		headOne.next.next.next.next = new ListNode(40);
		headOne.next.next.next.next.next = new ListNode(70);
		headOne.next.next.next.next.next.next = new ListNode(80);
		headOne.next.next.next.next.next.next.next = headOne.next.next;

		removeLoop(headOne);
		display(headOne);
	}

	private static void display(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	private static void removeLoop(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast == null || fast.next == null) {
			return;
		}

		ListNode One = head;
		ListNode Two = null;
		while (true) {
			Two = slow;
			while (Two.next != slow && Two.next != One) {
				Two = Two.next;
			}
			if (Two.next == One) {
				break;
			}
			One = One.next;
		}
		Two.next = null;
	}

}
