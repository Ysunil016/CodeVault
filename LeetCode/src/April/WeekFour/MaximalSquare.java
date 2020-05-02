package April.WeekFour;

public class MaximalSquare {

	public static void main(String[] args) {
		char[][] arr = { { '1', '1', '1', '1' }, { '1', '1', '1', '1' }, { '1', '1', '1', '1' } };
		System.out.println(getMaxSq(arr));

	}

	static int getMaxSq(char[][] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		int maxFound = 0;
		int[][] dp = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr[0].length; i++) {
			dp[0][i] = Character.getNumericValue(arr[0][i]);
			maxFound = Math.max(maxFound, dp[0][i]);
		}
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = Character.getNumericValue(arr[i][0]);
			maxFound = Math.max(maxFound, dp[i][0]);
		}
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[0].length; j++) {
				if (i == 0 || j == 0)
					continue;
				if (arr[i][j] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
					maxFound = Math.max(maxFound, dp[i][j]);
				}
			}
		return maxFound * maxFound;
	}

}
