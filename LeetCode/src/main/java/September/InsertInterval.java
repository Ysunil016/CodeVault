package September;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		System.out.println(insert(new int[][] {}, new int[] {}));
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> list = new ArrayList<int[]>();
		for (int[] inside : intervals) {
			if (inside[1] < newInterval[0]) {
				list.add(inside);
			} else if (newInterval[1] < inside[0]) {
				list.add(newInterval);
				newInterval = inside;
			} else {
				newInterval[0] = Math.min(newInterval[0], inside[0]);
				newInterval[1] = Math.max(newInterval[1], inside[1]);
			}
		}
		list.add(newInterval);

		return list.toArray(new int[list.size()][]);
	}

}
