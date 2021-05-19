package April.WeekFour;

public class CommonSubSequence {

	public static void main(String[] args) {
		String a = "mhunuzqrkzsnidwbun";
		String b = "szulspmhwpazoxijwbq";
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		System.out.println(longestCommonSubsequence(A, B, A.length, B.length));
	}

	private static int longestCommonSubsequence(char[] a, char[] b, int m, int n) {
		int[][] L = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (a[i - 1] == b[j - 1]) {
					L[i][j] = 1 + L[i - 1][j - 1];
				} else
					L[i][j] = Math.max(L[i][j - 1], L[i - 1][j]);
			}
		}
		return L[m][n];
	}

}
