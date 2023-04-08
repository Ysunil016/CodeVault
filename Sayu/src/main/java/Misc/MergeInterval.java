package Misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeInterval {
    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = new int[][]{{1, 4}, {4, 5}};

        for (int[] mergedInterval : merge(intervals))
            System.out.println(mergedInterval[0] + "," + mergedInterval[1]);
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Stack<int[]> stack = new Stack<>();

        // [[1,3],[2,6],[8,10],[15,18]]
        for (int[] currentInterval : intervals) {
            if (stack.isEmpty()) {
                stack.add(currentInterval);
                continue;
            }

            int[] prevInterval = stack.peek();
            if (needToMerge(prevInterval, currentInterval)) {
                prevInterval = stack.pop();
                currentInterval[0] = Math.min(currentInterval[0], prevInterval[0]);
                currentInterval[1] = Math.max(currentInterval[1], prevInterval[1]);
                stack.add(currentInterval);
            } else {
                stack.add(currentInterval);
            }
        }

        int[][] res = new int[stack.size()][2];
        int idx = res.length - 1;
        while (!stack.isEmpty())
            res[idx--] = stack.pop();

        return res;
    }

    private static boolean needToMerge(int[] prevInterval, int[] currentInterval) {
        int prevStart = prevInterval[0];
        int prevEnd = prevInterval[1];

        int curStart = currentInterval[0];
        int curEnd = currentInterval[1];

        // [[1,3],[2,6],[8,10],[15,18]]
        return curStart <= prevEnd;
    }

}
