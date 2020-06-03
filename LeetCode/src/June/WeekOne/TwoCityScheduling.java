package June.WeekOne;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

	public static void main(String[] args) {
		int[][] arr = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
		System.out.println(twoCitySchedCost(arr));
	}

	public static int twoCitySchedCost(int[][] costs) {
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] A, int[] B) {
				return Integer.compare((A[0] - A[1]), (B[0] - B[1]));
			}
		});
		int Result = 0;
		for (int i = 0; i < costs.length; i++) {
			if (i < costs.length / 2) {
				Result += costs[i][0];
			} else {
				Result += costs[i][1];
			}
		}
		return Result;
	}

}
