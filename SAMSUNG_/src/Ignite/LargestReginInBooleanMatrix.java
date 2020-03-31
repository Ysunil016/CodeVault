package Ignite;

public class LargestReginInBooleanMatrix {

	static int ROW, COL, count = 0;

	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 1, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1 } };
		ROW = 4;
		COL = 5;
		System.out.println(largestRegion(arr));
	}

	// Main Function that Finds the Max of Path of 1's
	static int largestRegion(int[][] Matrix) {
		boolean[][] isVisited = new boolean[ROW][COL];
		int result = 0;
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				// Optimising with isVisited Boolean Array
				if (Matrix[r][c] == 1 && !isVisited[r][c]) {
					count = 1;
					DFS(Matrix, r, c, isVisited);
					result = Math.max(result, count);
				}
			}
		}
		return result;
	}

//	Depth Traversing based on Conditions Meeting True.
	static void DFS(int[][] matrix, int r, int c, boolean[][] isVisited) {
		int[] rowNeigh = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colNeigh = { -1, 0, 1, -1, 1, -1, 0, 1 };
		isVisited[r][c] = true;
		for (int i = 0; i < 8; i++) {
			// Checking if Next Index w.r.t [r][c] is safe to visit or not.
			if (isSafe(matrix, r + rowNeigh[i], c + colNeigh[i], isVisited)) {
				count++;
				DFS(matrix, r + rowNeigh[i], c + colNeigh[i], isVisited);
			}
		}
	}

	// Condition to Check for an Index whether it is falling within Matrix and Is It 1.
	static boolean isSafe(int[][] matrix, int row, int col, boolean[][] isVisited) {
		if ((row >= 0 && row < ROW) && (col >= 0 && col < COL) && (matrix[row][col] == 1) && !isVisited[row][col])
			return true;
		return false;
	}

}
