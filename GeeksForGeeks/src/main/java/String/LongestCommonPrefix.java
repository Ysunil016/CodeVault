package String;

import java.util.Scanner;

public class LongestCommonPrefix {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int inputCount = scan.nextInt();
		String[] allString = new String[inputCount];
		for (int j = 0; j < inputCount; j++) {
			String str = scan.next();
			allString[j] = str;
		}
		System.out.println(commonPrefix(allString, inputCount));
	}

	static String commonPrefix(String arr[], int n) {
		String prefix = arr[0];

		for (int i = 1; i <= n - 1; i++) {
			prefix = commonPrefixUtil(prefix, arr[i]);
		}

		return (prefix);
	}

	static String commonPrefixUtil(String str1, String str2) {
		String result = "";
		int n1 = str1.length(), n2 = str2.length();

		// Compare str1 and str2
		for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
			if (str1.charAt(i) != str2.charAt(j)) {
				break;
			}
			result += str1.charAt(i);
		}
		
		if(result.length()==0) return String.valueOf(-1);

		return (result);
	}

}
