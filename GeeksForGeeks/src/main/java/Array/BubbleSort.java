package Array;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	void bubbleSort(int arr[], int n) {
		for (int i = 0; i < n - 1; i++)
			bubble(arr, i, n);
	}

	static void bubble(int arr[], int i, int n) {
		for (int j = i; j < n; j++) {
			if (arr[j] < arr[i]) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
