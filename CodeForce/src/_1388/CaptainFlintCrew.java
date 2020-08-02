package _1388;

import java.util.Scanner;

public class CaptainFlintCrew {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int query = scan.nextInt();
		for (int i = 0; i < query; i++) {
			isValid(scan.nextInt());
		}
	}

	private static void isValid(int number) {
		if (number <= 30) {
			System.out.println("No");
		} else {
			System.out.println("YES");
			if (number == 36 || number == 40 || number == 44) {
				System.out.println(6 + " " + 10 + " " + 15 + " " + (number - 31));
			} else {
				System.out.println(6 + " " + 10 + " " + 14 + " " + (number - 30));
			}
		}
	}

}
