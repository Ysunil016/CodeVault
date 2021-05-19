package Basic;

import java.util.Scanner;

public class Palindrome {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String in = scan.next();
		if (isPalidrome(in)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	static boolean isPalidrome(String in) {
		char[] inChar = in.toCharArray();
		int chLen = inChar.length;
		for (int i = 0; i < Math.ceil(chLen / 2); i++) {
			if (inChar[i] != inChar[chLen - 1 - i]) {
				return false;
			}
		}
		return true;
	}

}
