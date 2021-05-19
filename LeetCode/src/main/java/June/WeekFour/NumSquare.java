package June.WeekFour;

import java.util.Arrays;

public class NumSquare {

	public static void main(String[] args) {
		System.out.println(make(13));
	}

	public static int make(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 0);
		for (int i = 1; i <= n; i++) {
			int minV = i;
			int y = 1;
			int sq = 1;
			while (sq <= i) {
				minV = Math.min(minV, 1 + dp[i - sq]);
				y++;
				sq = y * y;
			}
			dp[i] = minV;
		}
		return dp[n];
	}

}
