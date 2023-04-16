package Misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedNode {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // 1,4,5],[1,3,4],[2,6
        Node n1 = new Node(1);
        n1.next = new Node(4);
        n1.next.next = new Node(5);
        Node n2 = new Node(1);
        n2.next = new Node(3);
        n2.next.next = new Node(4);
        Node n3 = new Node(2);
        n3.next = new Node(6);

        Node list = mergeKLists(new Node[]{n1, n2, n3});
        while (list != null) {
            System.out.println(list.value);
            list = list.next;
        }
    }

    public static Node mergeKLists(Node[] lists) {
        if (lists.length == 0) return null;

        Queue<Node> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.value));

        for (Node node : lists) {
            if (node == null) continue;
            priorityQueue.add(node);
        }

        Node placeHolderNode = new Node(-1);
        Node initNode = placeHolderNode;

        while (!priorityQueue.isEmpty()) {
            initNode.next = priorityQueue.poll();
            if (initNode.next.next != null) priorityQueue.add(initNode.next.next);
            initNode = initNode.next;
        }

        return placeHolderNode.next;
    }
}
