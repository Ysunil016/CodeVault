package Working;

public class RotateArrayBy90 {

	public static void main(String[] args) {
		// Lets Given Array is of 4*4
		// 1 2
		// 3 4

		// Lets Given Array is of 4*4
		// 1 2 3 4
		// 5 6 7 8
		// 9 10 11 12
		// 13 14 15 16

//		int[][] arr_2x2 = { { 1, 2 }, { 3, 4 } };
		int[][] arr_4x4 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

//		displaySquareMatrix(arr_2x2);
//		System.out.println();
//		rotateSquareMatrix(arr_2x2);
//		System.out.println();
//		displaySquareMatrix(arr_2x2);
//		System.out.println();
		displaySquareMatrix(arr_4x4);
		System.out.println();
		rotateSquareMatrix(arr_4x4);
		System.out.println();
		displaySquareMatrix(arr_4x4);

	}

	static void rotateSquareMatrix(int[][] arr) {
		int rotationRequired = arr.length / 2;
		int traverseLength = arr.length - 1;
		int startPoint = 0;

		System.out.println("Rotation Required " + rotationRequired);

		for (int rR = 0; rR < rotationRequired; rR++) {


			System.out.println();
			startPoint++;
			traverseLength -= 1;
		}

	}

	static void displaySquareMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

}
