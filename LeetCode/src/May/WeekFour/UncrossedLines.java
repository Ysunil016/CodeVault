package May.WeekFour;

public class UncrossedLines {

	public static void main(String[] args) {
		int[] A = new int[] { 2, 5, 1, 2, 5 };
		int[] B = new int[] { 10, 5, 2, 1, 5, 2 };
		System.out.println(maxUncrossedLines(A, B));
	}

	public static int maxUncrossedLines(int[] A, int[] B) {
		int[][] ARRAY_DY = new int[A.length][B.length]; // All 0
		
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]) {
					if (i > 0 && j > 0) {
						ARRAY_DY[i][j] = ARRAY_DY[i - 1][j - 1] + 1;
					} else {
						ARRAY_DY[i][j] = 1;
					}
				} else {
					if (i > 0 && j > 0) {
						ARRAY_DY[i][j] = Math.max(ARRAY_DY[i][j - 1], ARRAY_DY[i - 1][j]);
					} else {
						if (i == 0 && j != 0)
							ARRAY_DY[i][j] = ARRAY_DY[i][j - 1];
						else if (i != 0 && j == 0)
							ARRAY_DY[i][j] = ARRAY_DY[i - 1][j];
					}
				}

			}
		}
		return ARRAY_DY[A.length - 1][B.length - 1];
	}

}
