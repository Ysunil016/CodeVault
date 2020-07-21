package _60Days.LinkedList;

public class FindMiddleElement {

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

		System.out.println("Middle Element is :: " + middleElement(headOne).val);
	}

	static ListNode middleElement(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
