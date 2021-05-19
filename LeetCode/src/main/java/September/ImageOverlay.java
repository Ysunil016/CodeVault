package September;

public class ImageOverlay {

	public static void main(String[] args) {
		int[][] A = { { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		int[][] B = { { 0, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 1, 0, 0 } };
		System.out.println(largestOverlap(A, B));
	}

	public static int largestOverlap(int[][] A, int[][] B) {
		int resultMax = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				resultMax = Math.max(resultMax, findOverLapping(A, B, i, j));
				resultMax = Math.max(resultMax, findOverLapping(B, A, i, j));
			}
		}
		return resultMax;
	}

	static int findOverLapping(int[][] A, int[][] B, int startI, int startJ) {
		int totalMax = 0;
		for (int i = 0; i < A.length - startI; i++) {
			for (int j = 0; j < A[0].length - startJ; j++) {
				if (A[i][j] == 1 && B[startI + i][startJ + j] == 1)
					totalMax++;
			}
		}

		return totalMax;
	}

}
