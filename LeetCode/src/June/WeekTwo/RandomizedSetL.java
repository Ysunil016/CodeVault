package June.WeekTwo;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomizedSetL {

	public static void main(String[] args) {
		RandomizedSet rS = new RandomizedSet();
		System.out.println(rS.remove(0));
		System.out.println(rS.remove(0));
		System.out.println(rS.insert(0));
		System.out.println(rS.getRandom());
		System.out.println(rS.remove(0));
		System.out.println(rS.insert(0));

//		rS.remove(1);
//		rS.insert(2);
//		System.out.println(rS.getRandom());
	}

}

class RandomizedSet {
	HashMap<Integer, Integer> hash;
	ArrayList<Integer> array;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		hash = new HashMap<Integer, Integer>();
		array = new ArrayList<Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (hash.containsKey(val)) {
			return false;
		}
		hash.put(val, array.size());
		array.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (hash.containsKey(val)) {
			int last_element = array.get(array.size() - 1);
			int key = hash.get(val);
			array.set(key, last_element);
			hash.put(last_element, key);
			array.remove(array.size() - 1);
			hash.remove(val);
			return true;
		}
		return false;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int Size = array.size();
		int Prob = (int) (Math.random() * (Size));
		return array.get(Prob);
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
