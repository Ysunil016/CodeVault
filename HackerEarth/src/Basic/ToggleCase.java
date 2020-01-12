package Basic;

import java.util.Scanner;

public class ToggleCase {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String in = scan.next();
		System.out.println(getToggleCase(in));
	}

	static String getToggleCase(String in) {
		char[] chA = in.toCharArray();
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < chA.length; i++) {
			boolean isLower = Character.isLowerCase(chA[i]);
			if (!isLower) {
				strB.append(Character.toLowerCase(chA[i]));
			} else {
				strB.append(Character.toUpperCase(chA[i]));
			}
		}
		return new String(strB);
	}

}
