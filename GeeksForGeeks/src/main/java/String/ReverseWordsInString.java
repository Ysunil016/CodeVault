package String;

import java.util.Scanner;

public class ReverseWordsInString {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String input = "i.like.this.program.very.much";
		reverseString(input);
	}

	static void reverseString(String in) {
		String[] inAll = in.split("\\.");
		for (int i = inAll.length - 1; i > 0; i--) {
			System.out.print(inAll[i] + ".");
		}
		System.out.println(inAll[0]);
	}

}
