package August;

import java.util.ArrayList;

public class NumberSameDifference {

	public static void main(String[] args) {
		for (int x : numsSameConsecDiff(3, 7)) {
			System.out.println(x);
		}
	}

	public static int[] numsSameConsecDiff(int N, int K) {
		ArrayList<Integer> resultStore = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			makeNumber(resultStore, i + 1, N, K, 0, i + 1);
		}
		int[] resultArray = new int[resultStore.size()];
		for (int i = 0; i < resultArray.length; i++) {
			resultArray[i] = resultStore.get(i);
		}
		return resultArray;
	}

	private static void makeNumber(ArrayList<Integer> resultStore, int num, int N, int K, int count, int prev) {
		if (count == N - 1) {
			resultStore.add(num);
			return;
		}

		int next = prev + K;
		if (next < 10) {
			makeNumber(resultStore, num * 10 + next, N, K, count + 1, next);
		}
		next = prev - K;
		if (K != 0 && next >= 0) {
			makeNumber(resultStore, num * 10 + next, N, K, count + 1, next);
		}
	}

}
