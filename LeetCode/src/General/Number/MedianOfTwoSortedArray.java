package General.Number;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		int[] ar1 = { 1, 2 };
		int[] ar2 = { 3, 4 };
		int[] result = new int[ar1.length + ar2.length];
		mergeArray(result, ar1, ar2);
		int median = ar1.length + ar2.length;
		if (median % 2 == 0) {
			System.out.println((double) ((result[(median / 2) - 1] + result[median / 2])) / 2);
		} else
			System.out.println(result[median / 2]);
	}

	static void mergeArray(int[] result, int[] a, int[] b) {
		int first = 0;
		int second = 0;
		for (int i = 0; i < a.length + b.length; i++) {
			if (first < a.length && second < b.length)
				if (a[first] < b[second]) {
					result[i] = a[first];
					first++;
				} else {
					result[i] = b[second];
					second++;
				}
			else {
				if (second == b.length && first < a.length) {
					result[i] = a[first];
					first++;
				}
				if (first == a.length && second < b.length) {
					result[i] = b[second];
					second++;
				}
			}
		}
	}

}
