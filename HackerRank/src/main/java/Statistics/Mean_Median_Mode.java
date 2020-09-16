package Statistics;

import java.util.Arrays;
import java.util.HashMap;

public class Mean_Median_Mode {

	public static void main(String[] args) {
		int[] arr = { 64630, 11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060 };
		Arrays.sort(arr);
		System.out.println(getMean(arr, 10));
		System.out.println(getMedian(arr, 10));
		System.out.println(getMode(arr, 10));
	}

	static float getMean(int[] arr, int N) {
		float result = 0;
		for (int i = 0; i < N; i++) {
			result += arr[i];
		}
		return result / N;
	}

	static float getMedian(int[] arr, int N) {
		if (N % 2 == 0) {
			return (float) (arr[(N / 2) - 1] + arr[N / 2]) / 2;
		} else {
			return arr[N / 2];
		}
	}

	static float getMode(int[] arr, int N) {
		int result = 1;
		int finalMode = arr[0];
		HashMap<Integer, Integer> occurance = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			if (occurance.containsKey(arr[i])) {
				int count = occurance.get(arr[i]);
				count++;
				occurance.put(arr[i], count);

				if (count > result) {
					result = count;
					finalMode = arr[i];
				}

			} else {
				occurance.put(arr[i], 1);
			}
		}
		return finalMode;
	}

}
