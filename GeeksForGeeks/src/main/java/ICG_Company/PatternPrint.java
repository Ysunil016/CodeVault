package ICG_Company;

import java.util.Scanner;

public class PatternPrint {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scan.nextInt();

		int Start = 1;
		int End = n * n + 1;

		for (int i = n * 2; i > 0; i = i - 2) {
			for (int X = n * 2; X > i; X = X - 2) {
				System.out.print("--");
			}
			int Z = i;
			for (Z = 1; Z <= i / 2; Z++) {
				System.out.print(Start++ + " ");
			}
			for (Z = 1; Z <= i / 2; Z++) {
				System.out.print(End++ + " ");
			}
			End = 10;

			System.out.println();
		}
	}

}
