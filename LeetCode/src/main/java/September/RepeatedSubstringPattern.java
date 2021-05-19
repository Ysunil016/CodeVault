package September;

public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("aba"));
	}

	public static boolean repeatedSubstringPattern(String S) {
		String currentString = "";

		for (int I = 0; I < S.length(); I++) {

			currentString += S.charAt(I);
			if (checkForSubString(currentString, S)) {
				return true;
			}
		}
		return false;
	}

	static boolean checkForSubString(String subString, String Y) {
		int subLen = subString.length();
		int stringLen = Y.length();

		int startIndex = subLen;

		if (subLen == stringLen) {
			return false;
		}

		while (startIndex <= Y.length() && (startIndex + subLen) <= Y.length()
				&& subString.equals(Y.substring(startIndex, startIndex + subLen))) {
			startIndex += subLen;
		}
		if (startIndex == Y.length())
			return true;

		return false;
	}

}
