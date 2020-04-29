package _30Days.WeekThree;

public class FindInRotatedSorted {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 3 };
		System.out.println(search(arr, 0, arr.length - 1, 3));

	}

	static int search(int[] arr, int l, int h, int key) {

		if (l > h)
			return -1;

		// Finding Middle Element
		int mid = (l + h) / 2;
		if (key == arr[mid])
			return mid;

		// Checking of Low<Mid i.e Array is Sorted
		if (arr[l] <= arr[mid]) {
			if (key >= arr[l] && key <= arr[mid])
				return search(arr, l, mid - 1, key);

			return search(arr, mid + 1, h, key);
		}

		// Not Sorted
		if (key >= arr[mid] && key <= arr[h])
			return search(arr, mid + 1, h, key);

		return search(arr, l, mid - 1, key);

	}

}
