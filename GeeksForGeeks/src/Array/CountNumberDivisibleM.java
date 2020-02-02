package Array;

import java.util.Scanner;

public class CountNumberDivisibleM {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int testCase = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < testCase; i++) {
			System.out.println(getDiv(scan.nextInt(), scan.nextInt(), scan.nextInt()));
		}
	}

	static int getDiv(int start, int end, int divBy) {
		int counter = 0;
		for (int i = start; i <= end; i++) {
			if (i % divBy == 0)
				counter++;
		}
		return counter;
	}

}
