package Numbers;

public class Partition {

	public static void main(String[] args) {

//		int r[] = minPartValue(11, new int[2]); // 11 Input
//		System.out.println(r[0] + " and " + r[1]); // Output 8 and 3
//
//		int rO[] = minPartValue(44, new int[2]); // 44 Input
//		System.out.println(rO[0] + " and " + rO[1]); // Output 24 and 20
//
//		int r1[] = minPartValue(69, new int[2]); // 69 Input
//		System.out.println(r1[0] + " and " + r1[1]); // Output 36 and 33

		int r2[] = minPartValueNaieve(11, new int[2]); // 69 Input
		System.out.println(r2[0] + " and " + r2[1]); // Output 36 and 33

//		int r3[] = minPartValueNaieve(17, new int[2]); // 69 Input
//		System.out.println(r3[0] + " and " + r3[1]); // Output 36 and 33

	}

	// O(n)
	private static int[] minPartValue(int num, int[] out) {
		int fResult = num;
		for (int i = num; i > 0; i--) {
			int x = num - i;
			if (x % 2 == 0 && i % 3 == 0) {
				int diff = Math.abs(x - i);
				if (diff < fResult) {
					out[0] = i;
					out[1] = x;
					fResult = diff;
				}
			}
			if (x % 3 == 0 && i % 2 == 0) {
				int diff = Math.abs(x - i);
				if (diff < fResult) {
					out[0] = i;
					out[1] = x;
					fResult = diff;
				}
			}
		}
		return out;
	}

	// O(n^2)
	private static int[] minPartValueNaieve(int num, int[] out) {
		int fResult = num;
		for (int i = num; i > 0; i--) {
			for (int j = i - 1; j > 0; j--) {
				if ((i + j == num) && (i % 3 == 0 && j % 2 == 0 || i % 2 == 0 && j % 3 == 0)) {
					int diff = Math.abs(i - j);
					if (diff < fResult) {
						out[0] = i;
						out[1] = j;
						fResult = diff;
					}

				}
			}
		}
		return out;
	}

}
