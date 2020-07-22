package _60Days.StringArray;

import java.util.Arrays;
import java.util.HashSet;

public class PythagoreanTriplet {

	public static void main(String[] args) {
		int[] Arr = { 10, 4, 6, 12, 5, 13 };

		System.out.println(hasArrayHasPythagorean(Arr));
	}

	private static boolean hasArrayHasPythagorean(int[] arr) {
		// O(nlogn)
		Arrays.sort(arr);

		HashSet<Integer> hashStore = new HashSet<>();
		for (int X : arr)
			hashStore.add(X);

		for (int I = 0; I < arr.length - 2; I++) {
			for (int J = I; J < arr.length; J++) {
				if (hashStore.contains(I * I + J * J))
					return true;
			}
		}

		return false;
	}

}
