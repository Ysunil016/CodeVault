package Basic;

import java.util.Scanner;

public class PrimeNumber {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int primeN = scan.nextInt();
		if (primeN == 0 || primeN == 1)
			return;

		System.out.println(2 + " ");
		for (int i = 3; i < primeN; i++)
			if (isPrime(i))
				System.out.println(i + "");

	}

	static boolean isPrime(int number) {
		if (number % 2 == 0)
			return false;
		for (int i = 3; i < Math.sqrt(number) + 1; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

}
