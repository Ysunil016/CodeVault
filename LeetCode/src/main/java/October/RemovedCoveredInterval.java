package October;

import java.util.Arrays;
import java.util.Comparator;

public class RemovedCoveredInterval {

    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][]{{1,2},{3,4},{4,2},{6,4}}));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        int[] curInterval = {-1,-1};
        int result = 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for(int[] interval : intervals){
            if(curInterval[0] <= interval[0] && curInterval[1] >= interval[1]){
                result++;
            }else{
                if(curInterval[0] >= interval[0] && curInterval[1] <= interval[1]){
                    result++;
                }
                curInterval = interval;
            }
        }

        return intervals.length - result;
    }
}
