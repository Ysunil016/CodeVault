package _60Days.SearchSort;

public class MergeSort {

	public static void main(String[] args) {

		int[] nArray = { 4, 3, 1, 4, 6, 7, 4, 1, 3, 2, 1, 5, 2, 5, 6 };
		Merge(nArray, 0, nArray.length - 1);

		for (int X : nArray) {
			System.out.print(X + " ");
		}
	}

	static void Merge(int[] arr, int l, int r) {

		if (l < r) {
			int mid = (l + r) / 2;
			Merge(arr, l, mid);
			Merge(arr, mid + 1, r);

			mergeSort(arr, l, mid, r);
		}
	}

	static void mergeSort(int[] arr, int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int i = 0; i < n2; ++i)
			R[i] = arr[m + 1 + i];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

}
