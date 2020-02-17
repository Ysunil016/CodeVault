package Array;

import java.util.Arrays;

public class MinimumDifferancePair {

	public static void main(String[] args) {
		int[] nums = { 2, 4, 5, 7, 9 };

		System.out.println(getMinDiff(nums));

		System.out.println();
		int[] nums2 = { 87, 32, 99, 75, 56, 43, 21, 10, 68, 49 };
		System.out.println(getMinDiffUnSorted(nums2));

	}

	// For Sorted;
	static int getMinDiff(int[] arr) {
		// Finding All Difference based on Consecutive Numbers
		int currentMin = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			if (Math.abs(arr[i] - arr[i + 1]) < currentMin) {
				currentMin = Math.abs(arr[i] - arr[i + 1]);
			}
		}
		return currentMin;
	}

	// For Unsorted
	static int getMinDiffUnSorted(int[] arr) {
		getSorted(arr);
		return getMinDiff(arr);
	}

	static void getSorted(int[] nums) {
		Arrays.sort(nums);
	}

}
