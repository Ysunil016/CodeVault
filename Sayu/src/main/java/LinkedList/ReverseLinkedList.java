package LinkedList;

import util.Helper;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Helper.ListNode head = new Helper.ListNode(10);
        head.next = new Helper.ListNode(20);
        head.next.next = new Helper.ListNode(30);
        head.next.next.next = new Helper.ListNode(40);
        head.display();

        Helper.ListNode reversedList = reverseList(head);
        reversedList.display();

        Helper.ListNode reReversedList = reverseListRec(reversedList);
        reReversedList.display();
    }

    private static Helper.ListNode reverseList(Helper.ListNode head) {
        Helper.ListNode prev = null;
        while (head != null) {
            Helper.ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    private static Helper.ListNode reverseListRec(Helper.ListNode head) {
        if (head == null || head.next == null) return head;
        Helper.ListNode lastNode = reverseListRec(head.next);
        // Head at Previous
        head.next.next = head;
        // Remove Connection for Last Node
        head.next = null;
        return lastNode;
    }
}
