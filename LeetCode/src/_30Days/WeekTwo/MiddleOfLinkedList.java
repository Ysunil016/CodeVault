package _30Days.WeekTwo;

public class MiddleOfLinkedList {

	static class ListNode {
		int data;
		ListNode next = null;

		public ListNode(int data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {
		
	}

	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
