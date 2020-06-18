package June.WeekThree;

public class HIndexII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 1, 3, 4, 5, 6, 8 };
		System.out.println(hIndex(arr));
	}

	public static int hIndex(int[] x) {
		if (x.length == 0)
			return 0;

		int l = 0;
		int r = x.length - 1;
		int res = 0;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (x[m] < x.length - m) {
				res = Math.max(res, x[m]);
				l = m + 1;
			}
			if (x[m] >= x.length - m) {
				r = m - 1;
			}
		}
		return x.length - l;
	}

}
