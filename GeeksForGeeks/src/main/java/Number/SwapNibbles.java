package Number;

import java.util.Scanner;

public class SwapNibbles {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int tC = scan.nextInt();
		for (int i = 0; i < tC; i++) {
			System.out.println(getSwapped(scan.nextInt()));
		}
	}

	static int getSwapped(int data) {
		int first = data & 0xf;
		int second = data & 0xf0;
		// Right Shift for Second
		second = second >>> 4;
//		Left Shift for First
		first = first << 4;
		return first | second;
	}

}
