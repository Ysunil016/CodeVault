package September;

import java.util.Arrays;
import java.util.Comparator;

public class CarPooling {

    public static void main(String[] args) {
        int[][] trips = {{3,2,7},{3,7,9},{8,3,9}};
        System.out.println(carPooling(trips,5));
    }

    private static boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];

        int max = 0;
        for (int[] trip : trips) {
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
            max = Math.max(max, trip[2]);
        }

        if(arr[0] > capacity) return false;

        for(int i=1;i<max;i++){
            arr[i] += arr[i-1];
            if(arr[i] > capacity)
                return  false;
        }

        return true;
    }

}
