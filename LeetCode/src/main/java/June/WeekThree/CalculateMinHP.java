package June.WeekThree;

public class CalculateMinHP {

	public static void main(String[] args) {
//		int[][] arr = { { -200 } };
//		int[][] arr = { { 0 } };
		int[][] arr = { { 8, -3, 2 }, { 4, -9, 2 }, { -9, -4, 2 }, { 1, -3, 2 } };
//		int[][] arr = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
//		int[][] arr = { { 3, -20, 30 }, { -3, 4, 0 } };
//		System.out.println(NonOptimal(arr));
		System.out.println(Optimal(arr));
	}

	private static int Optimal(int[][] arr) {
		int[][] dp = new int[arr.length + 1][arr[0].length + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][arr[0].length] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[arr.length][i] = Integer.MAX_VALUE;
		}

		dp[arr.length][arr[0].length - 1] = 1;
		dp[arr.length - 1][arr[0].length] = 1;
		dp[arr.length][arr[0].length] = 1;
		if (arr[arr.length - 1][arr[0].length - 1] <= 0) {
			dp[arr.length - 1][arr[0].length - 1] = -1 * arr[arr.length - 1][arr[0].length - 1] + 1;
		} else {
			dp[arr.length - 1][arr[0].length - 1] = 1;
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - arr[i][j];
				if (dp[i][j] < 1)
					dp[i][j] = 1;
			}
		}

		return dp[0][0];
	}

	public static int NonOptimal(int[][] arr) {
		traverse(arr, 0, 0, arr.length - 1, arr[0].length - 1, arr[0][0], arr[0][0]);
		System.out.println(MIN_RES);
		if (MIN_RES >= 0) {
			return (1);
		} else {
			return (-1 * MIN_RES + 1);
		}
	}

	private static int MIN = Integer.MAX_VALUE;
	private static int MIN_RES = Integer.MIN_VALUE;
	private static int BEST_PATH = Integer.MIN_VALUE;

	private static void traverse(int[][] dungeon, int x, int y, int M, int N, int sum, int min) {
		MIN = Math.min(MIN, min);

		if (x == M && y == N) {
			System.out.println(sum + " and " + MIN);
			MIN_RES = Math.max(MIN, MIN_RES);
			MIN = Integer.MAX_VALUE;
			BEST_PATH = Math.max(BEST_PATH, sum);
			return;
		}
		if (x == M && y != N) {
			traverse(dungeon, x, y + 1, M, N, sum + dungeon[x][y + 1], Math.min(min, sum + dungeon[x][y + 1]));
		} else if (x != M && y == N) {
			traverse(dungeon, x + 1, y, M, N, sum + dungeon[x + 1][y], Math.min(min, sum + dungeon[x + 1][y]));
		} else {
			traverse(dungeon, x, y + 1, M, N, sum + dungeon[x][y + 1], Math.min(min, sum + dungeon[x][y + 1]));
			traverse(dungeon, x + 1, y, M, N, sum + dungeon[x + 1][y], Math.min(min, sum + dungeon[x + 1][y]));
		}
	}

}
