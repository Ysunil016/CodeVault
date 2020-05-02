package April.WeekFour;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class FirstUniqueNumber {

	public static void main(String[] args) {

//		7,7,7,7,7,7,7,3,3,7,17
		int[] arr = { 5, 2, 3 };
		FirstUnique fQ = new FirstUnique(new int[] { 2, 3, 5 });
		for (int x : arr)
			fQ.add(x);
		System.out.println(fQ.showFirstUnique());
	}

}

class FirstUnique {

	Deque<Integer> uniqueStore = new LinkedList<Integer>();
	HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();

	public FirstUnique(int[] nums) {
		for (int x : nums) {
			if (store.containsKey(x)) {
				store.put(x, store.get(x) + 1);
			} else {
				store.put(x, 1);
				uniqueStore.add(x);
			}
		}
	}

	public int showFirstUnique() {
		while (!uniqueStore.isEmpty() && store.get(uniqueStore.getFirst()) > 1) {
			uniqueStore.pop();
		}

		if (uniqueStore.isEmpty())
			return -1;

		return uniqueStore.getFirst();
	}

	public void add(int x) {
		if (store.containsKey(x)) {
			store.put(x, store.get(x) + 1);
		} else {
			store.put(x, 1);
			System.out.println("Adding" + x);
			uniqueStore.add(x);
		}
	}

}
