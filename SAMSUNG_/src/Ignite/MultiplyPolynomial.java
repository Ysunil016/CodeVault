package Ignite;

public class MultiplyPolynomial {

	public static void main(String[] args) {

		int aSize = 4;
		int bSize = 3;
		int[] aAr = new int[aSize];
		int[] bAr = new int[bSize];

		aAr[0] = 1;
		aAr[1] = 0;
		aAr[2] = 3;
		aAr[3] = 2;

		bAr[0] = 2;
		bAr[1] = 0;
		bAr[2] = 4;

		int[] result = multiplyPolynomial(aAr, bAr);
		for (int x : result)
			System.out.print(" " + x);

	}

	static int[] multiplyPolynomial(int[] A, int[] B) {
		int[] result = new int[A.length + B.length - 1];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				result[i + j] = result[i + j] + A[i] * B[j];
			}
		}
		return result;
	}

}
