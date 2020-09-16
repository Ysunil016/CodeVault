package XMaths;

import java.math.BigInteger;

public class ExtraLongFactorial {

	public static void main(String[] args) {
		extraLongFactorials(25);
	}

	static void extraLongFactorials(int n) {
		System.out.println(findFact(n));
	}

	static BigInteger findFact(int n) {
		if (n == 0) {
			return BigInteger.valueOf(1);
		}
		return BigInteger.valueOf(n).multiply(findFact(n - 1));
	}

}
