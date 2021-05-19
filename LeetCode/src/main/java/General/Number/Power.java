package General.Number;

public class Power {

	public static void main(String[] args) {
		System.out.println(findPow(2, -2147483648));
	}

	static double findPow(double x, int n) {
		double result = myPow(x, n);
		if (result == Double.POSITIVE_INFINITY) {
			return 0;
		} else
			return result;
	}

	static double myPow(double x, int n) {

		if (n == 1)
			return x;

		if (x == 0)
			return 0;
		if (n == 1)
			return x;
		if (n == 0)
			return 1;

		if (n > 0) {
			double temp = myPow(x, n / 2);
			if (n % 2 == 0)
				return temp * temp;
			else
				return x * temp * temp;
		} else {
			n *= -1;
			double temp = myPow(x, n / 2);
			if (n % 2 == 0)
				return 1 / (temp * temp);
			else
				return 1 / (x * temp * temp);
		}

	}

}
