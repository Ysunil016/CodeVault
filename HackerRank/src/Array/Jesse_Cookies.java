package Array;

import java.util.Arrays;

public class Jesse_Cookies {

	public static void main(String[] args) {

//		int ArrLen = 6;
//		int Key = 7;

		int[] arr = { 13,47,74,12,89,74,18,38 };
		System.out.println(operationsRequired(arr, 90));
	}

	static int operationsRequired(int[] arr, int key) {
		Arrays.parallelSort(arr);
		if (arr.length == 0)
			return 0;
		int rep = 0;
		if (arr[0] >= key)
			return rep;
		int i = 0;
		for (i = 0; i < arr.length - 1; i++) {
			if (arr[i] >= key)
				return rep;
			int _Sweeter = arr[i] * 1 + arr[i + 1] * 2;
			arr[i] = 0;
			arr[i + 1] = _Sweeter;
			int counter = i + 1;
			while (counter < arr.length - 1 && arr[counter] > arr[counter + 1]) {
				int temp = arr[counter];
				arr[counter] = arr[counter + 1];
				arr[counter + 1] = temp;
				counter++;
			}
			rep++;
		}
		if (i == (arr.length - 1) && arr[i] >= key)
			return rep;

		return -1;
	}

}
