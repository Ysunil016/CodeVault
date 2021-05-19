package _60Days.LinkedList;

public class CompareString {

	static class ListNode {
		char c;
		ListNode next;

		public ListNode(char c) {
			this.c = c;
		}
	}

	public static void main(String[] args) {
		ListNode sOne = new ListNode('g');
		sOne.next = new ListNode('e');
		sOne.next.next = new ListNode('e');
		sOne.next.next.next = new ListNode('k');
		sOne.next.next.next.next = new ListNode('s');
//		sOne.next.next.next.next.next = new ListNode('a');

		ListNode tOne = new ListNode('g');
		tOne.next = new ListNode('e');
		tOne.next.next = new ListNode('e');
		tOne.next.next.next = new ListNode('k');
		tOne.next.next.next.next = new ListNode('s');
//		tOne.next.next.next.next.next = new ListNode('b');

		System.out.println(compareString(sOne, tOne));
	}

	static int compareString(ListNode strOne, ListNode strTwo) {
		if ((strOne == null && strTwo != null) || (strOne != null && strTwo == null)) {
			if (strOne != null) {
				return 1;
			} else {
				return -1;
			}
		}
		if (strOne == null && strTwo == null) {
			return 0;
		}
		if (strOne.c != strTwo.c) {
			if (strOne.c > strTwo.c) {
				return 1;
			} else {
				return -1;
			}
		}
		return compareString(strOne.next, strTwo.next);
	}

}
