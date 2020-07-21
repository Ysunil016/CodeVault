package Array;

public class FindMissing {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 1, 4, 2, 5 };
		System.out.println(findMissing(a, b));
	}

	private static int findMissing(int[] x, int[] y) {
		int result = 0;
		for (int c : x) {
			result ^= c;
		}
		for (int c : y) {
			result ^= c;
		}
		return result;
	}

}
