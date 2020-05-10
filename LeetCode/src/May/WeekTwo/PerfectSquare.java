package May.WeekTwo;

public class PerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSqr(2147395600));
	}

	public static boolean isPerfectSquare(int num) {
		int Counter = 1;
		int Product = 1;
		while (Product < num) {
			Product = Counter * Counter;
			Counter++;
		}
		if (Product == num) {
			return true;
		}
		return false;
	}

	public static boolean isPerfectSqr(int num) {
		if (num == 1)
			return true;

		int low = 1;
		int high = num / 2;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid == num / mid && num % mid == 0) {
				return true;
			} else if (mid < num / mid) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;

	}

}
