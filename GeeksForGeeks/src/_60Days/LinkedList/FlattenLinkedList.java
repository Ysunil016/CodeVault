package _60Days.LinkedList;

public class FlattenLinkedList {

	static class ListNode {
		int val;
		ListNode down;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode headOne = new ListNode(5);
		headOne.down = new ListNode(7);
		headOne.down.down = new ListNode(8);
		headOne.down.down.down = new ListNode(30);
		headOne.next = new ListNode(10);
		headOne.next.down = new ListNode(20);
		headOne.next.next = new ListNode(19);
		headOne.next.next.down = new ListNode(22);
		headOne.next.next.down.down = new ListNode(50);
		headOne.next.next.next = new ListNode(28);
		headOne.next.next.next.down = new ListNode(35);
		headOne.next.next.next.down.down = new ListNode(40);
		headOne.next.next.next.down.down.down = new ListNode(45);
		flattenLinkedList(headOne);
		display(headOne);
	}

	private static void flattenLinkedList(ListNode head) {
		if (head == null)
			return;
		while (head != null) {
			ListNode nextNode = head.next;
			ListNode downNode = head.down;
			ListNode prevNode = null;
			while (downNode != null) {
				head.next = downNode;
				head.down = null;
				prevNode = downNode;
				downNode = downNode.down;
				head = head.next;
			}
			if (prevNode != null) {
				prevNode.next = nextNode;
			}
			head = nextNode;
		}
	}

	private static void display(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

}
