package October;

import java.util.List;

public class RotateRightList {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        display(head);
        System.out.println();
        display(rotateRight(head,4));

    }
    private static void display(ListNode n){
        while(n!=null)
        {
            System.out.print(n.val+" ");
            n = n.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        if(k==0)
            return head;

        int counter = 0;
        ListNode realHead = head;
        ListNode interNode = head;
        ListNode prevNode = head;

        while(head!=null){
            counter++;
            head = head.next;
        }
        head = realHead;
        k %= counter;

        counter = 0;
        while(head!=null){
            if(counter >= k){
                prevNode = interNode;
                interNode = interNode.next;
            }
            counter++;
            head = head.next;
        }
        if(prevNode==null)
            return realHead;

        if(prevNode!=null)
            prevNode.next = null;


        prevNode = interNode;

        if(interNode==null){
            return realHead;
        }

        while(interNode.next!=null){
            interNode = interNode.next;
        }
        interNode.next = realHead;

        return prevNode;
    }

}
