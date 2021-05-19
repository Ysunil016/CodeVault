package August;

import java.util.Arrays;

public class H_Index {

	public static void main(String[] args) {
		System.out.println(hIndex(new int[] { 0, 1, 3, 5, 6 }));
	}

	public static int hIndex(int[] x) {
		if (x.length == 0)
			return 0;

		Arrays.sort(x);
		int result = 0;
		for (int i = x.length - 1; i >= 0; i--) {
			int cT = x.length - i;
			if (x[i] >= cT) {
				result = cT;
			} else {
				break;
			}
		}
		return result;
	}
}
