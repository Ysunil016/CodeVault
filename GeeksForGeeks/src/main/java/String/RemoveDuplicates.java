package String;

import java.util.Scanner;

public class RemoveDuplicates {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int test = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < test; i++) {
			String input = "";
			input += scan.nextLine();
			System.out.println(removeDups(input));
		}
	}

	static String removeDups(String in) {
		char[] alphaStore = new char[256];
		char[] input = in.toCharArray();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			if (input[i] == ' ') {
				if (alphaStore[0] != 1) {
					res.append(input[i]);
					alphaStore[0] = 1;
				}
			} else {
				if (alphaStore[Integer.valueOf(input[i])] != 1) {
					res.append(input[i]);
					alphaStore[Integer.valueOf(input[i])] = 1;
				}
			}
		}
		return new String(res);
	}

}
