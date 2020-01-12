package Basic;

import java.util.Scanner;

public class SplitHouse {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
	//	int sz = scan.nextInt();
		char[] inA = scan.next().toCharArray();
		String isY = checkH(inA);
		System.out.println(isY);
		if (isY == "YES")
			SH(inA);

	}

	static void SH(char[] inA) {
		for (int i = 0; i < inA.length; i++) {
			if (inA[i] == '.') {
				inA[i] = 'B';
			}
			System.out.print(inA[i] + " ");
		}
	}

	static String checkH(char[] inA) {
		for (int i = 0; i < inA.length - 1; i++) {
			if (inA[i] == 'H' && inA[i + 1] == 'H') {
				return ("NO");
			}
		}
		return "YES";
	}
}
