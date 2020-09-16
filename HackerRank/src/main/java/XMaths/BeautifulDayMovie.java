package XMaths;

public class BeautifulDayMovie {

	public static void main(String[] args) {
		System.out.println(beautifulDays(49860, 205494, 155635764));
	}

	static int beautifulDays(int i, int j, int k) {
		int Result = 0;
		// 6XX
		for (int t = i; t <= j; t++) {
			if (Math.abs(t - reverse(t)) % k == 0)
				Result += 1;
		}
		return Result;
	}

	static int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int lsb = x % 10;
			if (lsb != 0) {
				result *= 10;
				result += lsb;
			}
			x = x / 10;
		}
		return result;
	}
}
