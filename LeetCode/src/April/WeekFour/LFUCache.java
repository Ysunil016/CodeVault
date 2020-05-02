package April.WeekFour;

import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);
		lru.put(2, 1);
		lru.put(3, 2);
		System.out.println(lru.get(3));
		System.out.println(lru.get(2));
		lru.put(4, 3);
		System.out.println(lru.get(2));
		System.out.println(lru.get(3));
		System.out.println(lru.get(4));
	}

}

class LRUCache {
	LinkedHashMap<Integer, Integer> hash;

	public LRUCache(int capacity) {
		hash = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			private static final long serialVersionUID = 1L;
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
				return this.size() > capacity;
			}
		};
	}

	public int get(int key) {
		return (hash.containsKey(key)) ? hash.get(key) : -1;
	}

	public void put(int key, int value) {
		hash.put(key, value);
	}
}
