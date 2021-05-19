package June.WeekOne;

import java.util.Arrays;

public class CoinChange2 {

	public static void main(String[] args) {
		int[] Arr = { 1, 2, 5 };
		System.out.println(change(5, Arr));
	}

	public static int change(int amount, int[] coins) {
		int[][] dynamic = new int[coins.length + 1][amount + 1];
		for (int i = 1; i <= amount; i++) {
			dynamic[0][i] = 0;
		}
		for (int i = 0; i <= coins.length; i++) {
			dynamic[i][0] = 1;
		}
		for (int i = 1; i <= coins.length; i++) {
			int currentCoin = coins[i - 1];
			for (int j = 1; j <= amount; j++) {
				if (currentCoin > j)
					dynamic[i][j] = dynamic[i - 1][j];
				else {
					dynamic[i][j] = dynamic[i - 1][j] + dynamic[i][(j - currentCoin)];
				}
			}
		}
		for (int i = 0; i <= coins.length; i++) {
			for (int j = 0; j <= amount; j++) {
				System.out.print(dynamic[i][j] + " ");
			}
			System.out.println();
		}

		return dynamic[coins.length][amount];
	}

	public static int change2(int amount, int[] coins) {

		int dp[] = new int[amount + 1];
		Arrays.fill(dp, 0);
		dp[0] = 1;
		for (int coin : coins) {
			for (int j = coin; j <= amount; j++) {
				dp[j] += dp[j - coin];
			}
		}
		return dp[amount];
	}
}
