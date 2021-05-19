package Array;

public class Spirally_Traversing_Matrix {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

//		getCircularElements(0, arr, 5, 4);
//		getCircularElements(1, arr, 4, 3);

		int N = arr.length;
		int M = arr[0].length;
		int sum = 0;
		int ignite = 0;
		int fR = M * N;

		while (sum != fR) {
			sum += 2 * (N - 1) + (2 * (M - 1));
			getCircularElements(ignite, arr, N, M);
			M -= 2;
			N -= 2;
			ignite++;
		}

	}

	static void getCircularElements(int t, int[][] arr, int N, int M) {
		for (int i = t; i < M + t; i++) {
			System.out.print(arr[t][i] + " ");
		}
		for (int i = t + 1; i < N + t; i++) {
			System.out.print(arr[i][M - 1 + t] + " ");
		}
		for (int i = M - 2 + t; i >= t; i--) {
			System.out.print(arr[N + t - 1][i] + " ");
		}
		for (int i = N - 2 + t; i > t; i--) {
			System.out.print(arr[i][t] + " ");
		}
	}

}
