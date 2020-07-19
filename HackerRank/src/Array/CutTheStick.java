package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class CutTheStick {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 3, 3, 2, 1 };

		// 8
		// 1 2 3 4 3 3 2 1

		for (int X : cutTheSticks(arr)) {
			System.out.print(X + " ");
		}
	}

	static int[] cutTheSticks(int[] arr) {
		Arrays.sort(arr);
		ArrayList<Integer> list = new ArrayList<>();
		int foundElement = arr[0];
		for (int i = 0; i < arr.length; i++) {
			foundElement = arr[i];
			if (foundElement == -1) {
				continue;
			}
			list.add(arr.length - i);
			for (int j = i; j < arr.length; j++) {
				arr[j] -= foundElement;
				if (arr[j] == 0)
					arr[j] = -1;
			}
		}

		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}

		return res;
	}

}
