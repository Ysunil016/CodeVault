package Number;

import java.util.Scanner;

public class ChangeEvenBit2Zero {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int tc = scan.nextInt();
		for (int i = 0; i < tc; i++) {
			System.out.println(getFunk(scan.nextInt()));
		}
	}

	static int getFunk(int data) {
		// 32 Bits for INT
		return data & 0xaaaaaaaa;
	}
}
