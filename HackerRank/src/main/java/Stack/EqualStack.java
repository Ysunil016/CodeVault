package Stack;

public class EqualStack {

	public static void main(String[] args) {
		int[] a1 = { 3, 2, 1, 1, 1 };
		int[] a2 = { 4, 3, 2 };
		int[] a3 = { 1, 1, 4, 1 };

		System.out.println(getEqualStackPos(a1, a2, a3));

//		3 2 1 1 1
//		4 3 2
//		1 1 4 1

	}

	static int getEqualStackPos(int[] a1, int[] a2, int[] a3) {
		int sumA = 0;
		int sumB = 0;
		int sumC = 0;

		int sumAIndex = 0;
		int sumBIndex = 0;
		int sumCIndex = 0;

		for (int x : a1)
			sumA += x;
		for (int y : a2)
			sumB += y;
		for (int z : a3)
			sumC += z;

		while ((sumA != sumB) && (sumA != sumC) || ((sumA != 0) && (sumB != 0) && (sumC != 0))) {
			int maxSum = Math.max(Math.max(sumA, sumB), sumC);
			if (maxSum == sumA && maxSum == sumB && maxSum == sumC)
				break;

			if (maxSum == sumA) {
				sumA -= a1[sumAIndex];
				sumAIndex++;
			} else if (maxSum == sumB) {
				sumB -= a2[sumBIndex];
				sumBIndex++;
			} else if (maxSum == sumC) {
				sumC -= a3[sumCIndex];
				sumCIndex++;
			}
		}

		return sumA;
	}
}
