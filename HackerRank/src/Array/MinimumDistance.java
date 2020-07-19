package Array;

import java.util.HashMap;

public class MinimumDistance {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 3, 4 };
		System.out.println(minimumDistances(arr));
	}

	static int minimumDistances(int[] a) {
		HashMap<Integer, Integer> hash = new HashMap<>();
		// Putting Hash With First Position
		for (int i = 0; i < a.length; i++) {
			hash.putIfAbsent(a[i], i);
		}
		int minVal = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (hash.get(a[i]) != i) {
				minVal = Math.min(minVal, Math.abs(i - hash.get(a[i])));
			}
		}
		if(minVal == Integer.MAX_VALUE)
			return -1;
		return minVal;
	}

}
