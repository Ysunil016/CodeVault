package _1388;

import java.util.Scanner;

public class CaptainFlintandLongVoyage {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int tC = scan.nextInt();
		for (int i = 0; i < tC; i++)
			System.out.println(getNumber(scan.nextInt()));
	}

	private static int getNumber(int digits) {
		int number = 0;
		for (int i = 0; i < digits; i++) {
			number *= 10;
			number += 9;
		}

		int result = Integer.MIN_VALUE;
		int finalNumber = number;

		for (int i = number - 1; i > number / 2; i--) {
			int r = i >> digits;
			if (r > result) {
				result = r;
				finalNumber = i;
			}
		}

		return finalNumber;
	}

}
