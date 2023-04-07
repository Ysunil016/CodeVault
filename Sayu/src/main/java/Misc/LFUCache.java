package Misc;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    public static void main(String[] args) {
        Cache lru = new Cache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }

    static class Cache {
        private final int cacheCapacity;
        private final HashMap<Integer, Integer> keyValue;

        private final HashMap<Integer, Integer> keyOccurrences;

        public Cache(int cacheCapacity) {
            this.cacheCapacity = cacheCapacity;
            keyValue = new HashMap<>();
            keyOccurrences = new HashMap<>();
        }

        public int get(int key) {
            System.out.println(keyOccurrences);
            System.out.println(keyValue);

            if (keyValue.containsKey(key)) {
                keyOccurrences.put(key, keyOccurrences.get(key) + 1);
                return keyValue.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (keyValue.size() >= cacheCapacity) evict();
            keyValue.put(key, value);
            keyOccurrences.put(key, 0);
        }

        private void evict() {
            int lruOccurrence = Integer.MAX_VALUE;
            int lruKey = -1;
            for (Map.Entry<Integer, Integer> entry : keyOccurrences.entrySet()) {
                if (entry.getValue() < lruOccurrence) {
                    lruOccurrence = entry.getValue();
                    lruKey = entry.getKey();
                }
            }
            if (lruKey == -1) return;
            keyValue.remove(lruKey);
            keyOccurrences.remove(lruKey);
        }

    }
}

