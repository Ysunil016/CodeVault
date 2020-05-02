package May.WorkOne;

public class FirstBadVersion {

	public static void main(String[] args) {

		System.out.println(recursiveA(1, 2126753390));
	}

	public static int getBadVersion(int n) {
		int left = 1;
		int right = n;
		while (left < right) {
			int mid = left + (right - left) / 2;
			System.out.println(mid);
			if (getV(mid))
				right = mid;
			else
				left = mid + 1;
		}
		return left;
	}

	public static boolean getV(int n) {
		if (n >= 1702766719)
			return true;
		return false;
	}

	public static int recursiveA(int left, int right) {
		if (left == right)
			return left;

		int mid = left + (right - left) / 2;
		if (getV(mid)) {
			return recursiveA(left, mid);
		} else {
			return recursiveA(mid + 1, right);
		}

	}

}
