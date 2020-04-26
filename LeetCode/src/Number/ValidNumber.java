package Number;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumber("-1."));
//		System.out.println(isNumber("  0.1"));
//		System.out.println(isNumber("abc"));
//		System.out.println(isNumber("1 a"));
//		System.out.println(isNumber("2e10"));
//		System.out.println(isNumber(" -90e3   "));
//		System.out.println(isNumber(" 1e"));
//		System.out.println(isNumber("e3"));
//		System.out.println(isNumber(" 6e-1"));
//		System.out.println(isNumber(" 99e2.5"));
//		System.out.println(isNumber("53.5e93"));
//		System.out.println(isNumber(" --6"));
//		System.out.println(isNumber("+-3"));
//		System.out.println(isNumber("95a54e53"));
	}

	public static boolean isNumber(String s) {
		// Stripping for WhiteSpaces
		s = s.strip();

		boolean canHaveSign = true;
		boolean canHaveDecimal = true;
		boolean hasValidE = false;
		char[] chAr = s.toCharArray();
		if (chAr.length == 0)
			return false;

		int t = 0;
		// Checking if First Index has Sign
		if (chAr[0] == '-' || chAr[0] == '+') {
			canHaveSign = false;
			canHaveDecimal = false;
			t++;
		}

		if (chAr[0] == '.') {
			canHaveDecimal = false;
			canHaveSign = false;
			t++;
			if (chAr.length == 1)
				return false;
		}

		while (t < chAr.length) {
			char val = chAr[t];
			t++;
			if (val == 'e') {
				if (hasValidE) {
					canHaveSign = true;
					canHaveDecimal = false;
				} else
					return false;
			} else if (val == '+' || val == '-') {
				if (canHaveSign) {
					canHaveSign = false;
					canHaveDecimal = false;
				}
				else
					return false;
			} else if (val == '.') {
				if (canHaveDecimal) {
					canHaveDecimal = false;
					canHaveSign = false;
				}
				else
					return false;
			} else if ((val <= '9' && val >= '0')) {
				canHaveSign = false;
				canHaveDecimal = true;
				hasValidE = true;
				continue;
			} else
				return false;
		}

		char lastNode = chAr[chAr.length - 1];
		if (lastNode == 'e' || lastNode == '+' || lastNode == '-')
			return false;

		return true;
	}

}
