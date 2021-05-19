package August;

import java.util.ArrayList;
import java.util.List;

public class PancakeFlip {

	public static void main(String[] args) {
		System.out.println(pancakeSort(new int[] { 4, 3, 2, 4 }));
	}

	public static List<Integer> pancakeSort(int[] A) {
		List<Integer> list = new ArrayList<>();

		for (int i = A.length; i > 0; i--) {
			int index = getIndex(A, i);
			flip(A, index);
			flip(A, i - 1);
			list.add(index + 1);
			list.add(i);
		}
		return list;
	}

	private static void flip(int[] A, int index) {
		int i = 0;
		while (i < index) {
			int temp = A[i];
			A[i++] = A[index];
			A[index--] = temp;
		}
	}

	private static int getIndex(int[] A, int t) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == t)
				return i;
		}
		return -1;
	}

}
