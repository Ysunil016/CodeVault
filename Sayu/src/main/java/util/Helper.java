package util;

import LinkedList.ReverseLinkedList;

public class Helper {
    public static void print(int[] inArray) {
        for (int value : inArray) System.out.print(" " + value);
        System.out.println();
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void display() {
            System.out.print(this.val + " ");
            if (this.next != null) this.next.display();
            else System.out.println();
        }
    }

}
