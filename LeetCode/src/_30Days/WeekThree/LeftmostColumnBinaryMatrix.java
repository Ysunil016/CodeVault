package _30Days.WeekThree;

import java.util.LinkedList;
import java.util.List;

public class LeftmostColumnBinaryMatrix implements BinaryMatrix {

	public static void main(String[] args) {
		System.out.println(leftMostColumnWithOne(new BinaryMatrix() {
		}));
	}

	public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> list = binaryMatrix.dimensions();
		int Y = list.get(1) - 1;

		int Xr = 0;
		int Yr = Y;

		int rPointer = binaryMatrix.get(Xr, Yr);
		int rC = -1;
		boolean isNotEnd = true;
		while (isNotEnd) {
			// Traverse Left
			if (rPointer == 1) {
				rC = Yr;
				if (Yr != 0)
					rPointer = binaryMatrix.get(Xr, --Yr);
				else
					isNotEnd = false;
			} else {
				if (Xr != list.get(0) - 1)
					rPointer = binaryMatrix.get(++Xr, Yr);
				else
					isNotEnd = false;
			}
		}

		return rC;

	}

}

interface BinaryMatrix {

//	int[][] arr = { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 } };
	int[][] arr = { { 0, 0 }, { 0, 0 } };

	public default int get(int row, int col) {
		return arr[row][col];
	}

	public default List<Integer> dimensions() {
		List<Integer> a = new LinkedList<Integer>();
		a.add(2);
		a.add(2);
		return a;
	}
};
