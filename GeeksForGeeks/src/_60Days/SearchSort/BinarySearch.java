package _60Days.SearchSort;

public class BinarySearch {

	public static void main(String[] args) {
		int[] sortedArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		System.out.println("Iterative");
		System.out.println(binarySearchIterative(sortedArr, 1));
		System.out.println("Recursive");
		System.out.println(binarySearchRecursive(sortedArr, 0, sortedArr.length - 1, 16));

	}

	static boolean binarySearchIterative(int[] bsArray, int toSearch) {
		int low = 0;
		int high = bsArray.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (bsArray[mid] == toSearch)
				return true;
			if (toSearch > bsArray[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}

	static boolean binarySearchRecursive(int[] bsArray, int low, int high, int toSearch) {
		if (low > high) {
			return false;
		}
		int mid = low + (high - low) / 2;

		if (bsArray[mid] == toSearch) {
			return true;
		}
		if (toSearch > bsArray[mid])
			return binarySearchRecursive(bsArray, mid + 1, high, toSearch);
		else
			return binarySearchRecursive(bsArray, low, mid - 1, toSearch);
	}
}
