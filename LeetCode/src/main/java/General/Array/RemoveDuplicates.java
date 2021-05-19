package General.Array;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 0, 2, 2, 3, 4, 5 };
		int result = removeDups(arr);
		System.out.println("Result is " + result);
		for (int data : arr) {
			System.out.print(" " + data);
		}
	}


	static int removeDups(int[] arr) {
		if (arr.length == 0)
			return 0;

		int first = 0;
		int second = 1;

		int result = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[first]) {
				second++;
			} else {
				arr[first + 1] = arr[second];
				second++;
				first++;
				result++;
			}
		}
		return result;
	}

}
