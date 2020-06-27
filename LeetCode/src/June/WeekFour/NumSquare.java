package June.WeekFour;

import java.util.Arrays;

public class NumSquare {

	public static void main(String[] args) {
		System.out.println(make(10));
	}

	public static int make(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, n);
		dp[0] = 0;
		dp[1] = 1;

		return 1;
	}

}
