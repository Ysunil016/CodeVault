package August;

import java.util.Arrays;

public class DesignHashSet {

	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(10);
	}

	static class MyHashSet {

		boolean[] valStore;

		public MyHashSet() {
			valStore = new boolean[100];
		}

		public void add(int key) {
			if (key >= valStore.length) {
				extendLength(key);
			}
			valStore[key] = true;
		}

		public void remove(int key) {
			if (key < valStore.length)
				valStore[key] = false;
		}

		/** Returns true if this set contains the specified element */
		public boolean contains(int key) {
			if (key >= valStore.length)
				return false;
			return valStore[key];
		}

		private void extendLength(int Key) {
			valStore = Arrays.copyOf(valStore, Key + 2);
		}

	}

	// HashSet -> 16nm
	class MyHashSet2 {

		private int[] valStore;

		public MyHashSet2() {
			valStore = new int[1000000];
		}

		public void add(int key) {
			valStore[key] = 1;
		}

		public void remove(int key) {
			valStore[key] = 0;
		}

		/** Returns true if this set contains the specified element */
		public boolean contains(int key) {
			return (valStore[key] == 1) ? true : false;
		}

	}

}
