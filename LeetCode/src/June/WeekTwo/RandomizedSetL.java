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

	public boolean insert(int val) {
		if (hash.containsKey(val)) {
			return false;
		}
		hash.put(val, array.size());
		array.add(val);
		return true;
	}
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
	public int getRandom() {
		int Size = array.size();
		int Prob = (int) (Math.random() * (Size));
		return array.get(Prob);
	}
}

