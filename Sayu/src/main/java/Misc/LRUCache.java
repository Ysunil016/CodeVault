package Misc;

import java.util.*;

class LRUCache {
    public static void main(String[] args) {
        Cache lru = new Cache(3);
//
//        SET 1 2 SET 2 3 SET 1 5
//        SET 4 5 SET 6 7 GET 4 SET 1 2 GET 3
//        lru.put(1, 2);
//        lru.put(2, 3);
//        lru.put(1, 5);
//        lru.put(4, 5);
//        lru.put(6, 7);
//        System.out.println(lru.get(4));
//        lru.put(1, 2);
//        System.out.println(lru.get(3));


//        System.out.println(lru.get(2));
//        System.out.println(lru.keyValue);
//        lru.put(2, 6);
//        System.out.println(lru.keyValue);
//        System.out.println(lru.get(1));
//        System.out.println(lru.keyValue);
//        lru.put(1, 5);
//        System.out.println(lru.keyValue);
//        lru.put(1, 2);
//        System.out.println(lru.keyValue);
//        System.out.println(lru.get(1));
//        System.out.println(lru.keyValue);
//        System.out.println(lru.get(2));
//        System.out.println(lru.keyValue);

//        [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]

//        lru.put(2, 1);
//        lru.put(1, 1);
//        lru.put(2, 3);
//        lru.put(4, 1);
//        System.out.println(lru.get(1));
//        System.out.println(lru.get(2));

// [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
        lru.put(1, 1);
//         lru.head.display();

        lru.put(2, 2);
//         lru.head.display();

        lru.put(3, 3);
//         lru.head.display();

        lru.put(4, 4);
//         lru.head.display();

        System.out.println(lru.get(4));
//         lru.head.display();

        System.out.println(lru.get(3));
//         lru.head.display();

        System.out.println(lru.get(2));
// //         lru.head.display();

        System.out.println(lru.get(1));
//         lru.head.display();

        lru.put(5, 5);
//         lru.head.display();

        System.out.println(lru.get(1));
//         lru.head.display();

        System.out.println(lru.get(2));
//         lru.head.display();

        System.out.println(lru.get(3));
//         lru.head.display();

        System.out.println(lru.get(4));
//         lru.head.display();

        System.out.println(lru.get(5));
//         lru.head.display();

    }

    static class Cache {
        private final int cacheCapacity;
        public final HashMap<Integer, Node> keyValue;

        private Node head;
        private Node tail;

        public Cache(int cacheCapacity) {
            this.cacheCapacity = cacheCapacity;
            keyValue = new HashMap<>();
        }

        public int get(int key) {
            if (keyValue.containsKey(key)) {
                updateNodeSequence(key);
                return keyValue.get(key).value;
            }
            return -1;
        }

        private void updateNodeSequence(int key) {
            Node keyNode = keyValue.get(key);
            if (keyNode.next == null) return; // Tail Element

            if (keyNode.prev == null)
                head = keyNode.next; // Head Element
            else
                keyNode.prev.next = keyNode.next; // Middle Element

            head.prev = null;

            tail.next = keyNode;
            keyNode.prev = tail;
            keyNode.next = null;

            tail = tail.next;
        }

        private void updateNodeSequence(Node keyNode) {
            if (head == null) head = keyNode;
            if (tail == null) {
                tail = keyNode;
                return;
            }
            tail.next = keyNode;
            keyNode.prev = tail;
            keyNode.next = null;

            tail = tail.next;
        }

        public void put(int key, int value) {
            if (keyValue.containsKey(key)) {
                keyValue.get(key).value = value;
                updateNodeSequence(key);
                return;
            }

            if (keyValue.size() >= cacheCapacity) evict();

            Node node = new Node(key, value);
            updateNodeSequence(node);
            keyValue.put(key, node);
        }

        private void evict() {
            keyValue.remove(head.key);
            head = head.next;
        }

        private static class Node {
            int value;
            int key;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public void display() {
                System.out.print(this.value + " ");
                if (this.next != null) this.next.display();
                else System.out.println();
            }

            @Override
            public String toString() {
                return "Node{" +
                        "value=" + value +
                        ", key=" + key +
                        '}';
            }
        }

    }
}

