package June.WeekOne;

public class RandomPickByWeight {

	public static void main(String[] args) {
		int[] Arr = { 1, 2, 3, 4, 5 };
		Solution sol = new Solution(Arr);
		for (int i = 0; i < 10; i++) {
			System.out.println(sol.pickIndex());
		}
	}

}

class Solution {
	int[] ActualArray;
	int[] weightArray;
	int TotalSum = 0;

	public Solution(int[] w) {
		ActualArray = w.clone();
		weightArray = new int[w.length];
		int TSum = 0;
		for (int i = 0; i < w.length; i++) {
			TSum += ActualArray[i];
			weightArray[i] = TSum;
		}
		TotalSum = TSum;

	}

	public int pickIndex() {
		double RandomNumber = Math.random() * TotalSum;
		int low = 0;
		int high = weightArray.length;
		while (low < high) {
			int mid = (low + high) / 2;
			if (RandomNumber > weightArray[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
}
