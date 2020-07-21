package _60Days.LinkedList;

public class Add1LinkedList {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int c) {
			this.val = c;
		}
	}

	public static void main(String[] args) {
		ListNode headOne = new ListNode(9);
		headOne.next = new ListNode(9);
		headOne.next.next = new ListNode(9);
		headOne.next.next.next = new ListNode(9);
		headOne.next.next.next.next = new ListNode(9);
		headOne.next.next.next.next.next = new ListNode(9);
		headOne.next.next.next.next.next.next = new ListNode(9);

		headOne = reverseLinkedList(headOne);
		addOne(headOne);
		headOne = reverseLinkedList(headOne);
		display(headOne);

	}

	static void display(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	private static void addOne(ListNode head) {
		int carry = 1;
		ListNode PrevNode = null;
		while (head != null) {
			int addVal = head.val + carry;
			if (addVal > 9) {
				head.val = addVal % 10;
				carry = addVal / 10;
			} else {
				head.val = addVal;
				carry = 0;
			}
			PrevNode = head;
			head = head.next;
		}
		if (carry != 0 && PrevNode != null) {
			PrevNode.next = new ListNode(1);
		}
	}

	private static ListNode reverseLinkedList(ListNode head) {
		if (head == null)
			return head;

		ListNode PrevNode = null;
		ListNode SucNode = null;
		while (head != null) {
			SucNode = head.next;
			head.next = PrevNode;
			PrevNode = head;
			head = SucNode;
		}
		return PrevNode;
	}

}
