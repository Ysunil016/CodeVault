package October;

public class SortList {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    ListNode mergeSort(ListNode h)
    {
        if (h == null || h.next == null) {
            return h;
        }
        ListNode middle = getMiddle(h);
        ListNode nextofmiddle = middle.next;
        middle.next = null;
        ListNode left = mergeSort(h);
        ListNode right = mergeSort(nextofmiddle);
        ListNode sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
    private ListNode getMiddle(ListNode head){
            if (head == null)
                return head;
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
    }

    private ListNode sortedMerge(ListNode a, ListNode b)
    {
        ListNode result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }


}
