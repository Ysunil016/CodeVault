package _60Days.SearchSort;

public class SearchInRotatedSorted {

	public static void main(String[] args) {
		int[] sArray = { 1, 2, 3 };
		System.out.println(seachInRotatedIterative(sArray, 1));
	}

	private static boolean seachInRotatedIterative(int[] sArray, int element2Search) {
		int low = 0;
		int high = sArray.length - 1;
		int pivotIndex = findPivot(sArray, low, high);

		if (pivotIndex == -1) {
			return binarySearch(sArray, low, high, element2Search);
		}

		if (sArray[pivotIndex] == element2Search)
			return true;
		if (sArray[0] <= element2Search) {
			return binarySearch(sArray, low, pivotIndex, element2Search);
		} else {
			return binarySearch(sArray, pivotIndex, high, element2Search);
		}

	}

	static boolean binarySearch(int[] sArray, int low, int high, int toSearch) {
		if (low > high)
			return false;

		int mid = (high + low) / 2;
		if (sArray[mid] == toSearch)
			return true;

		if (toSearch > sArray[mid]) {
			return binarySearch(sArray, mid + 1, high, toSearch);
		} else {
			return binarySearch(sArray, low, mid - 1, toSearch);
		}

	}

	static int findPivot(int[] sArray, int low, int high) {
		if (low > high)
			return -1;

		if (high == low)
			return high;

		int mid = low + (high - low) / 2;
		if (mid < high && sArray[mid] > sArray[mid + 1]) {
			return mid;
		}
		if (mid > low && sArray[mid] < sArray[mid - 1]) {
			return mid - 1;
		}
		if (sArray[low] >= sArray[mid]) {
			return findPivot(sArray, low, mid - 1);
		} else {
			return findPivot(sArray, mid + 1, high);
		}

	}
}
