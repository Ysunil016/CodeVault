package Statistics;

import java.util.Arrays;
import java.util.Scanner;

public class Quartiles {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scan.nextInt();
		int[] arr = new int[t];
		for (int i = 0; i < t; i++)
			arr[i] = scan.nextInt();

		int[] result = getMedians(arr, t);
		for (int i : result)
			System.out.println(i + " ");
	}

	static int[] getMedians(int[] arr, int size) {
		Arrays.parallelSort(arr);
		int[] res = new int[3];

		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();

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

	static int getMedian(int[] arr, int a, int b) {
		if ((a + b) / 2 != 0)
			return arr[(a + b) / 2];
		else
			return arr[(a + b) / 2];
	}

}
