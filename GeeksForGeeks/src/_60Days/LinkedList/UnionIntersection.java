package _60Days.LinkedList;

import java.util.HashSet;

public class UnionIntersection {

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

		ListNode headTwo = new ListNode(8);
		headTwo.next = new ListNode(4);
		headTwo.next.next = new ListNode(2);
		headTwo.next.next.next = new ListNode(10);

		System.out.println("Union");
		display(findUnion(headOne, headTwo));
		System.out.println("\nIntersection");
		display(findIntersection(headOne, headTwo));

	}

	private static void display(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	private static ListNode findUnion(ListNode One, ListNode Two) {
		HashSet<Integer> unionSet = new HashSet<>();
		ListNode resultList = new ListNode(-1);
		ListNode fR = resultList;
		while (One != null) {
			unionSet.add(One.val);
			One = One.next;
		}
		while (Two != null) {
			unionSet.add(Two.val);
			Two = Two.next;
		}
		for (int x : unionSet) {
			resultList.next = new ListNode(x);
			resultList = resultList.next;
		}

		return fR.next;
	}

	private static ListNode findIntersection(ListNode One, ListNode Two) {
		HashSet<Integer> unionSet = new HashSet<>();
		HashSet<Integer> hashResult = new HashSet<>();

		ListNode resultList = new ListNode(-1);
		ListNode fR = resultList;
		while (One != null) {
			unionSet.add(One.val);
			One = One.next;
		}
		while (Two != null) {
			if (unionSet.contains(Two.val)) {
				hashResult.add(Two.val);
			}
			Two = Two.next;
		}
		for (int x : hashResult) {
			resultList.next = new ListNode(x);
			resultList = resultList.next;
		}

		return fR.next;

	}

}
