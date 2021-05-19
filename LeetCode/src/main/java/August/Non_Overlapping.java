package August;

import java.util.Arrays;
import java.util.Comparator;

public class Non_Overlapping {

	public static void main(String[] args) {
//		[[0,2],[1,3],[2,4],[3,5],[4,6]]
		int[][] intervals = new int[][] { { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 } };
		System.out.println(eraseOverlapIntervals(intervals));
	}

	public static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length <= 1)
			return 0;
		int removeCount = 0;
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return (arg0[1] > arg1[1]) ? 1 : (arg0[1] < arg1[1]) ? -1 : 0;
			}
		});
		int prevNode = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < prevNode) {
				removeCount++;
			} else {
				prevNode = intervals[i][1];
			}
		}
		return removeCount;
	}
}
