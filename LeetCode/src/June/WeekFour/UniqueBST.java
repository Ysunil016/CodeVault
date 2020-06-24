package June.WeekFour;

import java.util.Arrays;

public class UniqueBST {

	public static void main(String[] args) {
		System.out.println(numTrees(7));
	}

	private static int numTrees(int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, 0);
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = dp[i] + (dp[i - j] * dp[j - 1]);
			}
		}
		return dp[n];
	}

}
