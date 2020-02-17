package Array;

public class PrintDiagonal {

	public static void main(String[] args) {
		int[][] matrix = { { 8, 2, 3, 9, 5 }, { 2, 5, 9, 2, 2 }, { 5, 4, 6, 8, 8 }, { 6, 8, 4, 9, 7 },
				{ 9, 2, 5, 7, 1 } };
		printDiagonal(matrix);

		/*
		 * int tC = scan.nextInt(); for(int i=0;i<tC;i++){ int size = scan.nextInt();
		 * int[][] arr = new int[size][size]; for(int k=0;k<size;k++) for(int
		 * j=0;j<size;j++) arr[k][j] = scan.nextInt();
		 * 
		 */
	}

	static void printDiagonal(int[][] arr) {
		for (int i = 0; i < arr.length; i++)
			getCorresponingCoordinates_LR(arr, 0, i);

		for (int i = 1; i < arr.length; i++)
			getCorresponingCoordinates_UD(arr, i, arr.length - 1);

	}

	static void getCorresponingCoordinates_LR(int[][] arr, int x, int y) {
		while (y >= 0) {
			System.out.print(arr[x][y] + " ");
			x = x + 1;
			y = y - 1;
		}
	}

	static void getCorresponingCoordinates_UD(int[][] arr, int x, int y) {
		int temp = x - 1;
		while (y != temp) {
			System.out.print(arr[x][y] + " ");
			x += 1;
			y -= 1;
		}
	}

}
