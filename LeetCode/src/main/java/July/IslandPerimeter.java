package July;

public class IslandPerimeter {

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(islandPerimeter(grid));
	}

	public static int islandPerimeter(int[][] grid) {
		int parameter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {

					if (j - 1 < 0 || grid[i][j - 1] == 0) {
						parameter += 1;
					}
					if (j + 1 > grid[i].length - 1 || grid[i][j + 1] == 0) {
						parameter += 1;
					}
					if (i - 1 < 0 || grid[i - 1][j] == 0) {
						parameter += 1;
					}
					if (i + 1 > grid.length - 1 || grid[i + 1][j] == 0) {
						parameter += 1;
					}

				}
			}
		}
		return parameter;
	}

}
