package String;

public class RomanNumberToInteger {

	public static void main(String[] args) {
		String input = "MCMIV";
		System.out.println(getIntegerFromRoman(input));
	}

	static int getIntegerFromRoman(String in) {
		char[] allVal = in.toCharArray();
		int res = 0;
		for (int i = 0; i < allVal.length - 1; i++) {
			if (valOfElem(allVal[i]) < valOfElem(allVal[i + 1])) {
				res -= valOfElem(allVal[i]);
			} else {
				res += valOfElem(allVal[i]);
			}
		}
		res += valOfElem(allVal[in.length() - 1]);

		return res;
	}

	static int valOfElem(char input) {
		switch (input) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

}
