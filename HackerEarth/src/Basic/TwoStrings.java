package Basic;

import java.util.Scanner;

public class TwoStrings {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int testCase = scan.nextInt();
		for (int i = 0; i < testCase; i++) {
			String one = scan.next();
			String two = scan.next();
			if (isIdentical(one, two))
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	static boolean isIdentical(String one, String two) {
		int sum = 0;
		if (one.length() != two.length())
			return false;
		int[] charS = new int[256];
		for (int i = 0; i < one.length(); i++) {
			Character t = one.charAt(i);
			int val = charS[t.hashCode()];
			charS[t.hashCode()] = ++val;

			Character s = two.charAt(i);
			int vals = charS[s.hashCode()];
			charS[s.hashCode()] = --vals;

		}

		for (int i = 0; i < 256; i++) {
			sum += charS[i];
			if ((sum != 0))
				return false;
		}

		return true;
	}

}
