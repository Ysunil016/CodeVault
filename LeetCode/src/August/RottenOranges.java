package August;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
//		int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
//		int[][] grid = { { 1, 2 } };

		System.out.println(orangesRotting(grid));
	}

	public static int orangesRotting(int[][] grid) {
		int finalMinutes = 0;

		class Node {
			private int time;
			private int x, y;

			public Node(int time, int x, int y) {
				this.time = time;
				this.x = x;
				this.y = y;
			}
		}

		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Node(0, i, j));
				}
				if (grid[i][j] == 1) {
					if (hasSurrounding(grid, i, j)) {
						return -1;
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			Node cNode = queue.poll();
			finalMinutes = cNode.time;
			grid[cNode.x][cNode.y] = 2;
			if (cNode.x < grid.length - 1 && grid[cNode.x + 1][cNode.y] == 1) {
				grid[cNode.x + 1][cNode.y] = 2;
				queue.add(new Node(cNode.time + 1, cNode.x + 1, cNode.y));
			}
			if (cNode.y < grid[0].length - 1 && grid[cNode.x][cNode.y + 1] == 1) {
				grid[cNode.x][cNode.y + 1] = 2;
				queue.add(new Node(cNode.time + 1, cNode.x, cNode.y + 1));
			}
			if (cNode.x > 0 && grid[cNode.x - 1][cNode.y] == 1) {
				grid[cNode.x - 1][cNode.y] = 2;
				queue.add(new Node(cNode.time + 1, cNode.x - 1, cNode.y));
			}
			if (cNode.y > 0 && grid[cNode.x][cNode.y - 1] == 1) {
				grid[cNode.x][cNode.y - 1] = 2;
				queue.add(new Node(cNode.time + 1, cNode.x, cNode.y - 1));
			}
		}

		return (checkall(grid)) ? -1 : finalMinutes;
	}

	private static boolean checkall(int[][] arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[0].length; j++)
				if (arr[i][j] == 1)
					return true;
		return false;
	}

	private static boolean hasSurrounding(int[][] grid, int i, int j) {
		boolean isValid = true;
		if (i < grid.length - 1 && grid[i + 1][j] != 0) {
			isValid &= false;
		}
		if (j < grid[0].length - 1 && grid[i][j + 1] != 0) {
			isValid &= false;
		}
		if (i > 0 && grid[i - 1][j] != 0) {
			isValid &= false;
		}
		if (j > 0 && grid[i][j - 1] != 0) {
			isValid &= false;
		}
		return isValid;
	}
}
