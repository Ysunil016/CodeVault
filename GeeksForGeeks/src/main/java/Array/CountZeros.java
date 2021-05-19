package Array;

import java.util.Scanner;

public class CountZeros {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int tC = scan.nextInt();
		for (int i = 0; i < tC; i++) {
			int count = scan.nextInt();
			int[] ar = new int[count];
			for (int j = 0; j < count; j++) {
				ar[j] = scan.nextInt();
			}
			int oc = (firstZero(ar, 0, count - 1));
			if (oc != -1) {
				System.out.println(count - oc);
			} else {
				System.out.println(count);
			}
		}
	}

	static int firstZero(int arr[], int low, int high) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || arr[mid - 1] == 1) && arr[mid] == 0)
				return mid;

			if (arr[mid] == 1) // If mid element is not 0
				return firstZero(arr, (mid + 1), high);
			else // If mid element is 0, but not first 0
				return firstZero(arr, low, (mid - 1));
		}
		return -1;
	}

}
