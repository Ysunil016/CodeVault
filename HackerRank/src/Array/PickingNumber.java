package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PickingNumber {

	public static void main(String[] args) {
		System.out.println(pickingNumbers(Arrays.asList(1, 4, 2, 1, 5, 3)));
	}

	public static int pickingNumbers(List<Integer> a) {
		HashSet<Integer> uniqueElements = new HashSet<>();
		HashMap<Integer, Integer> occurancesCount = new HashMap<>();
		for (int x : a) {
			uniqueElements.add(x);
			if (occurancesCount.containsKey(x)) {
				occurancesCount.put(x, occurancesCount.get(x) + 1);
			} else {
				occurancesCount.put(x, 1);
			}
		}

		int maxArrayCount = 0;
		for (int x : uniqueElements) {
			int allElements = occurancesCount.getOrDefault(x, 0);
			int allElementsL = occurancesCount.getOrDefault(x - 1, 0);

			int Max1 = allElements + allElementsL;
			int allElementsR = occurancesCount.getOrDefault(x + 1, 0);
			int Max2 = allElements + allElementsR;
			maxArrayCount = Math.max(maxArrayCount, Math.max(Max1, Max2));
		}
		return maxArrayCount;
	}

}
