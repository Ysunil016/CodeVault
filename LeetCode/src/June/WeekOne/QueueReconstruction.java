package June.WeekOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstruction {

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		for (int[] x : reconstructQueue(arr)) {
			for (int v : x)
				System.out.print(v + " ");
			System.out.println();
		}
	}

	public static int[][] reconstructQueue(int[][] people) {
		// Sorting People Array First - Descending Order
		List<int[]> result = new ArrayList<int[]>();
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0])
					return Integer.compare(b[0], a[0]);
				else
					return Integer.compare(a[1], b[1]);
			}
		});
		for (int[] person : people) {
			result.add(person[1], person);
		}
		return result.toArray(new int[result.size()][]);
	}

}
