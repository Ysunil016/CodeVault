package July;

public class Pow {

	public static void main(String[] args) {
		System.out.println(myPow(0.0001, 2147483647));
	}

	public static double myPow(double x, int n) {
		if (n < 0)
			return getPowerNegative(x, n);
		else
			return getPowerPositive(x, n);
	}

	private static double getPowerNegative(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double XXX = getPowerNegative(x, n / 2);
		if (n % 2 == 0) {
			return XXX * XXX;
		} else {
			return 1 / x * XXX * XXX;
		}
	}

	private static double getPowerPositive(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double XXX = getPowerPositive(x, n / 2);
		if (n % 2 == 0) {
			return XXX * XXX;
		} else {
			return x * XXX * XXX;
		}
	}

}
