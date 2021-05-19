package Number;

import java.util.Scanner;

public class SetBit {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int tC = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < tC; i++) {
			int sc = scan.nextInt();
			System.out.println(getBitsCount(sc));
		}
	}

	static int getBitsCount(int number) {
		int count = 0;
		while (number > 0) {
			number &= (number - 1);
			count++;
		}
		return count;
	}

}
