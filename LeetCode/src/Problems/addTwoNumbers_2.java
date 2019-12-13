package Problems;

public class addTwoNumbers_2 {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

		ListNode head1 = new ListNode(9);
		ListNode head12 = head1.next = new ListNode(8);
		head12.next = new ListNode(3);

		ListNode head2 = new ListNode(1);
		ListNode head22 = head2.next = new ListNode(6);
		head22.next = new ListNode(4);

		ListNode result = addTwoNumbers(head1, head2);
		printLinkedList(result);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(-1);
		ListNode currentNode = result;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val;
			sum += carry;
			carry = 0;
			if (sum >= 10) {
				carry = sum / 10;
				currentNode.next = new ListNode(sum % 10);
			} else {
				currentNode.next = new ListNode(sum);
			}
			currentNode = currentNode.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		if (l1 != null) {
			while (l1 != null) {
				int sum = l1.val + carry;
				carry = 0;
				if (sum >= 10) {
					carry = sum / 10;
					currentNode.next = new ListNode(sum % 10);
				} else {
					currentNode.next = new ListNode(sum);
				}
				l1 = l1.next;
				currentNode = currentNode.next;
			}
		}
		if (l2 != null) {
			while (l2 != null) {
				int sum = l2.val + carry;
				carry = 0;
				if (sum >= 10) {
					carry = sum / 10;
					currentNode.next = new ListNode(sum % 10);
				} else {
					currentNode.next = new ListNode(sum);
				}
				l2 = l2.next;
				currentNode = currentNode.next;
			}
		}

		if (carry != 0) {
			currentNode.next = new ListNode(carry);
		}

		return result.next;
	}

	public static void printLinkedList(ListNode result) {
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
