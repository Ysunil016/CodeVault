package StackQueue;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	Map<Integer, Integer> map;
	final int CAPACITY;

	public LRUCache(int capacity) {
		this.CAPACITY = capacity;
		map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				{
					return size() > CAPACITY;
				}
			}
		};

	}

	public static void main(String[] args) {
		System.out.println("Going to test the LRU " + " Cache Implementation");
		LRUCache cache = new LRUCache(2);

// it will store a key (1) with value  
// 10 in the cache. 
		cache.set(1, 10);

// it will store a key (1) with value 10 in the cache. 
		cache.set(2, 20);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

// evicts key 2 and store a key (3) with 
// value 30 in the cache. 
		cache.set(3, 30);

		System.out.println("Value for the key: 2 is " + cache.get(2)); // returns -1 (not found)

// evicts key 1 and store a key (4) with 
// value 40 in the cache. 
		cache.set(4, 40);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found)
		System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30
		System.out.println("Value for the key: 4 is " + cache.get(4)); // return 40

	}

	public int get(int key) {
		System.out.println("Going to get the value " + "for the key : " + key);
		return map.getOrDefault(key, -1);
	}

	// This method works in O(1)
	public void set(int key, int value) {
		System.out.println("Going to set the (key, " + "value) : (" + key + ", " + value + ")");
		map.put(key, value);
	}
}
