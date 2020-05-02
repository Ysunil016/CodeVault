package April.WeekThree;

public class MinPathSum {

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(getSum(arr));
	}

	static int getSum(int[][] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		int[][] dynamic = new int[arr.length][arr[0].length];
		for (int i = 0; i < dynamic.length; i++) {
			for (int j = 0; j < dynamic[i].length; j++) {
				// Making Sum;
				dynamic[i][j] += arr[i][j];
				if (i > 0 && j > 0) {
					dynamic[i][j] += Math.min(dynamic[i - 1][j], dynamic[i][j - 1]);
				} else if (i > 0) {
					dynamic[i][j] += dynamic[i - 1][j];
				} else if (j > 0) {
					dynamic[i][j] += dynamic[i][j - 1];
				}
			}
		}
		return dynamic[dynamic.length - 1][dynamic[0].length - 1];
	}

}
