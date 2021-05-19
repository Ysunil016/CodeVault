package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {
	static Scanner scan = new Scanner(System.in);

	static class item {
		int x = 0;
		int y = 0;

		public item(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
//		int testCase = scan.nextInt();
//		scan.nextLine();
//		for (int i = 0; i < testCase; i++) {
//			int row = scan.nextInt();
//			int column = scan.nextInt();
//			int[][] arr = new int[row][column];
//			for (int j = 0; j < row; j++)
//				for (int k = 0; k < column; k++)
//					arr[j][k] = scan.nextInt();
//			System.out.println(rotOrange(arr, row, column));
//		}

		int[][] arr = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		System.out.println(rotOrange(arr, 3, 5));

	}

	static boolean isValid(int x, int y, int row, int column) {
		return (x >= 0 && y >= 0 && x < row && y < column);
	}

	static boolean isEnd(item item) {
		return (item.x == -1 && item.y == -1);
	}

	static boolean isThereFrehOrange(int arr[][], int row, int column) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (arr[i][j] == 1)
					return true;
			}
		}
		return false;
	}

	static int rotOrange(int[][] arr, int row, int column) {
		Queue<item> store = new LinkedList<item>();
		item temp;
		int result = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (arr[i][j] == 2) {
					store.add(new item(i, j));
				}
			}
		}

		store.add(new item(-1, -1));

		System.out.println("Initially");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}

		while (!store.isEmpty()) {
			boolean isChange = false;

			while (!isEnd(store.peek())) {
				temp = store.peek();

				if (isValid(temp.x + 1, temp.y, row, column) && arr[temp.x + 1][temp.y] == 1) {
					if (!isChange) {
						result++;
						isChange = true;
					}
					// Make the orange rotten
					arr[temp.x + 1][temp.y] = 2;

					// push the adjacent orange to Queue
					temp.x++;
					store.add(new item(temp.x, temp.y));

					// Move back to current cell
					temp.x--;
				}

				// Check left adjacent cell that if it can be rotten
				if (isValid(temp.x - 1, temp.y, row, column) && arr[temp.x - 1][temp.y] == 1) {
					if (!isChange) {
						result++;
						isChange = true;
					}
					arr[temp.x - 1][temp.y] = 2;
					temp.x--;
					store.add(new item(temp.x, temp.y)); // push this cell to Queue
					temp.x++;
				}

				// Check top adjacent cell that if it can be rotten
				if (isValid(temp.x, temp.y + 1, row, column) && arr[temp.x][temp.y + 1] == 1) {
					if (!isChange) {
						result++;
						isChange = true;
					}
					arr[temp.x][temp.y + 1] = 2;
					temp.y++;
					store.add(new item(temp.x, temp.y)); // Push this cell to Queue
					temp.y--;
				}

				// Check bottom adjacent cell if it can be rotten
				if (isValid(temp.x, temp.y - 1, row, column) && arr[temp.x][temp.y - 1] == 1) {
					if (!isChange) {
						result++;
						isChange = true;
					}
					arr[temp.x][temp.y - 1] = 2;
					temp.y--;
					store.add(new item(temp.x, temp.y)); // push this cell to Queue
				}

				store.remove();
			}

			// Delimiter Removal
			store.remove();

			if (!store.isEmpty()) {
				store.add(new item(-1, -1));
			}

			System.out.println();

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}

		}

		System.out.println();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}

		return (isThereFrehOrange(arr, row, column)) ? -1 : result;
	}

}
