package Number;

import java.util.Scanner;

public class Palindrome {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int tC = scan.nextInt();
		for (int i = 0; i < tC; i++) {
			System.out.println(isPalidrome(scan.nextInt()));
		}
	}

	static String isPalidrome(int num) {
		
		return "Yes";
	}

}
