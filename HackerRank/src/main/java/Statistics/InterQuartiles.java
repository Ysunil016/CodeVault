package Statistics;

import java.util.Arrays;
import java.util.Scanner;

public class InterQuartiles {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scan.nextInt();
		int[] arr = new int[t];
		int[] freq = new int[t];

		for (int i = 0; i < t; i++)
			arr[i] = scan.nextInt();

		int tF = 0;
		for (int i = 0; i < t; i++) {
			freq[i] = scan.nextInt();
			tF += freq[i];
		}

		int[] result = getQMedians(arr, freq, tF, t);
		System.out.println();
		System.out.println(result[1]);
		System.out.println(result[0]);
		System.out.println(result[2]);
		System.out.println((float) (result[2] - result[0]));
	}

	static int[] getQMedians(int[] arr, int[] freq, int tF, int count) {
		int[] newArr = new int[tF];

		int tC = 0;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < freq[i]; j++) {
				newArr[tC] = arr[i];
				tC++;
			}
		}

		return getMedians(newArr, tF);
	}

	static int[] getMedians(int[] arr, int size) {
		Arrays.parallelSort(arr);
		int[] res = new int[3];

		for (int i : arr)
			System.out.print(i + " ");

		if (size % 2 != 0) {
			res[1] = arr[size / 2];
			if ((size / 2) % 2 == 0) {
				res[0] = (arr[size / 4] + arr[((size / 4) - 1)]) / 2;
				res[2] = (arr[3 * size / 4] + arr[(3 * size / 4) + 1]) / 2;
			} else {
				res[0] = (arr[size / 4] + arr[((size / 4) - 1)]) / 2;
				res[2] = (arr[3 * size / 4] + arr[(3 * size / 4) + 1]) / 2;
			}
		} else {
			res[1] = (arr[size / 2] + arr[(size / 2) - 1]) / 2;
			if ((size / 2) % 2 != 0) {
				res[0] = (arr[size / 4]);
				res[2] = (arr[3 * size / 4]);
			} else {
				res[0] = (arr[size / 4] + arr[(size / 4) - 1]) / 2;
				res[2] = (arr[(3 * size) / 4] + arr[((3 * size) / 4) - 1]) / 2;
			}
		}

		return res;
	}

}
