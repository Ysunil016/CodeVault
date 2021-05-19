package _60Days.SearchSort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] aR = { 1, 2, 7, 3, 1, 5, 7, 8, 3, 5, 2, 6 };

		bubbleSortOptamized(aR);

		bubbleSortNaieve(aR);

		for (int x : aR) {
			System.out.print(x + " ");
		}
	}

	// O(N^2) - Worst
	// O(N) Best
	private static void bubbleSortOptamized(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			boolean hasChange = false;
			for (int j = 0; j < nums.length - 1; j++) {
				if (nums[i] < nums[j]) {
					hasChange = true;
					int Temp = nums[i];
					nums[i] = nums[j];
					nums[j] = Temp;
				}
			}
			if (!hasChange)
				break;
		}

	}

	// O(N^2)
	private static void bubbleSortNaieve(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - 1; j++) {
				if (nums[i] < nums[j]) {
					int Temp = nums[i];
					nums[i] = nums[j];
					nums[j] = Temp;
				}
			}
		}
	}

}
