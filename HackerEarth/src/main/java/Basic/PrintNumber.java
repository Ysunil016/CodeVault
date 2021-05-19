package Basic;

import java.util.Scanner;

public class PrintNumber {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int count = scan.nextInt();
		int[] ar = new int[count];
		for (int i = 0; i < count; i++) {
			ar[i] = scan.nextInt();
		}

		for (int i = 0; i < count; i++) {
			System.out.print(ar[i] + " ");
		}

	}

}
