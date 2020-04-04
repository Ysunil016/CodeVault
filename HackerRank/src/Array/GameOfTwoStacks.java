package Array;

import java.util.Scanner;

public class GameOfTwoStacks {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int tst = scan.nextInt();
		for (int i = 0; i < tst; i++) {
			int[] a = new int[scan.nextInt()];
			int[] b = new int[scan.nextInt()];
			int key = scan.nextInt();
			for (int m = 0; m < a.length; m++) {
				a[m] = scan.nextInt();
			}
			for (int m = 0; m < b.length; m++) {
				b[m] = scan.nextInt();
			}
			System.out.print(twoStacks(key, a, b)+" ");
		}

	}

	static int twoStacks(int x, int[] a, int[] b) {
		int counter = 0;
		int aLength = 0;
		int bLength = 0;

		int sumHolder = 0;
		if (a.length != 0 && b.length != 0)
			while ((bLength < b.length && aLength < a.length)) {
				if (a[aLength] < b[bLength]) {
					sumHolder += a[aLength];
					aLength++;
				} else {
					sumHolder += b[bLength];
					bLength++;
				}
				if (x < sumHolder)
					break;
				counter++;
			}

		if (aLength != a.length && bLength == b.length) {
			while (aLength < a.length) {
				sumHolder += a[aLength];
				if (x < sumHolder)
					break;
				aLength++;
				counter++;
			}
		}
		if (bLength != b.length && aLength == a.length) {
			while (bLength < b.length) {
				sumHolder += b[bLength];
				if (x < sumHolder)
					break;
				bLength++;
				counter++;
			}
		}

		return counter;
	}

}
