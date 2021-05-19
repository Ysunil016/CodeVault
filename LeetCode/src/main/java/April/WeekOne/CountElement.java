package April.WeekOne;

import java.util.HashSet;

public class CountElement {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(countElements(arr));
	}

	public static int countElements(int[] arr) {
		int count = 0;
		HashSet<Integer> uStore = new HashSet<Integer>();
		for (int a : arr)
			uStore.add(a);

		for (int a : arr) {
			if (uStore.contains(a + 1)) {
				count++;
			}
		}

		return count;
	}

}
