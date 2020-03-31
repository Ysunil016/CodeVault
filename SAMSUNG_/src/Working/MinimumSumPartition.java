package Working;

public class MinimumSumPartition {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };

		// O(n^3)
		printSubsets(arr);
	}

	// O(n)
//	static int MinSumPart(int[] arr) {
//		int result = Integer.MAX_VALUE;
//		for (int i = 1; i < arr.length; i++)
//			result = Math.min(result, matchingPermutationOfAll(arr, i));
//
//		return result;
//	}

	// Not Optimised
	static void printSubsets(int arr[]) {
		int n = arr.length;
		int result = Integer.MAX_VALUE;

		// 2^n -> Left Shift
		for (int i = 1; i < (1 << n); i++) {
			int[] tempArr = arr.clone();
			int leftSet = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					System.out.print(" " + arr[j]);
					leftSet += arr[j];
					tempArr[j] = 0;
				}

				int rightSet = 0;
				for (int z = 0; z < n; z++) {
					rightSet += tempArr[z];
				}
				result = Math.min(result, Math.abs(leftSet - rightSet));
			}
			System.out.println();
		}
		System.out.println(result);
	}

}
