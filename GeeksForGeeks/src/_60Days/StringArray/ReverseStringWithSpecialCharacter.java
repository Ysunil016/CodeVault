package _60Days.StringArray;

public class ReverseStringWithSpecialCharacter {

	public static void main(String[] args) {
		System.out.println(reverseString("a%b@def^"));
	}

	// Time - O(n)
	// Space - O(n) - Builder
	private static String reverseString(String str) {
		// Making String of Just Valid Char
		char[] strArray = str.toCharArray();
		StringBuilder strBuilder = new StringBuilder();
		for (char x : strArray) {
			if ((x <= 90 && x >= 64) || (x >= 97 && x <= 122)) {
				strBuilder.append(x);
			}
		}
		// Reverse String
		strBuilder.reverse();

		// Making Reverse Buffer
		int bIndex = 0;
		for (int i = 0; i < strArray.length; i++) {
			char x = strArray[i];
			if ((x <= 90 && x >= 64) || (x >= 97 && x <= 122)) {
				strArray[i] = strBuilder.charAt(bIndex);
				bIndex++;
			}
		}

		return new String(strArray);
	}

}
