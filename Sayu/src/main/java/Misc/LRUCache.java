package Misc;

import java.util.*;

class LRUCache {
    public static void main(String[] args) {
        Cache lru = new Cache(2);
//
//        SET 1 2 SET 2 3 SET 1 5
//        SET 4 5 SET 6 7 GET 4 SET 1 2 GET 3
        lru.put(1, 2);
        lru.put(2, 3);
        lru.put(1, 5);
        lru.put(4, 5);
        lru.put(6, 7);
        System.out.println(lru.get(4));
        lru.put(1, 2);
        System.out.println(lru.get(3));
    }

    static class Cache {
        private final int cacheCapacity;
        private final HashMap<Integer, Node> keyValue;

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

            if (keyNode.prev == null) head = keyNode.next; // Head Element

            // Middle Element
            keyNode.prev = keyNode.next;
            tail.next = keyNode;
        }

        private void updateNodeSequence(Node keyNode) {
            if (head == null) head = keyNode;
            if (tail == null) {
                tail = keyNode;
                return;
            }
            tail.next = keyNode;
            tail = tail.next;
        }

        public void put(int key, int value) {
            if (keyValue.size() >= cacheCapacity) evict();
            if (keyValue.containsKey(key)) return;
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

