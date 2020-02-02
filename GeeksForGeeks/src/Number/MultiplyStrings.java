package Number;

import java.math.BigInteger;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String multiply(String a, String b) {
		BigInteger aN = new BigInteger(a);
		BigInteger bN = new BigInteger(b);
		return String.valueOf(aN.multiply(bN));
	}

}
