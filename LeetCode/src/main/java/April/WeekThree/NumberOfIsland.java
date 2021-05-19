package April.WeekThree;

public class NumberOfIsland {

	public static void main(String[] args) {
		char[][] arr = { { '1', '1', '1', '1', '0' }, { 1, '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0' } };
		System.out.println(findIsland(arr));
	}

	static int findIsland(char[][] arr) {
		if (arr == null || arr.length == '0')
			return '0';
		int islandCounter = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == '1')
					islandCounter += dfs(arr, i, j);
			}
		}
		return islandCounter;
	}

	// Making Depth Search to Converst all Connected 1't to Zero
	static int dfs(char arr[][], int i, int j) {

		if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == '0') {
			return 0;
		}

		if (arr[i][j] == '1')
			arr[i][j] = '0';

		dfs(arr, i + 1, j);
		dfs(arr, i - 1, j);
		dfs(arr, i, j + 1);
		dfs(arr, i, j - 1);

		return 1;
	}

}
