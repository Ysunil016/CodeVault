package Array;

import java.util.Scanner;

public class OddDivisor {

	static Scanner scan = new Scanner(System.in);

	public static void main(String args[]) throws Exception {
		System.out.println(sum(110) % 30);

	}

	static double sum(int n) {
		if (n == 0)
			return 0;
		if (n % 2 == 1) {
			return square((n + 1) / 2) + sum(n / 2);
		} else {
			return square(n / 2) + sum(n / 2);
		}
	}

	static double square(double n) {
		return n * n;
	}
}
