package Array;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 0, 0, 2, 2, 3, 4, 5 };
		int result = removeDups(arr);
		System.out.println("Result is " + result);
		for (int data : arr) {
			System.out.print(" " + data);
		}
	}

	/*
	 * Taking 2 Pointers One at 1 and Other Traversing through Array
	 */

	static int removeDups(int[] arr) {
		if (arr.length == 0)
			return 0;

		int first = 0;
		int second = 1;

		int result = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[first]) {
				second = i;
			} else {
				arr[first + 1] = arr[second];
				first++;
			}
		}
		return result;
	}

}
