package September;

import java.util.Arrays;

public class LongestNumber {

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{4,3,6,33,34}));
    }

    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for(int i = 0; i < n; i++)
            s[i] = String.valueOf(nums[i]);

        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for(String str : s)
            sb.append(str);
        String result = sb.toString();
        return result.startsWith("0") ? "0" : result;
    }
}
