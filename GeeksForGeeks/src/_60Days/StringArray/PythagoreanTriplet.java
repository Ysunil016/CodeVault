package _60Days.StringArray;

import java.util.Arrays;

public class PythagoreanTriplet {

	public static void main(String[] args) {
		int[] Arr = { 3, 1, 4, 6, 5 };
		System.out.println(hasArrayHasPythagorean(Arr));
	}

	private static boolean hasArrayHasPythagorean(int[] arr) {
		// O(nlogn)
		Arrays.sort(arr);
		for (int I = 0; I < arr.length - 2; I++) {
			int J = I + 1;
			int K = arr.length - 1;

			int A = arr[I] * arr[I];
			while (J < K) {

				int C = arr[K] * arr[K];

				int ResultSum = A + arr[J] * arr[J];
				if (ResultSum == C)
					return true;

				if (ResultSum <= C) {
					K--;
				} else {
					J++;
				}
			}

		}

		return false;
	}

}
