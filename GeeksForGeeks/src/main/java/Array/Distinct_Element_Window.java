package Array;

import java.util.Arrays;

public class Distinct_Element_Window {

	public static void main(String[] args) {
//		int[] arr = { 1, 2, 1, 2, 3, 4, 3, 2 };
		int[] arr = { 4, 1, 1 };
		getDistinctElementInWindow(arr, 2, 3);
	}

	static void getDistinctElementInWindow(int[] arr, int windowSize, int count) {
		if (windowSize > count)
			return;

		int[] arr2 = arr.clone();
		for (int i = 0; i < count - windowSize + 1; i++) {
			Arrays.sort(arr2, i, i + windowSize);
			int found = arr2[i];
			int Tres = 1;
			for (int k = i + 1; k < (i + windowSize); k++) {
				if (arr2[k] != found) {
					Tres++;
					found = arr2[k];
				}
			}
			System.out.print(Tres + " ");
			arr2 = arr.clone();
		}

	}

}
