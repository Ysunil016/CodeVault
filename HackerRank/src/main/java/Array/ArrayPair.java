package Array;

import java.util.Scanner;

public class ArrayPair {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		System.out.println(getAllPairs(arr));
	}

	// Finding All the Pairs (Next Consecutive)
	static long getAllPairs(int[] arr) {
		int counter = 0;

		for (int i = 0; i < arr.length; i++) {
			int initial = arr[i];
			int maxVal = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				maxVal = (arr[j] > maxVal) ? arr[j] : maxVal;
				if ((initial * arr[j]) <= maxVal) {
					counter++;
				}
			}
		}
		return counter;
	}
}
