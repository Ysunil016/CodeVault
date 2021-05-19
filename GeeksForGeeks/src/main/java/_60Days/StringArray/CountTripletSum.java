package _60Days.StringArray;

import java.util.Arrays;

public class CountTripletSum {

	public static void main(String[] args) {
		int[] Arr = { 5, 1, 3, 4, 7 };
		System.out.println(getTripletCpunt(Arr, 12));
	}

	private static int getTripletCpunt(int[] arr, int Sum) {
		Arrays.sort(arr);
		int ResultCount = 0;
		for (int I = 0; I < arr.length - 2; I++) {
			int J = I + 1;
			int K = arr.length - 1;

			while (J < K) {
				if (arr[I] + arr[J] + arr[K] >= Sum) {
					K--;
				} else {
					ResultCount += K - J;
					J++;
				}
			}
		}
		return ResultCount;
	}

}
