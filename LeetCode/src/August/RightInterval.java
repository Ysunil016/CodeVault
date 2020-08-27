package August;

import java.util.Arrays;

public class RightInterval {

	public static void main(String[] args) {
		int[][] r = { { 1, 4 }, { 2, 3 }, { 3, 4 } };

		for (int x : findRightInterval(r)) {
			System.out.println(x);
		}
	}

	public static int[] findRightInterval(int[][] intervals) {
		int[] ar = new int[intervals.length];
		Arrays.fill(ar, -1);

		for (int i = 0; i < intervals.length; i++) {
			int x = intervals[i][0];
			int y = intervals[i][1];

			int minVal = Integer.MAX_VALUE;
			for (int j = 0; j < intervals.length; j++) {
				if (intervals[j][0] >= y && x != intervals[j][0] && intervals[j][0] < minVal) {
					minVal = intervals[j][0];
					ar[i] = j;
				}
			}
		}
		return ar;
	}

}
