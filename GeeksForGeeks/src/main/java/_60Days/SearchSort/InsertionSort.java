package _60Days.SearchSort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] aR = { 1, 3, 1, 2, 3, 6, 7, 8, 5, 3, 2, 9 };
		insertionSort(aR);
		for (int X : aR) {
			System.out.print(X + " ");
		}
	}

	static void insertionSort(int[] toBeSorted) {
		for (int i = 1; i < toBeSorted.length; i++) {
			if (toBeSorted[i - 1] >= toBeSorted[i]) {
				int Temp = toBeSorted[i];
				int J = i - 1;

				while (toBeSorted[J] > Temp) {
					toBeSorted[J + 1] = toBeSorted[J];
					J--;
				}
				toBeSorted[J + 1] = Temp;
			}
		}
	}

}
