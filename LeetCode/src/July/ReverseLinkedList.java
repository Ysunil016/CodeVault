package July;

public class ReverseLinkedList {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	static ListNode head;
	static ListNode headStart;

	public static void main(String[] args) {
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode resultNode = new ListNode(-1);
		reverseList(head, 5, resultNode);
		// Result Display
		display(resultNode.next);
	}

	static void display(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	static void reverseList(ListNode head, int K, ListNode result) {
		if (head == null) {
			return;
		}

		int counter = 0;
		ListNode pNode = null;
		ListNode sNode = null;

		while (counter < K && head != null) {

			sNode = head.next;
			head.next = pNode;
			pNode = head;
			head = sNode;

			counter++;
		}
		result.next = pNode;
		while (result.next != null) {
			result = result.next;
		}
		reverseList(sNode, K, result);
	}

}
