package May.WeekFour;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

	public static void main(String[] args) {
		int[][] arrA = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[][] arrB = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
		System.out.println(findInterPoint(arrA, arrB));
	}

	static int[][] findInterPoint(int[][] x, int[][] y) {
		List<int[]> list = new ArrayList<int[]>();

		int CounterA = 0;
		int CounterB = 0;

		while (CounterA < x.length && CounterB < y.length) {
			int[] tR = { Math.max(x[CounterA][0], y[CounterB][0]), Math.min(x[CounterA][1], y[CounterB][1]) };
			if (tR[0] <= tR[1]) {
				list.add(tR);
			}
			if (x[CounterA][1] < y[CounterB][1]) {
				CounterA++;
			} else {
				CounterB++;
			}
		}
		int[][] result = new int[list.size()][0];
		int i = 0;
		for (int[] val : list) {
			result[i] = val;
			i++;
		}
		return result;
	}

}

/*
 * Given two lists of closed intervals, each list of intervals is pairwise
 * disjoint and in sorted order. Return the intersection of these two interval
 * lists. (Formally, a closed interval [a, b] (with a <= b) denotes the set of
 * real numbers x with a <= x <= b. The intersection of two closed intervals is
 * a set of real numbers that is either empty, or can be represented as a closed
 * interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 */