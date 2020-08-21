package August;

public class SortArrayByParity {

	public static void main(String[] args) {
		int[] arrayList = { 3, 1, 2, 4 };
		for (int x : sortArrayByParity(arrayList)) {
			System.out.print(x + " ");
		}
	}

	public static int[] sortArrayByParity(int[] A) {
		int low = 0;
		int high = A.length - 1;

		while (low < high) {
			int foundNumber = A[low];
			if (foundNumber % 2 != 0) {
				A[low] = A[high];
				A[high] = foundNumber;
				high--;
			} else {
				low++;
			}

		}

		return A;
	}

}
