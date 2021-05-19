package _60Days.LinkedList;

public class PickRandomNode {

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

		System.out.println(pickRandomNode(head).val);
	}

	private static ListNode pickRandomNode(ListNode head) {
		ListNode pHead = head;
		int nodeCount = 0;
		while (head != null) {
			nodeCount++;
			head = head.next;
		}
		// Finding Random Probability
		int probability = (int) (Math.random() * nodeCount);
		for (int i = 0; i < probability; i++) {
			pHead = pHead.next;
		}

		return pHead;
	}

}
