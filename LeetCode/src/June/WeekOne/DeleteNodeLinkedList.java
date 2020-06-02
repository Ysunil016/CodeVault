package June.WeekOne;

public class DeleteNodeLinkedList {

	static class ListNode {
		int val;
		ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(10);
		node.next = new ListNode(20);
		node.next.next = new ListNode(30);
		ListNode three = node.next.next.next = new ListNode(40);
		node.next.next.next.next = new ListNode(50);

		deleteNode(three);
	}

	public static void deleteNode(ListNode node) {
		ListNode prev = null;
		while (node.next != null) {
			node.val = node.next.val;
			prev = node;
			node = node.next;
		}
		prev.next = null;
	}
}
