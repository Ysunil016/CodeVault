package LinkedList;

public class AddTwoNumber {

    public static void main(String[] args) {

        Node l1 = new Node(9);
        l1.next = new Node(9);
        l1.next.next = new Node(9);
        l1.next.next.next = new Node(9);
        l1.next.next.next.next = new Node(9);
        l1.next.next.next.next.next = new Node(9);

        Node l2 = new Node(9);
        l2.next = new Node(9);
        l2.next.next = new Node(9);
        l2.next.next.next = new Node(9);

//        Node l1 = new Node(2);
//        l1.next = new Node(4);
//        l1.next.next = new Node(3);
//
//        Node l2 = new Node(5);
//        l2.next = new Node(6);
//        l2.next.next = new Node(4);

        Node result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }

    }

    private static Node addTwoNumbers(Node l1, Node l2) {
        int l1Length = lengthOfLinkedList(l1);
        int l2Length = lengthOfLinkedList(l2);
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Node baseNode = l1Length > l2Length ? l1 : l2;
        int carry = 0;
        Node resultantNode = baseNode;
        Node prev = null;

        while (l1 != null && l2 != null) {
            int currentValue = l1.value + l2.value + carry;
            baseNode.value = currentValue % 10;
            if (currentValue > 9)
                carry = currentValue / 10;
            else
                carry = 0;
            l1 = l1.next;
            l2 = l2.next;
            prev = baseNode;
            baseNode = baseNode.next;
        }

        while (l1 != null) {
            int currentValue = l1.value + carry;
            baseNode.value = currentValue % 10;
            if (currentValue > 9)
                carry = currentValue / 10;
            else
                carry = 0;
            l1 = l1.next;
            prev = baseNode;
            baseNode = baseNode.next;
        }
        while (l2 != null) {
            int currentValue = l2.value + carry;
            baseNode.value = currentValue % 10;
            if (currentValue > 9)
                carry = currentValue / 10;
            else
                carry = 0;
            l2 = l2.next;
            prev = baseNode;
            baseNode = baseNode.next;
        }

        if (carry != 0)
            prev.next = new Node(carry);

        return resultantNode;
    }

    private static int lengthOfLinkedList(Node node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
